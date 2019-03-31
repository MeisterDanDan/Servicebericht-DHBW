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
import javax.transaction.Transactional;

/**
 *
 * @author Dominik Kunzmann
 */
@WebServlet(urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {
    
    public static final String URL = "/index.html";

    @EJB
    ServiceeintragBean serviceeintrag;
    
    @Transactional
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Response<Serviceeintrag> serviceResponse = serviceeintrag.findAll();
        
        request.setAttribute("ServiceResponse", serviceResponse);
        request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
    }

}
