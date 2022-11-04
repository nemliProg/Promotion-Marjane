package com.marjane.promotionmarjane.servlets.admin;

import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.dao.daoImp.SubAdminDao;
import com.marjane.promotionmarjane.entities.Centre;
import com.marjane.promotionmarjane.entities.SubAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SubAdminsServlet", value = "/admin/sub-admins")
public class SubAdminsServlet extends HttpServlet {
    private SubAdminDao subAdminDao;
    private CentreDao centreDao;
    @Override
    public void init() throws ServletException {
        this.subAdminDao = new SubAdminDao();
        this.centreDao = new CentreDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SubAdmin> subAdmins = subAdminDao.getAllSubAdmins();
        ArrayList<Centre> centres = centreDao.getAllCentersThatDontHaveAdmin();
        request.setAttribute("subAdmins", subAdmins);
        request.setAttribute("centersSelect",centres);
        request.getRequestDispatcher("/views/admin/subadmins.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameters
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String centreId = request.getParameter("center");
        //get centre
        Centre centre = centreDao.getCentreById(Integer.parseInt(centreId));
        //create new subAdmin
        SubAdmin subAdmin = new SubAdmin();
        subAdmin.setNom(lastName);
        subAdmin.setPrenom(firstName);
        subAdmin.setEmail(email);
        subAdmin.setCentreById(centre);
        //insert new subAdmin
        subAdminDao.insert(subAdmin);

        doGet(request,response);
    }
}
