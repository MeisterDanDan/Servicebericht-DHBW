/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.servicebericht.common.web;

import dhbwka.wwi.vertsys.javaee.servicebericht.common.ejb.UserBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dominik
 */

@WebServlet(urlPatterns = {"/app/nutzerverwaltung/"})
public class NutzerverwaltungServlet extends HttpServlet{
    
    public final static String URL = "/app/nutzerverwaltung/";
    
    @EJB
    UserBean userBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("user", this.userBean.getCurrentUser());
        
        request.setAttribute("userList", this.userBean.getUserList());
        
        request.getRequestDispatcher("/WEB-INF/profilverwaltung/nutzerverwaltung.jsp").forward(request, response);
    }
}
