package com.github.checketts.client.ui.core;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class Sidebar extends FlowPanel {

    private Shell appShell;
    
    public Sidebar() {
    }
    
    public void setApplicationShell(Shell appShell) {
        this.appShell = appShell;
    }
    
    @Override
    public void clear() {
        super.clear();
        appShell.hideSidebar();
    }
    
    @Override
    public void add(Widget child) {
        super.add(child);
        appShell.showSidebar();
    }

    public Anchor addPlace(String text, Place place) {
        Anchor link = new Anchor(text);
        add(link);
        link.addClickHandler(new PlaceClickHandler(place));
        return link;
        
    }
    
    private class PlaceClickHandler implements ClickHandler {
        Place p;
        
        public PlaceClickHandler(Place p) {
            this.p = p;
        }
        
        @Override
        public void onClick(ClickEvent event) {
            appShell.goTo(p);
        }
    }
    
}
