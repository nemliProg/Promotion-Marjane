package com.marjane.promotionmarjane.servlets.subadmin;


import com.marjane.promotionmarjane.dao.daoImp.CategorieDao;
import com.marjane.promotionmarjane.dao.daoImp.PromotionDao;
import com.marjane.promotionmarjane.dao.daoImp.ResponsableDao;
import com.marjane.promotionmarjane.entities.Categorie;
import com.marjane.promotionmarjane.entities.Promotion;
import com.marjane.promotionmarjane.entities.Responsable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DashboardSubAdminServlet", value = "/dashboard-subadmin")
public class DashboardSubAdminServlet extends HttpServlet {

    private CategorieDao categorieDao;
    private PromotionDao promotionDao;
    private ResponsableDao responsableDao;

    @Override
    public void init() throws ServletException {
        this.categorieDao = new CategorieDao();
        this.promotionDao = new PromotionDao();
        this.responsableDao = new ResponsableDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("/views/sub-admin/login.jsp").forward(request,response);
            return;
        }else {
            Object check = session.getAttribute("sub");
            if (check == null) {
                request.getRequestDispatcher("/views/sub-admin/login.jsp").forward(request, response);
                return;
            }
        }

        ArrayList<Categorie> categories = categorieDao.getAllCategories();
        ArrayList<Promotion> promotions = promotionDao.getAllPromotions();
        ArrayList<Responsable> responsables = responsableDao.getAllResponsables();

        request.setAttribute("categories", categories);
        request.setAttribute("promotions", promotions);
        request.setAttribute("responsables", responsables);

        request.getRequestDispatcher("/views/sub-admin/dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
