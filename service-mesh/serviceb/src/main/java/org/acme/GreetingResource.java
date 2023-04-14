package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.reactive.RestHeader;

@Path("/serviceB")
public class GreetingResource {
    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/publicEP")
    public String publicService() {
        return "I don't care which role you have. I always greet you!\n The JWT is: " + jwt.getRawToken();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/userEP")
    public String helloUser() {
        return "I greet you because you are a user!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/adminEP")
    public String helloAdmin() {
        return "I greet you because you are a admin!";
    }
} 