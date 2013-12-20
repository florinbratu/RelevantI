package com.fbratu.relevant.gwt.server.dao;

/**
 * Author: Florin
 */
import java.lang.reflect.ParameterizedType;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public abstract class JPADAO<K, E> extends JpaDaoSupport {
    protected Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public JPADAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass
                .getActualTypeArguments()[1];
    }

    public void persist(E entity) {
        getJpaTemplate().persist(entity);
    }

    public void remove(E entity) {
        getJpaTemplate().remove(entity);
    }

    public E merge(E entity) {
        return getJpaTemplate().merge(entity);
    }

    public void refresh(E entity) {
        getJpaTemplate().refresh(entity);
    }

    public E findById(K id) {
        return getJpaTemplate().find(entityClass, id);
    }

    public E flush(E entity) {
        getJpaTemplate().flush();
        return entity;
    }

}
