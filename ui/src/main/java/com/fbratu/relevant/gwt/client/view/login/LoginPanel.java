package com.fbratu.relevant.gwt.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
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

    // keep a bit separated logic from display. use a Controller class
    private final LoginContorller controller;

    public LoginPanel() {
        uiBinder = GWT.create(LoginUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
        // init controller of this panel(which surprisingly is not the Presenter)
        controller = new LoginContorller();
    }

    @UiHandler("loginButton")
    public void onLogin(ClickEvent event) {
        triggerLogin();
    }

    private void triggerLogin() {
        String username = usernameBox.getValue();
        String password = passwordBox.getValue();
        controller.performLogin(username, password);
    }

    @UiHandler(value={"usernameBox", "passwordBox"})
    public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            triggerLogin();
        }
    }
}
