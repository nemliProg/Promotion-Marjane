package com.marjane.promotionmarjane.dao.daoImp;
import com.marjane.promotionmarjane.dao.AbstractHibernateDAO;
import com.marjane.promotionmarjane.entities.Produit;

import java.util.ArrayList;

public class ProduitDao extends AbstractHibernateDAO<Produit> {


    @Override
    public void insert(Produit entity) throws Exception {
        super.insert(entity);
    }

    @Override
    public void update(Produit entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Produit entity) throws Exception {
        super.delete(entity);
    }


    public ArrayList<Produit> getAll() {
        return null;
    }



    public Produit getOne(long Id) {
        return null;
    }
}
