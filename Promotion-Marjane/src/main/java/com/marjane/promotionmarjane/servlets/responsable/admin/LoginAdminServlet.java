package com.marjane.promotionmarjane.servlets.admin;

import com.marjane.promotionmarjane.dao.daoImp.AdminDao;
import com.marjane.promotionmarjane.dao.daoImp.SubAdminDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", value = "/login-admin")
public class LoginAdminServlet extends HttpServlet {
    private AdminDao adminDao;
    @Override
    public void init() throws ServletException {
        adminDao = new AdminDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            Object check = session.getAttribute("admin");
            if(check != null){
                request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request,response);
                return;
            }
        }
        request.getRequestDispatcher("/views/admin/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean login = adminDao.validate(email, password);
        if(login){
            HttpSession session = request.getSession();
            session.setAttribute("admin", email);
            response.sendRedirect("/dashboard-admin");
        }else{
            request.setAttribute("echo","Password or Email you entered is incorrect");
            request.getRequestDispatcher("./views/admin/login.jsp").forward(request, response);
        }
    }
}
