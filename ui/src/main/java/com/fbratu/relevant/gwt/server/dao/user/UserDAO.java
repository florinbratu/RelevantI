package com.fbratu.relevant.gwt.server.dao.user;

import com.fbratu.relevant.gwt.shared.dto.user.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Author: Florin
 */
public class UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findMatchingUsers(String username, String password)  {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where UserName = :user and Password = :pwd");
        query.setParameter("user", username);
        query.setParameter("pwd", password);
        List<User> results= query.list();
        tx.commit();
        return results;
    }
}

