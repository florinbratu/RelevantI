package com.fbratu.relevant.gwt.client.view.um;

import com.fbratu.relevant.gwt.client.view.um.login.LoginPanel;
import com.fbratu.relevant.gwt.client.view.um.signedUser.UserPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Author: Florin
 */
public class UMPanel extends Composite {

    interface UserManagementUiBinder extends UiBinder<Widget, UMPanel>
    {
    }
    private UserManagementUiBinder uiBinder;

    @UiField
    DeckPanel userManagementPanel;

    @UiField
    LazyPanel lazyLoginPanel;

    @UiField
    LoginPanel loginPanel;

    private static final int LOGIN_PANEL_WIDGET_ID = 0;

    @UiField
    UserPanel signedUserPanel;

    @UiField
    LazyPanel lazySignedUserPanel;

    private UMPresenter presenter;

    private static final int SIGNED_USER_PANEL_WIDGET_ID = 1;

    public UMPanel() {
        uiBinder = GWT.create(UserManagementUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
        // initial page is login page
        showLoginPage();
        // HACK init Presenter here
        register(new UMPresenter(this));
    }

    public void showLoginPage() {
        userManagementPanel.showWidget(LOGIN_PANEL_WIDGET_ID);
    }

    public void showSignedUserPage() {
        userManagementPanel.showWidget(SIGNED_USER_PANEL_WIDGET_ID);
    }

    public void register(UMPresenter presenter) {
        this.presenter = presenter;
        loginPanel.register(presenter);
    }
}
