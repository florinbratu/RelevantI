package com.fbratu.relevant.gwt.client.view.um.login;

import com.fbratu.relevant.gwt.shared.UserManagementService;
import com.fbratu.relevant.gwt.shared.UserManagementServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Author: Florin
 */
public class LoginContorller {

    private final UserManagementServiceAsync userManagementService;

    public LoginContorller() {
        // init server side proxy
        userManagementService = GWT.create(UserManagementService.class);
    }

    public void performLogin(String username, String password) {
        // TODO architecture this shit! listeners!
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
