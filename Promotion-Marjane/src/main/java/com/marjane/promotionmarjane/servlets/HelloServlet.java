package com.marjane.promotionmarjane.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
            return;
        }else {
            if (session.getAttribute("responsable") != null) {
                response.sendRedirect("/responsable/promos");
                return;
            }else if(session.getAttribute("admin") != null){
                response.sendRedirect("/dashboard-admin");
                return;
            }else if(session.getAttribute("sub") != null){
                response.sendRedirect("/dashboard-subadmin");
                return;
            }
        }
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}