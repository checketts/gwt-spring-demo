package com.github.checketts.client.service;


import com.github.checketts.client.model.EventListBean;
import com.github.checketts.client.util.core.ClutchCallback;
import com.github.checketts.client.util.core.DataClutch;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class MainClutchImpl extends DataClutch implements MainClutch{
    
    @Inject
    public MainClutchImpl(EventBus eventBus, MainBeanFactory beanFactory) {
        super(eventBus, beanFactory);
    }
    
    @Override
    public void getEvents(ClutchCallback<EventListBean> cb) {
        getRequest("data/events",cb);
    }

}
