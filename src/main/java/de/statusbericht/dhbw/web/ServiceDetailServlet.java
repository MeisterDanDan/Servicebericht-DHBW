/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.web;

import de.statusbericht.dhbw.ejb.ServiceeintragBean;
import de.statusbericht.dhbw.enums.ServiceStatus;
import de.statusbericht.dhbw.enums.ServiceThema;
import de.statusbericht.dhbw.helper.Response;
import de.statusbericht.dhbw.jpa.Administrator;
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
 * @author Daniel Wenzl
 */

@WebServlet(urlPatterns = {"/detail/*"})
public class ServiceDetailServlet extends HttpServlet{
    
    public final static String URL = "/detail";
    
    @EJB
    ServiceeintragBean serviceBean;
    
    ServiceStatus serviceStatus;
    ServiceThema serviceThema;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long id = -1;
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.length() > 2) {
            try {
                id = Long.parseLong(pathInfo.split("/")[1]);
            } catch (NumberFormatException ex) {
                // URL enthält keine gültige Long-Zahl
            }
        }
        
        Response<Serviceeintrag> serviceResponse = serviceBean.findById(id);
        request.setAttribute("service", serviceResponse);

        ServiceStatus[] statusList = serviceStatus.values();
        request.setAttribute("statusList", statusList);

        ServiceThema[] themaList = serviceThema.values();
        request.setAttribute("themaList", themaList);
        
        request.getRequestDispatcher("/WEB-INF/serviceeintrag/servicedetail.jsp").forward(request, response);
    }
}
