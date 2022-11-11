package com.marjane.promotionmarjane.context;

import com.marjane.promotionmarjane.dao.daoImp.PromotionDao;
import com.marjane.promotionmarjane.entities.Promotion;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@WebListener
public final class ContextListener implements ServletContextListener {

    public ContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {

            System.out.println("[MyContextListener] Marjane Promotions is starting");
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(verifications,0 ,1, TimeUnit.DAYS);

        } catch (Exception e) {
            System.out.println("[MyContextListener] Error : " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("[MyContextListener] Marjane Promotions is shutting down");

    }

    Runnable verifications = ()->{
        Date date = new Date();
        PromotionDao promotionDao = new PromotionDao();
        ArrayList<Promotion> promotions = promotionDao.getAllPromotions();
        promotions.stream().filter(promotion -> promotion.getStatus().equals("PENDING")).filter(promotion -> promotion.getPromoStartDate().before(date)).forEach(
                promotion -> {
                    if (promotion.getPromoStartDate().before(date)) {
                        Promotion promotionI = promotionDao.get((int) promotion.getId());
                        promotionI.setStatus("UNTREATED");
                        promotionDao.updatePromotion(promotionI);
                    }
                }
        );
        promotions.stream().filter(promotion -> promotion.getPromoEndDate().before(date)).forEach(
                promotion -> {
                    if (promotion.getPromoStartDate().before(date)) {
                        Promotion promotionI = promotionDao.get((int) promotion.getId());
                        promotionI.setStatus("EXPIRED");
                        promotionDao.updatePromotion(promotionI);
                    }
                }
        );
    };
}
