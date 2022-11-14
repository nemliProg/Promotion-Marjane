package com.marjane.promotionmarjane.servlets.responsable;

import com.marjane.promotionmarjane.dao.daoImp.PromotionDao;
import com.marjane.promotionmarjane.entities.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RejectPromotionServlet", value = "/responsable/promos/reject")
public class RejectPromotionServlet extends HttpServlet {
    private PromotionDao promotionDao;

    @Override
    public void init() throws ServletException {
        promotionDao = new PromotionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        request.getRequestDispatcher("/views/responsable/reject-promotion.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String explanation = request.getParameter("explanation");

        Promotion promotion = promotionDao.get(id);
        promotion.setStatus("REJECTED");
        promotion.setExplanation(explanation.trim());
        promotionDao.updatePromotion(promotion);

        response.sendRedirect("/responsable/promos");
    }
}
