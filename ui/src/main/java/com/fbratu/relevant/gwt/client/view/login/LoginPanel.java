package com.fbratu.relevant.gwt.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Author: Florin
 */
public class LoginPanel extends Composite{

    interface LoginUiBinder extends UiBinder<Widget, LoginPanel> {}

    private LoginUiBinder uiBinder;

    @UiField
    TextBox usernameBox;

    @UiField
    PasswordTextBox passwordBox;

    @UiField
    Button loginButton;

    public LoginPanel() {
        uiBinder = GWT.create(LoginUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("loginButton")
    public void onLogin(ClickEvent event) {
        String username = usernameBox.getValue();
        String password = passwordBox.getValue();
        Window.alert("Logging in user " + username + " password:" + password);
    }
}
