package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;;
import com.marjane.promotionmarjane.entities.Promotion;
import org.hibernate.Session;

import java.util.ArrayList;

public class PromotionDao extends AbstractHibernateDAO<Promotion>{

    @Override
    public void insert(Promotion entity)  {
        try {
            super.insert(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Promotion entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Promotion entity) throws Exception {
        super.delete(entity);
    }

    //findPromotionById
    public Promotion get(int id) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.getTransaction().begin();
        Promotion promotion = session.get(Promotion.class, id);
        session.getTransaction().commit();
        session.close();
        return promotion;
    }

    //updatePromotion
    public void updatePromotion(Promotion promotion) {

        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            session.merge(promotion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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


    public ArrayList<Promotion> getPromotionsByCategoryAndCentre(int idCategory, int idCentre)  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Promotion> promotions = (ArrayList<Promotion>) session.createQuery("SELECT p FROM Promotion p WHERE p.centreByIdCentre.id = :idCentre AND p.categorieByIdCat.id = :idCategorie", Promotion.class)
                    .setParameter("idCentre", idCentre)
                    .setParameter("idCategorie", idCategory)
                    .getResultList();
            session.getTransaction().commit();
            session.close();
            return promotions;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
