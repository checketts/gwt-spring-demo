package com.github.checketts.client.util.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.inject.Inject;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Base class that implements autobean communication with the server
 * 
 * Clutch: it _shifts_ the data between client and server
 *  
 * @author clintchecketts
 *
 */
public abstract class DataClutch {
    private static final Logger LOG = Logger.getLogger(DataClutch.class.getName());
    EventBus eventBus;
    AutoBeanFactory beanFactory;
    
    @Inject
    public DataClutch(EventBus eventBus, AutoBeanFactory beanFactory) {
        this.eventBus = eventBus;
        this.beanFactory = beanFactory;
    }
    
    public EventBus getEventBus() {
        return eventBus;
    }
    
    protected <T> Request deleteRequest(String url, ClutchCallback<T> callback){
        RequestBuilder rBuilder = new RequestBuilder(RequestBuilder.DELETE, GWT.getHostPageBaseURL() +url);
        rBuilder.setHeader("Json-type", "autobeans");
        Request req = null;
        try {
            req = rBuilder.sendRequest("", new InnerCallback<T>(callback));
        }
        catch (RequestException e) {
            logError("Server connection error:",e,true);
        }
        
        return req;
    }

    protected <T> Request getRequest(String url, ClutchCallback<T> callback){
        RequestBuilder rBuilder = new RequestBuilder(RequestBuilder.GET, GWT.getHostPageBaseURL() +url);
        rBuilder.setHeader("Json-type", "autobeans");
        Request req = null;
        try {
            req = rBuilder.sendRequest("", new InnerCallback<T>(callback));
        }
        catch (RequestException e) {
            logError("Server connection error:",e,true);
        }
        
        return req;
    }

    protected <T,V> Request postRequest(String url, T beanParm,  ClutchCallback<V> callback){
        String paramAsJson = "";
        AutoBean<T> bean = AutoBeanUtils.getAutoBean(beanParm);
        if(bean != null){
            paramAsJson = AutoBeanCodex.encode(bean).getPayload();
        } else {
            //If the beanParm wasn't an autobean just send it as-is 
            if(beanParm != null) {
                paramAsJson = beanParm.toString();    
            }
        }
        
        RequestBuilder rBuilder = new RequestBuilder(RequestBuilder.POST, GWT.getHostPageBaseURL() +url);
        Request req = null;
        try {
            rBuilder.setHeader("Content-type", "application/json");
            rBuilder.setHeader("Json-type", "autobeans");
            req = rBuilder.sendRequest(paramAsJson,new InnerCallback<V>(callback));
        }
        catch (RequestException e) {
            logError("Server connection error:",e,true);
        }
        
        return req;
    }
    
    private void logError(String msg, Throwable e, boolean notifyUser) {
        LOG.log(Level.SEVERE,msg,e);
    }
    
    private class InnerCallback<T> implements RequestCallback{

        private ClutchCallback<T> callback;
        
        public InnerCallback(ClutchCallback<T> callback) {
            this.callback = callback;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public void onResponseReceived(Request request, Response response) {
            String text = response.getText();
            
            if(response.getStatusCode() == 200) {
                if(callback.getResultClass() != null && text != null && !text.isEmpty()) {
                    T data = null;
                    try {
                        if(Integer.class.equals(callback.getResultClass())) {
                            data = (T) Integer.valueOf(text);
                        } else if(String.class.equals(callback.getResultClass())) {
                            data = (T) text;
                        } else {
                            try {
                                data = AutoBeanCodex.decode(beanFactory, callback.getResultClass(), text).as();    
                            } catch(Exception e) {
                                LOG.log(Level.SEVERE,"Error parsing autobean: (common causes:1- check the injected BeanFactory can create this type of autobean;2- ensure Longs and Dates are sent as String)"+text,e);        
                            }
                                
                        }
                        
                            
                    } catch (Exception e) {
                        LOG.log(Level.SEVERE,"Error parsing return value:"+text,e);
                    }
                    
                    callback.onComplete(data);
                        
                } else {
                    callback.onComplete(null);
                }
                    
            } else if(response.getStatusCode() == 403) {
                //TODO not access denied: FeedbackEvent.fireErrorReport(eventBus,"Access Denied",true); 
            }else {
                RequestException ex =new RequestException("Request Error:"+response.getStatusCode()+" - "+response.getStatusText());
                logError("Request Error:"+response.getStatusCode()+" - "+response.getStatusText(),ex,true);
                callback.onError(ex);
            }
            
        }

        @Override
        public void onError(Request request, Throwable exception) {
            callback.onError(exception);
        }
        
    }
    
}
