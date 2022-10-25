package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;;
import com.marjane.promotionmarjane.entities.Promotion;

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

    public ArrayList<Promotion> getAll() {
        return null;
    }


    public Promotion getOne(long Id) {
        return null;
    }
}
