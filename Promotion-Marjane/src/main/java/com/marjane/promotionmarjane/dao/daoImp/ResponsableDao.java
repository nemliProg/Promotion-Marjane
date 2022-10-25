package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Admin;
import com.marjane.promotionmarjane.entities.Responsable;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.ArrayList;

public class ResponsableDao extends AbstractHibernateDAO<Responsable> {


    public Responsable getResponsableByEmail(String email) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.beginTransaction();
        try {
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
    public void insert(Responsable entity) throws Exception {
        super.insert(entity);
    }

    public ArrayList<Responsable> getAll() {
        return null;
    }


    public void delete(Responsable responsable) {

    }


    public void update(Responsable responsable) {

    }


    public Responsable getOne(long Id) {
        return null;
    }
}
