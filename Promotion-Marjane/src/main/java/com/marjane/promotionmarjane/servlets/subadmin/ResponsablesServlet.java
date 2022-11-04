package com.marjane.promotionmarjane.servlets.subadmin;

import com.marjane.promotionmarjane.dao.daoImp.CategorieDao;
import com.marjane.promotionmarjane.dao.daoImp.CentreDao;
import com.marjane.promotionmarjane.dao.daoImp.ResponsableDao;
import com.marjane.promotionmarjane.entities.*;
import com.marjane.promotionmarjane.security.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "ResponsablesServlet", value = "/sub-admin/responsables")
public class ResponsablesServlet extends HttpServlet {
    private ResponsableDao responsableDao;
    private CategorieDao categorieDao;

    @Override
    public void init() throws ServletException {
        this.responsableDao = new ResponsableDao();
        this.categorieDao = new CategorieDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("/views/sub-admin/login.jsp").forward(request,response);
            return;
        }else {
            Object check = session.getAttribute("sub");
            if (check == null) {
                request.getRequestDispatcher("/views/sub-admin/login.jsp").forward(request, response);
                return;
            }
        }

        ArrayList<Responsable> responsables = responsableDao.getAllResponsables();
        ArrayList<Categorie> categories = categorieDao.getAllCategoriesThatDontHaveResponsable();
        request.setAttribute("responsables",responsables);
        request.setAttribute("categories",categories);

        request.getRequestDispatcher("/views/sub-admin/responsable.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addResponsable = request.getParameter("add");
        String deleteResponsable = request.getParameter("delete");
        if (addResponsable != null){
            HttpSession session = request.getSession();
            String fName = request.getParameter("first-name");
            String lName = request.getParameter("last-name");
            String email = request.getParameter("email");
            String idCategorie = request.getParameter("categorie");

            Responsable responsable = new Responsable();

            Centre centre = ((SubAdmin) session.getAttribute("subadmin")).getCentreById();
            responsable.setIdCentre(centre.getId());
            responsable.setEmail(email);
            responsable.setNom(lName);
            responsable.setPrenom(fName);
            responsable.setIdCat(Integer.parseInt(idCategorie));
            String password = BCrypt.hashpw("123456", BCrypt.gensalt());
            responsable.setPassword(password);
            responsableDao.insert(responsable);

            request.setAttribute("echo", "Responsable added successfully");
        }else if (deleteResponsable != null){
            String id = request.getParameter("id");

            request.setAttribute("echo", "Responsable deleted successfully");
        }

        doGet(request,response);
    }
}
