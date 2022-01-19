package me.escoffier.workshop.supes;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FightResource {

    @Inject @RestClient HeroClient heroClient;

    @GET
    @Path("/heroes/random")
    public Hero getRandomHero() {
        return heroClient.getHero();
    }

    @Inject @RestClient VillainClient villainClient;

    @GET
    @Path("/villains/random")
    public Villain getRandomVillain() {
        return villainClient.getVillain();
    }

    @GET
    @Path("/fight")
    public Fight fight() {
        return fight(
                getRandomHero(),
                getRandomVillain()
        );
    }

    private final Random random = new Random();

    private Fight fight(Hero hero, Villain villain) {
        int heroAdjust = random.nextInt(20);
        int villainAdjust = random.nextInt(20);

        if ((hero.level + heroAdjust) >= (villain.level + villainAdjust)) {
            return new Fight(hero, villain, hero.name);
        } else {
            return new Fight(hero, villain, villain.name);
        }
    }

}
