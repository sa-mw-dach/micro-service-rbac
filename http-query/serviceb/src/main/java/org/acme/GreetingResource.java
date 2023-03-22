package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/serviceB")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/publicEP")
    public String publicService(@QueryParam("role") String role) {
        return "I don't care which role you have. I always greet you!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/userEP")
    public String helloUser(@QueryParam("role") String role) {
        if (role.equals("user")) {
            return "I greet you because you are a user!";
        } else {
            return "I don't greet you because you are not a user!";
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/adminEP")
    public String helloAdmin(@QueryParam("role") String role) {
        if (role.equals("admin")) {
            return "I greet you because you are a admin!";
        } else {
            return "I don't greet you because you are not a admin!";
        }
    }
} 