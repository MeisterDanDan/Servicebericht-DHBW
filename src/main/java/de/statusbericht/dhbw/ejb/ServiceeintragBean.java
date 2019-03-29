/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.ejb;

import de.statusbericht.dhbw.enums.ResponseStatus;
import de.statusbericht.dhbw.helper.Response;
import de.statusbericht.dhbw.jpa.Serviceeintrag;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dominik Kunzmann
 */
@Stateless
public class ServiceeintragBean {
    @PersistenceContext
    protected EntityManager em;
    
    public Response<Serviceeintrag> createService(Serviceeintrag s) {
        Response<Serviceeintrag> response = new Response<>();
        try {
            em.persist(s);
            response.setResponse(em.merge(s));
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
        } finally {
            return response;
        }
    }
    
    public Response<Serviceeintrag> findById(long id) {
        Response<Serviceeintrag> response = new Response<>();
        try {
            response.setResponse(em.find(Serviceeintrag.class,
                    id));
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
        } finally {
            return response;
        }
    }
    
    public Response<Serviceeintrag> findAll() {
        Response<Serviceeintrag> response = new Response<>();
        try {
            Query query = em.createQuery("SELECT s FROM Serviceeintrag s");
            List<Serviceeintrag> services = query.getResultList();
            response.setResponseList(new ArrayList<Serviceeintrag>());
            
            for (Serviceeintrag s : services) {
                response.getResponseList().add(s);
            }
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }

    }
}
