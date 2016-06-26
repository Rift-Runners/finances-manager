/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.ws;

import com.rift.runners.finances.manager.entity.Subject;
import com.rift.runners.finances.manager.service.SubjectService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Guilherme
 */
@Path("/subjects")
public class SubjectsResource {

    @EJB
    private SubjectService subjectService;

    /**
     * Creates a new instance of GenericResource
     */
    public SubjectsResource() {
    }

    /**
     * Retrieves representation of an instance of resumer.FinancesResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertSubject(Subject teste) {
        subjectService.save(teste);
        return "Subject Inserted";
    }

    /**
     * PUT method for updating or creating an instance of FinancesResource
     *
     * @param zik representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> getFinances() {
        return subjectService.listAll();
    }
}
