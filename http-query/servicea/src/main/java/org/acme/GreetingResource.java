package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/serviceA")

public class GreetingResource {

    @Inject
    @RestClient
    ExternalService externalService; 

    @GET
    @Path("/publicEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_publicEP() {
        return externalService.publicEP();   
    }

    @GET
    @Path("/userEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_userEP(@QueryParam("role") String role) {
        return externalService.userEP(role);   
    }

    @GET
    @Path("/adminEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_adminEP(@QueryParam("role") String role) {
        return externalService.adminEP(role);   
    }
}