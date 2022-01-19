package me.escoffier.workshop.supes;

import io.vertx.core.Vertx;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HeroResource {

    @Inject
    Vertx vertx;

    private static final Logger LOGGER = Logger.getLogger(HeroResource.class);

    @GET
    @Path("/heroes/random")
    public Hero getRandomHero() {
        Hero hero = Hero.findRandom();
        LOGGER.debug("Found random hero " + hero);
        return hero;
    }

    /**
     * Explicitly crashes the service.
     */
    @GET
    @Path("/crash")
    @Produces(MediaType.TEXT_PLAIN)
    public String crash() {
        LOGGER.info("Dying in ~1 second");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            vertx.close();
        }).start();
        return "bye bye Hero";
    }
}
