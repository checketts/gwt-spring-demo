package com.github.checketts.client.ui.info;

import com.github.checketts.client.inject.Injector;
import com.github.checketts.client.ui.core.ActivityProvider;
import com.github.checketts.client.util.core.ActivityProxy;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;

public class InfoPlace extends Place implements ActivityProvider{
    private String token;

    public InfoPlace() {
        this("");
    }
    
    public InfoPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    public Provider<? extends ActivityProxy<?>> getActivityProvider() {
        return Injector.INSTANCE.getInfoActivityProvider();
    }
}
