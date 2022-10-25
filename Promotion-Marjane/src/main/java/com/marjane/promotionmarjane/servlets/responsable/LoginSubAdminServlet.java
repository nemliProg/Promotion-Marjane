package com.marjane.promotionmarjane.servlets.responsable;

import com.marjane.promotionmarjane.dao.daoImp.SubAdminDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginSubAdminServlet", value = "/login-subadmin")
public class LoginSubAdminServlet extends HttpServlet {
    private SubAdminDao subAdminDao;

    @Override
    public void init() throws ServletException {
        this.subAdminDao = new SubAdminDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/sub-admin/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean login = subAdminDao.validate(email, password);
        if(login){
            session.setAttribute("sub", email);
            response.sendRedirect("/hello-servlet");
        }else{
            request.setAttribute("echo","Password or Email you entered is incorrect");
            request.getRequestDispatcher("./views/sub-admin/login.jsp").forward(request, response);
        }
    }
}
