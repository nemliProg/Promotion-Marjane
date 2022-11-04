package com.marjane.promotionmarjane.servlets.subadmin;

import com.marjane.promotionmarjane.dao.daoImp.CategorieDao;
import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.dao.daoImp.PromotionDao;
import com.marjane.promotionmarjane.entities.Categorie;
import com.marjane.promotionmarjane.entities.Centre;
import com.marjane.promotionmarjane.entities.Promotion;
import com.marjane.promotionmarjane.entities.SubAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "PromotionServlet", value = "/sub-admin/promotions")
public class PromotionServlet extends HttpServlet {
    private PromotionDao promotionDao;
    private CategorieDao categorieDao;

    @Override
    public void init() throws ServletException {
        this.promotionDao = new PromotionDao();
        this.categorieDao = new CategorieDao();
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

        ArrayList <Categorie> categories = categorieDao.getAllCategories();
        ArrayList <Promotion> promotions = promotionDao.getAllPromotions();
        request.setAttribute("categories",categories);
        request.setAttribute("promotions",promotions);

        request.getRequestDispatcher("/views/sub-admin/promotion.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addPromotion = request.getParameter("add");
        String deletePromotion = request.getParameter("delete");
        if (addPromotion != null){
            HttpSession session = request.getSession();
            String percentage = request.getParameter("percentage");
            String categorie = request.getParameter("categorie");
            String start = request.getParameter("start-date");
            String end = request.getParameter("end-date");
            String description = request.getParameter("desc");

            CategorieDao categorieDao = new CategorieDao();
            CentreDao centreDao = new CentreDao();

            Promotion promotion = new Promotion();
            promotion.setPourcentage(new BigDecimal(percentage));
            promotion.setCategorieByIdCat(categorieDao.getOneCat(Integer.parseInt(categorie)));
            promotion.setCentreByIdCentre(centreDao.findCenter(1));
            promotion.setPromoStartDate(Date.valueOf(LocalDate.parse(start)));
            promotion.setPromoEndDate(Date.valueOf(LocalDate.parse(end)));
            promotion.setDescription(description);
            Centre centre = ((SubAdmin) session.getAttribute("subadmin")).getCentreById();
            promotion.setCentreByIdCentre(centre);
            promotion.setStatus("PENDING");
            promotionDao.insert(promotion);
            request.setAttribute("echo", "Promotion added successfully");
        }else if (deletePromotion != null){
            String id = request.getParameter("id");
            //promotionDao.delete(Integer.parseInt(id));
            //request.setAttribute("echo", "Promotion deleted successfully");
        }

        doGet(request,response);
    }
}
