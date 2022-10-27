package com.marjane.promotionmarjane.servlets.admin;

import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.entities.Centre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CentersServlet", value = "/admin/centers")
public class CentersServlet extends HttpServlet {

    private CentreDao centreDao;
    @Override
    public void init() throws ServletException {
        this.centreDao = new CentreDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Centre> centres = centreDao.getAllCenters();
        request.setAttribute("centers", centres);

        request.getRequestDispatcher("/views/admin/centers.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
