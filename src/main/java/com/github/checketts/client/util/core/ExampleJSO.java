package com.github.checketts.client.util.core;

import com.google.gwt.core.client.JavaScriptObject;

public class ExampleJSO extends JavaScriptObject{
    protected ExampleJSO(){}

    // {title: "GWT in Action"}
    public final native String getTitle()/*-{
        return this.title;
    }-*/;

    public final int titleLength() {
        return getTitle().length();
    }
}

