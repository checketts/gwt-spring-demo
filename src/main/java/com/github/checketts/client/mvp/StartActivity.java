package com.github.checketts.client.mvp;

import com.github.checketts.client.model.EventListBean;
import com.github.checketts.client.service.MainClutch;
import com.github.checketts.client.ui.core.Shell;
import com.github.checketts.client.ui.info.InfoPlace;
import com.github.checketts.client.util.core.BaseActivity;
import com.github.checketts.client.util.core.ClutchCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class StartActivity extends BaseActivity<StartView, Place> {

    private MainClutch clutch;
    
    @Inject
    protected StartActivity(EventBus eventBus, Shell applicationShell, StartView view, MainClutch mClutch) {
        super(eventBus, applicationShell, view);
        clutch = mClutch;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        shell.showSidebar();
        shell.getSidebar().clear();
        shell.getSidebar().addPlace("Nav Sample", new InfoPlace(""));
        
        clutch.getEvents(new ClutchCallback<EventListBean>(EventListBean.class) {
            
            @Override
            public void onComplete(EventListBean data) {
                Window.alert("Size:"+data.getList().size());
                
            }
        });
        
        panel.setWidget(view);
    }

}
