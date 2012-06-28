package com.github.checketts.client.ui.core;

import com.github.checketts.client.mvp.StartPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ApplicationShell extends Composite implements Shell {

    private static ApplicationShellUiBinder uiBinder = GWT.create(ApplicationShellUiBinder.class);

    interface ApplicationShellUiBinder extends UiBinder<Widget, ApplicationShell> {}

    interface Style extends CssResource{
        String sidebarPresent();
    }
    protected PlaceController placeController;
    protected Sidebar sidebar;
    
    @UiField SimplePanel header;
    @UiField SimplePanel sidebarHolder;
    @UiField SimplePanel mainContent;
    @UiField Style style;
    
    @Inject
    public ApplicationShell(Sidebar sidebar,PlaceController placeController) {
        initWidget(uiBinder.createAndBindUi(this));
        this.placeController = placeController;
        
        setSidebar(sidebar);
        hideSidebar();
    }
    
    public void setSidebar(Sidebar sidebar) {
        sidebar.setApplicationShell(this);
        this.sidebar = sidebar;
        sidebarHolder.setWidget(sidebar);
    }
    
    @UiHandler("headerLogo")
    public void onLogoClicked(ClickEvent event) {
        placeController.goTo(new StartPlace());
    }

    @Override
    public void hideSidebar() {
        sidebarHolder.setVisible(false);
        mainContent.removeStyleName(style.sidebarPresent());
    }

    @Override
    public void showSidebar() {
        sidebarHolder.setVisible(true);
        mainContent.addStyleName(style.sidebarPresent());
    }
    
    @Override
    public void goTo(Place place) {
        placeController.goTo(place);
    }

    @Override
    public AcceptsOneWidget getMainContent() {
        return mainContent;
    }

    @Override
    public Sidebar getSidebar() {
        return sidebar;
    }
}
