package com.github.checketts.client;


import com.github.checketts.client.inject.Injector;
import com.github.checketts.client.resources.R;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    R.INSTANCE.css().ensureInjected();
      
    // Use RootPanel.get() to get the entire body element
    RootPanel.get().add(Injector.INSTANCE.getAppShell());
  }
}
