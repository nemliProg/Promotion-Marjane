package com.marjane.promotionmarjane.dao.daoImp;

import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Categorie;

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


    public ArrayList<Categorie> getAll() {
        return null;
    }



    public Categorie getOne(long Id) {
        return null;
    }
}
