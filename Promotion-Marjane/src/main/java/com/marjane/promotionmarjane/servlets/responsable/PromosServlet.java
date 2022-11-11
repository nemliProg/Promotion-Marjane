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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PromosServlet", value = "/responsable/promos/*")
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

        // get
        String[] queryParams = request.getRequestURI().split("/");

        int pageNumber = 1;
        int rowsPerPage = 8;

        if(queryParams.length > 4){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //      - check if pageNumber parameter is an int
        try{
            if(queryParams.length == 4){
                pageNumber = Integer.parseInt(queryParams[3]);
                if(pageNumber <= 0)
                    throw new NumberFormatException();
            }
        }catch(NumberFormatException exception){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        int offset = (pageNumber-1)*rowsPerPage;
        int max = offset + rowsPerPage;

        LocalTime time_now = LocalTime.now();
        LocalTime time = LocalTime.of(12,00,00);
//        if(time_now.isBefore(time)){
            Responsable responsable = (Responsable) session.getAttribute("responsable");
            List<Promotion> promotions = promotionDao.getPromotionsByCategoryAndCentre((int) responsable.getIdCat(), (int) responsable.getIdCentre());
            promotions = promotions.stream().filter(promotion -> promotion.getStatus().equals("PENDING")).collect(Collectors.toList());
            int recordsCount = promotions.size();
            int totalOfPages = recordsCount / rowsPerPage + 1;
            if (pageNumber == totalOfPages){
                max = Math.min(max,recordsCount);
            }
            promotions = promotions.subList(offset,max);

            request.setAttribute("totalOfPages", totalOfPages);
            request.setAttribute("currentPage", pageNumber);
            request.setAttribute("promotions", promotions);

//        }else {
//            request.setAttribute("message","You can't consult the promotions after 12:00");
//        }

        request.getRequestDispatcher("/views/responsable/promos.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Accepter une promotion
        int id = Integer.parseInt(request.getParameter("id"));
        Promotion promotion = promotionDao.get(id);
        promotion.setStatus("ACCEPTED");
        promotionDao.updatePromotion(promotion);

        doGet(request, response);
    }
}
