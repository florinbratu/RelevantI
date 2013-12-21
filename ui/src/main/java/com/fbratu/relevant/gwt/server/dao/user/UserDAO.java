package com.fbratu.relevant.gwt.server.dao.user;

import com.fbratu.relevant.gwt.server.dao.JPADAO;
import com.fbratu.relevant.gwt.shared.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Author: Florin
 */
@Repository("UserDAO")
public class UserDAO extends JPADAO<Long, User> {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setJpaTemplate(new JpaTemplate(entityManagerFactory));
    }

    public List<User> findMatchingUsers(String username, String password)  {
        return getJpaTemplate().find("from Users where UserName = ? and PassWord = ?", username, password);
    }
}

