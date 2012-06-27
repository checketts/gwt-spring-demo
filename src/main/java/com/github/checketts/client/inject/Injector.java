package com.github.checketts.client.inject;

import com.github.checketts.client.ui.Shell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public EventBus getEventBus();
    public Shell getAppShell();
}
