package com.fbratu.relevant.gwt.server.dao.user;

import com.fbratu.relevant.gwt.server.dao.JPADAO;
import com.fbratu.relevant.gwt.shared.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

/**
 * Author: Florin
 */
@Repository("User")
public class UserDAO extends JPADAO<Long, User> {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
    }

    private boolean login(String username, String password)  {
        return getJpaTemplate().find("from Users where UserName = ? and PassWord = ?", username, password).size() == 1;
    }
}

