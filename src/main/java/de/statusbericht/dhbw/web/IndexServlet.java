/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.web;

import de.statusbericht.dhbw.ejb.ServiceeintragBean;
import de.statusbericht.dhbw.helper.Response;
import de.statusbericht.dhbw.jpa.Serviceeintrag;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dominik Kunzmann
 */
@WebServlet(urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

    @EJB
    ServiceeintragBean serviceeintrag;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Response<Serviceeintrag> serviceResponse = serviceeintrag.findAll();
        
        request.setAttribute("serviceResponse", serviceResponse);
        request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
