package com.github.checketts.client.util.core;


import com.github.checketts.client.ui.core.Shell;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;

public abstract class BaseActivity <V extends IsWidget, P extends Place> extends AbstractActivity {
    protected Shell shell;
    protected V view;
    protected P place;
    protected EventBus eventBus;

    protected BaseActivity(EventBus eventBus, Shell applicationShell, V view) {
        this.eventBus = eventBus;
        this.shell = applicationShell;
        this.view = view;
    }

    @SuppressWarnings("unchecked")
    public Activity setPlace(Place place) {
        this.place = (P)place;
        return this;
    }
    
    /**
     * Use the web.bindery EventBus instead
     */
    @Override
    @Deprecated
    public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus) {
        start(panel, (EventBus)eventBus);
    }

    public abstract void start(AcceptsOneWidget panel, EventBus eventBus);
}
