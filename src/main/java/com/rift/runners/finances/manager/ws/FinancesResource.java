/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.ws;

import com.rift.runners.finances.manager.entity.Finance;
import com.rift.runners.finances.manager.service.FinanceService;
import javax.ejb.EJB;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Guilherme
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
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/insertFinance")
    public Finance insertFinance(Finance teste) {
        financeService.save(teste);
        return teste;
    }

    /**
     * PUT method for updating or creating an instance of FinancesResource
     *
     * @param zik representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("/{a}")
    @Consumes("application/json")
    public void putJson(@PathParam("a") String zik) {

    }
}
