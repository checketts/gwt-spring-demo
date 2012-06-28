package com.github.checketts.client.service;

import com.github.checketts.client.model.EventListBean;
import com.github.checketts.client.util.core.ClutchCallback;

public interface MainClutch {

    void getEvents(ClutchCallback<EventListBean> cb);

}
