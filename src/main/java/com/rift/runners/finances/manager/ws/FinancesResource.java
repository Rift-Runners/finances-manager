/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.ws;

import com.rift.runners.finances.manager.entity.Finance;
import com.rift.runners.finances.manager.service.FinanceService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
import javax.ws.rs.core.Response;

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

    @GET
    @Path("/getAsPdf")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFinancesAsPdf() throws IOException {
        String jsonDoc1 = "[  {\n"
                + "    \"financeValue\": 12323,\n"
                + "    \"id\": 1,\n"
                + "    \"name\": \"EDItouasjdjasdjhhh\",\n"
                + "    \"paid\": true,\n"
                + "    \"subject\": {\n"
                + "      \"id\": 2,\n"
                + "      \"name\": \"teste\"\n"
                + "    },\n"
                + "    \"type\": \"Debit\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": 2,\n"
                + "    \"name\": \"Test\",\n"
                + "    \"subject\": {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"1212\"\n"
                + "    },\n"
                + "    \"type\": \"Debit\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"financeValue\": 122,\n"
                + "    \"id\": 3,\n"
                + "    \"name\": \"Debit\",\n"
                + "    \"paid\": false,\n"
                + "    \"subject\": {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"1212\"\n"
                + "    },\n"
                + "    \"type\": \"Debit\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": 4,\n"
                + "    \"name\": \"Credit\",\n"
                + "    \"subject\": {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"1212\"\n"
                + "    },\n"
                + "    \"type\": \"Credit\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"financeValue\": 23,\n"
                + "    \"id\": 5,\n"
                + "    \"name\": \"Aeee\",\n"
                + "    \"subject\": {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"1212\"\n"
                + "    },\n"
                + "    \"type\": \"Credit\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"financeValue\": 123,\n"
                + "    \"id\": 6,\n"
                + "    \"name\": \"sim\",\n"
                + "    \"paid\": true,\n"
                + "    \"subject\": {\n"
                + "      \"id\": 4,\n"
                + "      \"name\": \"aeho\"\n"
                + "    },\n"
                + "    \"type\": \"Debit\"\n"
                + "  }]";

        List<String> lines = Arrays.asList("The first line", "The second line");
        java.nio.file.Path file = Paths.get("C:/Users/Guilherme/Desktop/out.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
        
        return Response.ok(new File("C:/Users/Guilherme/Desktop/out.txt"), MediaType.APPLICATION_OCTET_STREAM).
                header("Content-Disposition", "attachment; filename=\"finances.txt\"")
                .build();
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
