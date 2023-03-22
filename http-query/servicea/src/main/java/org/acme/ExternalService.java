package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/serviceB")
public interface ExternalService {
    @GET
    @Path("publicEP")
    String publicEP ();

    @GET
    @Path("userEP")
    String userEP (@QueryParam("role") String role);

    @GET
    @Path("adminEP")
    String adminEP (@QueryParam("role") String role);
}
