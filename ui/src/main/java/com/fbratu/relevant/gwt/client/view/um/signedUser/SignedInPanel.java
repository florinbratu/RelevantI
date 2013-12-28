package com.fbratu.relevant.gwt.client.view.um.signedUser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Author: Florin
 */
public class SignedInPanel extends Composite{

    interface SignedInUiBinder extends UiBinder<Widget, SignedInPanel> {}

    private SignedInUiBinder uiBinder;

    @UiField
    Label usernameLabel;

    @UiField
    Label logoutLink;

    private SignedInController controller;

    public SignedInPanel() {
        uiBinder = GWT.create(SignedInUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setUsername(String username) {
        this.usernameLabel.setText(username);
    }

    public void register(SignedInController controller) {
        this.controller = controller;
    }

    @UiHandler("logoutLink")
    public void onLogout(ClickEvent event) {
        // TODO add logic; for the time being this should throw a NPE
        controller.logout();
    }
}
