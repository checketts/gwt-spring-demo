package com.github.checketts.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationShell extends Composite  {

    private static ApplicationShellUiBinder uiBinder = GWT.create(ApplicationShellUiBinder.class);

    interface ApplicationShellUiBinder extends UiBinder<Widget, ApplicationShell> {}

    public ApplicationShell() {
        initWidget(uiBinder.createAndBindUi(this));
    }


}
