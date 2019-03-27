/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.ejb;

import de.statusbericht.dhbw.enums.ResponseStatus;
import de.statusbericht.dhbw.helper.Response;
import de.statusbericht.dhbw.jpa.Kommentar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dominik Kunzmann
 */
@Stateless
public class KommentarBean {
    @PersistenceContext
    protected EntityManager em;
    
    public Response<Kommentar> findById(long id) {
        Response<Kommentar> response = new Response<>();
        try {
            response.setResponse(em.find(Kommentar.class,
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
}
