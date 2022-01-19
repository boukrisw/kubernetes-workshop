package me.escoffier.workshop.supes;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RegisterRestClient(configKey = "villain-monolith")
public interface VillainClient {

    @Path("/villains/random")
    @GET
    Villain getVillain();

    @Path("/crash")
    @GET
    String crash();
}
