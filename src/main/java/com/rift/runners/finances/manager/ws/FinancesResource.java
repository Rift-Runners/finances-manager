/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.ws;

import com.rift.runners.finances.manager.entity.Finance;
import com.rift.runners.finances.manager.service.FinanceService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@Path("/finances")
public class FinancesResource {

    @EJB
    private FinanceService financeService;

    /**
     * Creates a new instance of GenericResource
     */
    public FinancesResource() {
    }

    /**
     * Retrieves representation of an instance of resumer.FinancesResource
     *
     * @param finance
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertFinance(Finance finance) {
        financeService.save(finance);
    }

    /**
     * PUT method for updating or creating an instance of FinancesResource
     *
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Finance> getFinances() {
        return financeService.listAll();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void editFinance(Finance finance) {
        financeService.edit(finance);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteFinance(Finance finance) {
        financeService.delete(financeService.find(finance));
    }

}
