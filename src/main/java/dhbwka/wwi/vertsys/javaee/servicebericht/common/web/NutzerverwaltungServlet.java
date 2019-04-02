/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.servicebericht.common.web;

import dhbwka.wwi.vertsys.javaee.servicebericht.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.servicebericht.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.Task;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        request.setAttribute("userI", this.userBean.getCurrentUser());
        
        request.setAttribute("userList", this.userBean.getUserList());
        
        request.getRequestDispatcher("/WEB-INF/profilverwaltung/nutzerverwaltung.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "submit":
                this.submitRechte(request, response);
                break;
            case "remove":
                this.removeRechte(request, response);
                break;
        }
    }
    
    private void submitRechte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String[] userNames = request.getParameterValues("user");

            if (userNames == null) {
                userNames = new String[0];
            }
             
            // Kategorien löschen
        for (String username : userNames) {
            // Zu löschende Kategorie ermitteln
            User userName;

            try {
                userName = this.userBean.findByUsername(username);
                this.userBean.update(userName);
            } catch (NumberFormatException ex) {
                continue;
            }

            if (userName == null) {
                continue;
            }
            
            

            // Userrechte vergeben
            this.userBean.update(userName);
        }

        // Browser auffordern, die Seite neuzuladen
        response.sendRedirect(request.getRequestURI());
    }
        

    private void removeRechte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
