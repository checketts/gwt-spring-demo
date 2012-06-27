package com.github.checketts.client.service;

import com.github.checketts.client.model.EventListBean;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface MainBeanFactory extends AutoBeanFactory {

    AutoBean<EventListBean> createEventList();
}
