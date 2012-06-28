package com.github.checketts.client.util.core;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RestPlace extends Place {

    List<String> urlElements = new ArrayList<String>();

    public String getResource() {
        return get(0);
    }

    public void setResource(String resource) {
        set(0, resource);
    }

    public String getResourceId() {
        return get(1);
    }

    public void setResourceId(String resourceId) {
        set(1, resourceId);
    }

    public String getAction() {
        return get(2);
    }

    public void setAction(String action) {
        set(2, action);
    }

    public String getParamValue(String s) {
        String val = null;
        
        for(String parm: urlElements) {
            if(parm != null && parm.contains(":")) {
                String[] keyVal = parm.split(":");
                if(keyVal.length > 0 && keyVal[0].equalsIgnoreCase(s)) {
                    if(keyVal.length > 1) {
                        val = keyVal[1];
                        break;
                    }
                }
            }
        }
        
        return val;
    }
    
    public void putParam(String key, String val) {
        boolean wasOverwritten = false;
        
        for(int i = 0; i< urlElements.size();i++) {
            String parm = urlElements.get(i);
            if(parm.contains(":")) {
                String[] keyVal = parm.split(":");
                if(keyVal.length > 0 && keyVal[0].equalsIgnoreCase(key)) {
                    set(i, key+":"+val);
                    wasOverwritten = true;
                    break;
                }
            }
        }
        
        if(!wasOverwritten) {
            set(urlElements.size(), key+":"+val);
        }
    }
    
    public String get(int index) {
        try {
            return urlElements.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void set(int index, String parm) {
        if (index < 0) {
            throw new IllegalArgumentException("Unable to set url element on a negative index");
        }
        
        while(urlElements.size() <= index) {
            urlElements.add(null);    
        }
        
        urlElements.set(index, parm);
        
        //truncate null end elements
        ListIterator<String> it = urlElements.listIterator(urlElements.size());
        while(it.hasPrevious()) {
            if(it.previous() == null) {
                it.remove();
            } else {
                break;
            }
        }
    }

    public int getUrlElementCount() {
        return urlElements.size();
    }

    public static class RestTokenizer<T extends RestPlace> implements PlaceTokenizer<T> {

        @SuppressWarnings("unchecked")
        protected T createPlace() {
            return (T) new RestPlace();
        }

        @Override
        public T getPlace(String token) {

            T place = createPlace();

            // #prefix:element0/element1/element2
            if (token != null && token.length() > 0) {
                String[] parts = token.split("/");

                for (int i = 0; i < parts.length; i++) {
                    //Treat the 'null' string as a null value
                    if(!"null".equalsIgnoreCase(parts[i])) {
                        place.set(i, parts[i]);    
                    }
                    
                }
            }

            return place;
        }

        @Override
        public String getToken(T place) {
            StringBuilder b = new StringBuilder();
            int urlSize = place.getUrlElementCount();
            for(int i = 0; i < urlSize; i++) {
                b.append(place.get(i));
                if(i<urlSize -1) {
                    b.append("/");
                }
            }
            
            return b.toString();
        }
    }


}
