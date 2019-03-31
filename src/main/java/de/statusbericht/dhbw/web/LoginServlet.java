/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.web;

import de.statusbericht.dhbw.ejb.AdministratorBean;
import de.statusbericht.dhbw.enums.ResponseStatus;
import de.statusbericht.dhbw.helper.Response;
import de.statusbericht.dhbw.jpa.Administrator;
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
 * @author Studium
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    public final static String URL = "/login";
    
    @EJB
    AdministratorBean adminBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/einloggen/einloggen.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String nickName = request.getParameter("nickName");
        String passwort = request.getParameter("passwort");
        Response<Administrator> responseA = adminBean.findByNick(nickName);

            if (responseA.getStatus() == ResponseStatus.ERFOLGREICH) {
                if (responseA.getResponse().getPasswort().trim().equals(passwort.trim())) {
                    responseA.setMessage("Passworteingabe Erfolgreich!");
                } else {
                    responseA.setStatus(ResponseStatus.ERROR);
                    responseA.setMessage("Falsches Passwort!");
                    request.setAttribute("nickName", nickName);
                    request.getRequestDispatcher("/WEB-INF/einloggen/einloggen.jsp").forward(request, response);
                    return;
                }
            } else {
                responseA.setStatus(ResponseStatus.ERROR);
                responseA.setMessage("Es gibt keinen Mitarbeiter mit dem eingegebenen Namen");
                request.getRequestDispatcher("/WEB-INF/einloggen/einloggen.jsp").forward(request, response);
                return;

            }
        
     
        session.setAttribute("administrator", responseA);
        response.sendRedirect(request.getContextPath());
    }
    
}
