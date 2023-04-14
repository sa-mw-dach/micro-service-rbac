package org.acme;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class RequestJWTHeaderFactory implements ClientHeadersFactory {
  

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedHashMap<String, String> headers = new MultivaluedHashMap<>();
        String authorization = incomingHeaders.getFirst("Authorization");

        if (authorization != null) {
            headers.putSingle("Authorization", authorization);
        }

        return headers;
    }

}
