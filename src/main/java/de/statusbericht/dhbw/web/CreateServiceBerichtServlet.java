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
 * @author Studium
 */

@WebServlet(name = "CreateServiceBerichtServlet", urlPatterns = {"/newServicebericht"})
public class CreateServiceBerichtServlet extends HttpServlet{
    
    public static final String URL = "/newServicebericht";
    
    @EJB
    ServiceeintragBean serviceBean;
    
    ServiceStatus serviceStatus;
    ServiceThema serviceThema;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Response<Serviceeintrag> neuerServiceeintrag = new Response<>();
        request.setAttribute("detailService", neuerServiceeintrag);

        ServiceStatus[] statusList = serviceStatus.values();
        request.setAttribute("statusList", statusList);

        ServiceThema[] themaList = serviceThema.values();
        request.setAttribute("themaList", themaList);

        request.getRequestDispatcher("/WEB-INF/serviceeintrag/serviceeintrag.jsp").forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        Serviceeintrag s = new Serviceeintrag();

        //Setzen der Werte für Serviceeintrag
        
        //String Variablen:
        s.setBeschreibung(request.getParameter("beschreibung"));
        s.setBild(request.getParameter("bild"));
        s.setOrt(request.getParameter("ort"));
        
        //Float/Integer Variablen:           
        s.setZustimmung(1);
        
        //Enums:
        try {
            s.setStatus(Enum.valueOf(ServiceStatus.class, "Status"));
        } catch (IllegalArgumentException ex) {
            System.out.println("Das Enum ServiceStatus sind noch nicht gefüllt");
        }
        try {
            s.setThema(Enum.valueOf(ServiceThema.class, request.getParameter("thema")));
        } catch (IllegalArgumentException ex) {
            System.out.println("Das Enum ServiceThema sind noch nicht gefüllt");
        }
        

        
        s = serviceBean.createService(s).getResponse();
        response.sendRedirect(request.getContextPath() + ServiceDetailServlet.URL + "/" + s.getId());
        
    }
}
