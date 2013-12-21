package com.fbratu.relevant.gwt.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface UserManagementServiceAsync {
    void login(String username, String password, AsyncCallback<Boolean> async);
}
