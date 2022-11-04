package com.marjane.promotionmarjane.servlets.responsable;

import com.marjane.promotionmarjane.dao.daoImp.ResponsableDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginResponsableServlet", value = "/login-responsable")
public class LoginResponsableServlet extends HttpServlet {

    private ResponsableDao responsableDao;

    @Override
    public void init() throws ServletException {
        this.responsableDao = new ResponsableDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            Object check = session.getAttribute("responsable");
            if(check != null)
                request.getRequestDispatcher("/views/responsable/promos.jsp").forward(request,response);
        }
        request.getRequestDispatcher("/views/responsable/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean login = responsableDao.validate(email, password);
        if(login){
            HttpSession session = request.getSession();
            session.setAttribute("responsable", responsableDao.getResponsableByEmail(email));
            response.sendRedirect("/responsable/promos");
        }else{
            request.setAttribute("echo","Password or Email you entered is incorrect");
            request.getRequestDispatcher("./views/responsable/login.jsp").forward(request, response);
        }
    }
}
