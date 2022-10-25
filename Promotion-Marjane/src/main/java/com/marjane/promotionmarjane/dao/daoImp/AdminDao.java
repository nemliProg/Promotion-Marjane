package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Admin;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.ArrayList;

public class AdminDao extends AbstractHibernateDAO<Admin>  {


    public Admin getAdminByEmail(String email) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.beginTransaction();
        try {
            Admin admin = session.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return admin;
        }catch (NoResultException e){
            return null;
        }
    }


    public boolean validate(String email, String password)  {
        try {
         Admin admin = getAdminByEmail(email);
            if (admin != null) {
                if (admin.getPassword().equals(password)) {
                    return true;
                } else{
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public ArrayList<Admin> getAllAdmins()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Admin> admins = (ArrayList<Admin>) session.createQuery("SELECT r FROM Admin r", Admin.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return admins;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Admin entity) throws Exception {
        super.insert(entity);
    }

    @Override
    public void update(Admin entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Admin entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Admin> getAll(){

        return new ArrayList<Admin>();
    }



    public Admin getOne(long Id) {
        return null;
    }
}
