package com.github.checketts.client.inject;


import com.github.checketts.client.ui.ApplicationShell;
import com.github.checketts.client.ui.Shell;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(Shell.class).to(ApplicationShell.class).in(Singleton.class);
        
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    }
}