package com.github.checketts.client.ui.info;

import com.github.checketts.client.ui.core.Shell;
import com.github.checketts.client.ui.core.Sidebar;
import com.github.checketts.client.util.core.BaseActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class InfoActivity extends BaseActivity<InfoView, InfoPlace> {

    @Inject
    protected InfoActivity(EventBus eventBus, Shell applicationShell, InfoView view) {
        super(eventBus, applicationShell, view);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        setupSidebar();

        panel.setWidget(view);
        view.setText(place.getToken());
    }

    private void setupSidebar() {
        shell.showSidebar();

        Sidebar sidebar = shell.getSidebar();
        sidebar.clear();
        sidebar.addPlace("First", new InfoPlace("first"));
        sidebar.addPlace("Other", new InfoPlace("misc stuff"));
        sidebar.addPlace("Apple", new InfoPlace("fruits"));

    }

}
