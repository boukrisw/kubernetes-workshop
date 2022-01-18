package me.escoffier.workshop.supes;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "second-service")
@Produces(MediaType.TEXT_PLAIN)
public interface SecondServiceClient {

    @Path("/quote")
    @GET
    String getQuote();

    @Path("/crash")
    @GET
    String crash();

}
