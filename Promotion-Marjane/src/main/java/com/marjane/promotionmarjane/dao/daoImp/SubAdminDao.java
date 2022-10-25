package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Responsable;
import com.marjane.promotionmarjane.entities.SubAdmin;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.ArrayList;

public class SubAdminDao extends AbstractHibernateDAO<SubAdmin> {


    public SubAdmin getSubAdminByEmail(String email) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.beginTransaction();
        try {
            SubAdmin subAdmin = session.createQuery("SELECT s FROM SubAdmin s WHERE s.email = :email", SubAdmin.class)
                    .setParameter("email", email)
                    .getSingleResult();

            if (subAdmin != null){
                return subAdmin;
            }
        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public boolean validate(String email, String password)  {
        try {
            SubAdmin subAdmin = getSubAdminByEmail(email);
            if (subAdmin != null) {
                if (subAdmin.getPassword().equals(password)) {
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


    public void insert(SubAdmin entity) throws Exception {
        super.insert(entity);
    }


    public ArrayList<SubAdmin> getAllSubAdmins() {

        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<SubAdmin> subAdmins = (ArrayList<SubAdmin>) session.createQuery("SELECT s FROM SubAdmin s", SubAdmin.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return subAdmins;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public void delete(SubAdmin subAdmin) {

    }


    public void update(SubAdmin subAdmin) {

    }


    public SubAdmin getOne(long Id) {
        return null;
    }
}
