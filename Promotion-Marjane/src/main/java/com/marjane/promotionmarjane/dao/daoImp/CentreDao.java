package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Centre;
import org.hibernate.Session;


import java.util.ArrayList;

public class CentreDao extends AbstractHibernateDAO<Centre> {

    @Override
    public void insert(Centre entity)  {
        try {
            super.insert(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Centre entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Centre entity) throws Exception {
        super.delete(entity);
    }

    public Centre findCenter(long Id)  {
        try{
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            Centre centre = session.find(Centre.class, Id);
            session.getTransaction().commit();
            session.close();
            return centre;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
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
