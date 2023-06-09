package org.acme;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/serviceA")

public class GreetingResource {

    @Inject
    @RestClient
    ExternalService externalService; 

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/publicEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_publicEP() {
        return externalService.publicEP();   
    }

    @GET
    @Path("/userEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_userEP() {
        return externalService.userEP();   
    }

    @GET
    @Path("/adminEP")
    @Produces(MediaType.TEXT_PLAIN)
    public String call_adminEP() {
        return externalService.adminEP();   
    }
}
