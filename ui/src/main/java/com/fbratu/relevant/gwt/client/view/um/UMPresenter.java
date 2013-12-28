package com.fbratu.relevant.gwt.client.view.um;

import com.fbratu.relevant.gwt.client.view.ErrorView;
import com.fbratu.relevant.gwt.client.view.um.login.LoginController;
import com.fbratu.relevant.gwt.shared.UserManagementService;
import com.fbratu.relevant.gwt.shared.UserManagementServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Author: Florin
 */
public class UMPresenter implements LoginController{

    // the adjaced View
    private final UMPanel view;

    private final UserManagementServiceAsync userManagementService;

    // another hack - this presenter uses its own ErrorView instance
    // TODO centralize error and loading view
    private final ErrorView errorView;

    public UMPresenter(UMPanel view) {
        // init server side proxy
        userManagementService = GWT.create(UserManagementService.class);
        this.view = view;
        this.errorView = new ErrorView();
    }

    public void performLogin(String username, String password) {
        userManagementService.login(username, password, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                errorView.show(caught);
            }

            @Override
            public void onSuccess(Boolean result) {
                if(result) {
                    // TODO show signed page
                    Window.alert("Login succesful!");
                }
                else {
                    // TODO show in login panel
                    errorView.show("Login failed");
                }
            }
        });
    }
}
