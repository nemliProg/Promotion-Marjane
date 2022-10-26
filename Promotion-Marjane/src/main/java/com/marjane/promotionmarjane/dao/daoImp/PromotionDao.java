package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;;
import com.marjane.promotionmarjane.entities.Categorie;
import com.marjane.promotionmarjane.entities.Promotion;
import org.hibernate.Session;

import java.util.ArrayList;

public class PromotionDao extends AbstractHibernateDAO<Promotion>{

    @Override
    public void insert(Promotion entity) throws Exception {
        super.insert(entity);
    }

    @Override
    public void update(Promotion entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Promotion entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Promotion> getAllPromotions()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Promotion> promotions = (ArrayList<Promotion>) session.createQuery("SELECT p FROM Promotion p", Promotion.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return promotions;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Promotion> getAll() {
        return null;
    }


    public Promotion getOne(long Id) {
        return null;
    }
}
