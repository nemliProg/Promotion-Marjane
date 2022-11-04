package com.marjane.promotionmarjane.dao;


import com.marjane.promotionmarjane.util.SessionUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public abstract class AbstractHibernateDAO<T> {


    public void insert(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }



    protected Session getCurrentSession() throws Exception{

        return SessionUtil.getCurrentSession();
    }

}