package com.github.checketts.client.util.core;

import com.github.checketts.client.ui.core.ActivityProvider;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper{
    public AppActivityMapper() {
        super();
    }

    @Override
    public Activity getActivity(Place place) {
        if(place instanceof ActivityProvider) {
            ActivityProxy<?> a = ((ActivityProvider)place).getActivityProvider().get();
            a.setPlace(place);
            return a;
        }
        return null;
    }
}
