package org.acme;

import javax.annotation.security.RolesAllowed;
import javax.resource.spi.work.SecurityContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/serviceB")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/publicEP")
    public String publicService() {
        return "I don't care which role you have. I always greet you!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/userEP")
    @RolesAllowed("users")
    public String helloUser() {
        return "I greet you because you are a user";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/adminEP")
    @RolesAllowed("admins")
    public String helloAdmin() {
        return "I greet you because you are a admin!";
    }
} 