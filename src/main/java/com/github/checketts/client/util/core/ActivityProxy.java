package com.github.checketts.client.util.core;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public final class ActivityProxy<A extends BaseActivity<?,?>> implements Activity {

    private final AsyncProvider<A> activityProvider;
    private BaseActivity<?,?> activity;
    private boolean cancelled;
    private Place place;

    @Inject
    public ActivityProxy(AsyncProvider<A> activityProvider) {
        this.activityProvider = activityProvider;
    }

    @Override
    public String mayStop() {
        if (activity != null) {
            return activity.mayStop();
        }
        return null;
    }

    @Override
    public void onCancel() {
        cancelled = true;
    }

    @Override
    public void onStop() {
        if (activity != null) {
            activity.onStop();
        }
    }

    @Override
    public void start(final AcceptsOneWidget panel, final com.google.gwt.event.shared.EventBus eventBus) {
        activityProvider.get(new AsyncCallback<A>() {

            @SuppressWarnings("deprecation")
            @Override
            public void onSuccess(A result) {
                // Do not start loaded activity if it has been canceled
                if (!cancelled) {
                    activity = (BaseActivity<?, ?>) result;
                    activity.setPlace(place);
                    activity.start(panel, eventBus);
                }
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error loading data, please refresh the page to update the application.");
            }
        });
    }
    
    public ActivityProxy<A> setPlace(Place place) {
        this.place = place;
        return this;
    }

}