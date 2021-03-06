/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.servicebericht.common.rest;

import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.TaskStatus;
import dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa.TaskToRet;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author PatrickGießler
 */
@Stateless

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TicketRes {

    @EJB
    private TaskBean taskBean;

    @Path("Tickets")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskToRet> findTickets() {
        return this.taskBean.getTasks();
    }
    @Path("Tickets/status")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskToRet> findTicketsAllStatus() {
        return this.taskBean.getTasks();
    }
    

    @POST
    public Task saveNewTicket(@Valid Task ticket) {
        return this.taskBean.saveNew(ticket);
    }

    @GET
    @Path("Tickets/status/{status}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskToRet> getTicketsByStatus(@PathParam("status") String sStatus) {
         
       TaskStatus test  = TaskStatus.valueOf(sStatus);
       
        
        return this.taskBean.findByStatus(test);
    }
}
