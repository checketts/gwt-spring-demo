package com.github.checketts.client.inject;

import com.github.checketts.client.mvp.StartActivity;
import com.github.checketts.client.ui.core.Shell;
import com.github.checketts.client.ui.info.InfoActivity;
import com.github.checketts.client.util.core.ActivityProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public EventBus getEventBus();
    public Shell getAppShell();
    public PlaceHistoryHandler getPlaceHistoryHandler();
    
    public Provider<ActivityProxy<StartActivity>> getStartActivityProvider();
    public Provider<ActivityProxy<InfoActivity>> getInfoActivityProvider();
    
}
