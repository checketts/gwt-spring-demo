package com.github.checketts.client.inject;



import com.github.checketts.client.mvp.AppPlaceHistoryMapper;
import com.github.checketts.client.mvp.StartPlace;
import com.github.checketts.client.mvp.StartView;
import com.github.checketts.client.mvp.TokenizerContainer;
import com.github.checketts.client.service.MainClutch;
import com.github.checketts.client.service.MainClutchImpl;
import com.github.checketts.client.ui.StartViewImpl;
import com.github.checketts.client.ui.core.ApplicationShell;
import com.github.checketts.client.ui.core.Shell;
import com.github.checketts.client.ui.info.InfoView;
import com.github.checketts.client.ui.info.InfoViewImpl;
import com.github.checketts.client.util.core.AppActivityMapper;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(Shell.class).to(ApplicationShell.class).in(Singleton.class);
        bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(MainClutch.class).to(MainClutchImpl.class);
        
        bind(StartView.class).to(StartViewImpl.class).in(Singleton.class);
        bind(InfoView.class).to(InfoViewImpl.class).in(Singleton.class);
    }
    
    
    
    
    
    @Provides
    @Singleton
    public PlaceHistoryMapper createPlaceHistoryMapper(TokenizerContainer tf) {
        PlaceHistoryMapperWithFactory<TokenizerContainer> mapper = GWT.create(AppPlaceHistoryMapper.class);
        mapper.setFactory(tf);
        return mapper;
    }
    
    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
                                                 PlaceHistoryMapper historyMapper,
                                                 EventBus eventBus,
                                                 ActivityManager activityManager) {
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, getDefaultPlace());
        return historyHandler;
    }
    
    protected Place getDefaultPlace() {
        return new StartPlace();
    }

    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Provides
    @Singleton
    public ActivityManager getActivityManager(ActivityMapper mapper,
                                              EventBus eventBus,
                                              Shell shell) {

        ActivityManager activityManager = new ActivityManager(mapper, eventBus);
        activityManager.setDisplay(shell.getMainContent());
        return activityManager;
    }
}