package com.github.checketts.client.service;


import com.github.checketts.client.model.EventListBean;
import com.github.checketts.client.util.ClutchCallback;
import com.github.checketts.client.util.DataClutch;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class MainClutch extends DataClutch{
    
    @Inject
    public MainClutch(EventBus eventBus, MainBeanFactory beanFactory) {
        super(eventBus, beanFactory);
    }
    
//    @Override
    public void getEvents(ClutchCallback<EventListBean> cb) {
        getRequest("data/events",cb);
    }

}
