package com.brotz.keycloak;

import org.keycloak.KeycloakPrincipal;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Component
@Path("/")
public class HelloController {
    @GET
    @Path("/hello")
    public String hello(@Context SecurityContext context) {
        // Yikes.
        return "Hello " + ((KeycloakPrincipal) context.getUserPrincipal()).getKeycloakSecurityContext().getToken().getName();
    }
}
