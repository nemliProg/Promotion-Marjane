package com.marjane.promotionmarjane.servlets.admin;

import com.marjane.promotionmarjane.dao.daoImp.AdminDao;
import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.dao.daoImp.SubAdminDao;
import com.marjane.promotionmarjane.entities.Centre;
import com.marjane.promotionmarjane.entities.SubAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DashboardAdminServlet", value = "/dashboard-admin")
public class DashboardAdminServlet extends HttpServlet {

    private SubAdminDao subAdminDao;
    private CentreDao centreDao;

    @Override
    public void init() throws ServletException {
        this.subAdminDao = new SubAdminDao();
        this.centreDao = new CentreDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("/views/admin/login.jsp").forward(request,response);
        }else {
            Object check = session.getAttribute("admin");
            if (check == null) {
                request.getRequestDispatcher("/views/admin/login.jsp").forward(request, response);
            }
        }
        ArrayList<SubAdmin> subAdmins = subAdminDao.getAllSubAdmins();
        ArrayList<Centre> centres = centreDao.getAllCenters();

        request.setAttribute("subAdmins", subAdmins);
        request.setAttribute("centers", centres);

        request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
