package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Categorie;
import com.marjane.promotionmarjane.entities.Centre;
import org.hibernate.Session;

import java.util.ArrayList;

public class CategorieDao extends AbstractHibernateDAO<Categorie> {

    @Override
    public void insert(Categorie entity) throws Exception {
        super.insert(entity);
    }

    @Override
    public void update(Categorie entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Categorie entity) throws Exception {
        super.delete(entity);
    }

    public Categorie getOneCat(long Id) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.beginTransaction();
        Categorie categorie = session.find(Categorie.class, Id);
        session.getTransaction().commit();
        session.close();
        return categorie;
    }


    public ArrayList<Categorie> getAllCategories()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Categorie> categories = (ArrayList<Categorie>) session.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return categories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public Categorie getOne(long Id) {
        return null;
    }
}
