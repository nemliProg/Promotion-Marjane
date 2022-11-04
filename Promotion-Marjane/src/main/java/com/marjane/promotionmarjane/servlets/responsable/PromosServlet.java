package com.marjane.promotionmarjane.servlets.responsable;

import com.marjane.promotionmarjane.dao.daoImp.PromotionDao;
import com.marjane.promotionmarjane.entities.Promotion;
import com.marjane.promotionmarjane.entities.Responsable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet(name = "PromosServlet", value = "/responsable/promos")
public class PromosServlet extends HttpServlet {
    private PromotionDao promotionDao;

    @Override
    public void init() throws ServletException {
        promotionDao = new PromotionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("/views/responsable/login.jsp").forward(request,response);
        }else {
            Object check = session.getAttribute("responsable");
            if (check == null) {
                request.getRequestDispatcher("/views/responsable/login.jsp").forward(request, response);
            }
        }
        LocalTime time_now = LocalTime.now();
        LocalTime time = LocalTime.of(12,00,00);
        if(time_now.isBefore(time)){
            Responsable responsable = (Responsable) session.getAttribute("responsable");
            ArrayList<Promotion> promotions = promotionDao.getPromotionsByCategoryAndCentre((int) responsable.getIdCat(), (int) responsable.getIdCentre());
            promotions = (ArrayList<Promotion>) promotions.stream().filter(promotion -> promotion.getStatus().equals("PENDING")).collect(Collectors.toList());
            request.setAttribute("promotions",promotions);
        }else {
            request.setAttribute("message","You can't consult the promotions after 12:00");
        }

        request.getRequestDispatcher("/views/responsable/promos.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
