package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Responsable;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.ArrayList;

public class ResponsableDao extends AbstractHibernateDAO<Responsable> {


    public Responsable getResponsableByEmail(String email) {

        try {
            Session session = null;
            try {
                session = getCurrentSession();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            session.getTransaction();
            session.beginTransaction();
            Responsable responsable = session.createQuery("SELECT r FROM Responsable r WHERE r.email = :email", Responsable.class)
                    .setParameter("email", email)
                    .getSingleResult();

            if (responsable != null){
                return responsable;
            }
        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public boolean validate(String email, String password) {
        Responsable responsable = null;
        try {
            responsable = getResponsableByEmail(email);
            if (responsable != null) {
                if (responsable.getPassword().equals(password)) {
                    return true;
                } else{
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    @Override
    public void insert(Responsable entity) {
        try {
            super.insert(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Responsable> getAllResponsables()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Responsable> responsables = (ArrayList<Responsable>) session.createQuery("SELECT r FROM Responsable r", Responsable.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return responsables;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
