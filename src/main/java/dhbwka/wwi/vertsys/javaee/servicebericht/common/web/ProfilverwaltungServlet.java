/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.servicebericht.common.web;

import dhbwka.wwi.vertsys.javaee.jtodo.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.servicebericht.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.Task;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dominik Kunzmann
 */

@WebServlet(urlPatterns = {"/app/profil/"})
public class ProfilverwaltungServlet extends HttpServlet{
    
    public final static String URL = "/app/profil/";
    
    @EJB
    UserBean userBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("currentUser", this.userBean.getCurrentUser());
        
        request.getRequestDispatcher("/WEB-INF/profilverwaltung/profilverwaltung.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        User u = userBean.getCurrentUser();
        
        u.setVorname(request.getParameter("vornameU"));
        u.setNachname(request.getParameter("nachnameU"));
        u.setTelefonnummer(request.getParameter("telefonnummer"));
        
        userBean.update(u);
        
        response.sendRedirect(request.getContextPath() + ProfilverwaltungServlet.URL);
    }
}
