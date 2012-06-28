package com.github.checketts.client.ui.info;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class InfoViewImpl extends Composite implements InfoView {

    private static InfoViewImplUiBinder uiBinder = GWT.create(InfoViewImplUiBinder.class);

    interface InfoViewImplUiBinder extends UiBinder<Widget, InfoViewImpl> {}

    @UiField Label infoLabel;
    
    public InfoViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void setText(String text) {
        infoLabel.setText(text);
    }

}
