package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Admin;
import com.marjane.promotionmarjane.entities.Centre;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;


import java.util.ArrayList;
import java.util.List;

public class CentreDao extends AbstractHibernateDAO<Centre> {

    @Override
    public void insert(Centre entity) throws Exception {
        super.insert(entity);
    }

    @Override
    public void update(Centre entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Centre entity) throws Exception {
        super.delete(entity);
    }


    public ArrayList<Centre> getAllCenters()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Centre> centres = (ArrayList<Centre>) session.createQuery("SELECT c FROM Centre c", Centre.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return centres;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Centre> getAllCentersThatDontHaveAdmin()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Centre> centres = (ArrayList<Centre>) session.createQuery("SELECT c FROM Centre c WHERE c.id NOT IN (SELECT a.id FROM SubAdmin a)", Centre.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return centres;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    public Centre getOne(long Id) {
        return null;
    }

    public Centre getCentreById(long id){
        //EntityManager em = daoFactory.getEMF().createEntityManager();
        //return em.find(Centre.class,id);
        return null;
    }
}
