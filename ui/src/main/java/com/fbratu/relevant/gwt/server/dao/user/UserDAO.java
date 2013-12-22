package com.fbratu.relevant.gwt.server.dao.user;

import com.fbratu.relevant.gwt.server.dao.JPADAO;
import com.fbratu.relevant.gwt.shared.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

/**
 * Author: Florin
 */
@Repository("UserDAO")
public class UserDAO {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }

    public List<User> findMatchingUsers(String username, String password)  {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            Query query = em.createQuery("from User where userName = ?1 and password = ?2");
            query.setParameter(1, username);
            query.setParameter(2, password);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}

