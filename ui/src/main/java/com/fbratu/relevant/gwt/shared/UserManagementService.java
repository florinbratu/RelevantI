package com.fbratu.relevant.gwt.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Author: Florin
 */
@RemoteServiceRelativePath("springGwtServices/userManagement")
public interface UserManagementService extends RemoteService {
    boolean login(String username, String password);
}
