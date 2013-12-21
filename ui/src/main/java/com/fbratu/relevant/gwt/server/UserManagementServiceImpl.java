package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.server.dao.user.UserDAO;
import com.fbratu.relevant.gwt.shared.UserManagementService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Florin
 */
@SuppressWarnings("serial")
@Service("userManagement")
public class UserManagementServiceImpl extends RemoteServiceServlet implements
        UserManagementService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean login(String username, String password) {
        return userDAO.findMatchingUsers(username, password).size() == 1;
    }
}
