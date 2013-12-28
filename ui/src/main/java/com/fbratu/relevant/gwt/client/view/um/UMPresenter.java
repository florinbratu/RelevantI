package com.fbratu.relevant.gwt.client.view.um;

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

    public UMPresenter(UMPanel view) {
        // init server side proxy
        userManagementService = GWT.create(UserManagementService.class);
        this.view = view;
    }

    public void performLogin(String username, String password) {
        userManagementService.login(username, password, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Login failed");
            }

            @Override
            public void onSuccess(Boolean result) {
                if(result)
                    Window.alert("Login succesful!");
                else
                    Window.alert("Login failed");
            }
        });
    }
}
