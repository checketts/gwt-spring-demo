package com.github.checketts.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface R extends ClientBundle {
    public static final R INSTANCE =  GWT.create(R.class);

    @Source("styles.css")
    public MainStyles css();

    @Source("images/gwt-logo.png")
    public ImageResource gwtLogo();
    
  }