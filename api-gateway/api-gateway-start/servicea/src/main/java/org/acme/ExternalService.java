package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@RegisterClientHeaders(RequestJWTHeaderFactory.class)
@Path("/serviceB")
public interface ExternalService {
    @GET
    @Path("publicEP")
    String publicEP ();

    @GET
    @Path("userEP")
    String userEP ();

    @GET
    @Path("adminEP")
    String adminEP ();
}
