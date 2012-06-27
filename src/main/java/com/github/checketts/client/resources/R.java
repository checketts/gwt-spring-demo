package com.github.checketts.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface R extends ClientBundle {
    public static final R INSTANCE =  GWT.create(R.class);

    @Source("styles.css")
    public MainStyles css();

  }