package com.github.checketts.client.ui.core;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface Shell extends IsWidget {

    void hideSidebar();

    void showSidebar();

    void goTo(Place place);

    AcceptsOneWidget getMainContent();

    Sidebar getSidebar();

}
