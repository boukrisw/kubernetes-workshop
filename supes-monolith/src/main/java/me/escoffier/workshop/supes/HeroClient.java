package me.escoffier.workshop.supes;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RegisterRestClient(configKey = "hero-monolith")
public interface HeroClient {

    @Path("/heroes/random")
    @GET
    Hero getHero();
}
