package com.github.checketts.client.mvp;

import com.github.checketts.client.inject.Injector;
import com.github.checketts.client.ui.core.ActivityProvider;
import com.github.checketts.client.util.core.ActivityProxy;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;

public class StartPlace extends Place implements ActivityProvider{
    private String token;

    public StartPlace() {
        this("");
    }
    
    public StartPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    public Provider<? extends ActivityProxy<?>> getActivityProvider() {
        return Injector.INSTANCE.getStartActivityProvider();
    }
}
