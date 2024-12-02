package org.example.testing.task;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPassengerToAirlines implements Task {



    private final String name, trips;
    private final String airlineId, airlineName, airlineCountry, airlineLogo, airlineSlogan, airlineHeadQuarters, airlineWebsite, airlineEstablished;

    public PostPassengerToAirlines(String name, String trips, String airlineId, String airlineName, String airlineCountry,
                                   String airlineLogo, String airlineSlogan, String airlineHeadQuarters, String airlineWebsite, String airlineEstablished) {
        this.name = name;
        this.trips = trips;
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.airlineCountry = airlineCountry;
        this.airlineLogo = airlineLogo;
        this.airlineSlogan = airlineSlogan;
        this.airlineHeadQuarters = airlineHeadQuarters;
        this.airlineWebsite = airlineWebsite;
        this.airlineEstablished = airlineEstablished;
    }

    public static Performable fromData(String name, String trips, String airlineId, String airlineName, String airlineCountry,
                                       String airlineLogo, String airlineSlogan, String airlineHeadQuarters, String airlineWebsite, String airlineEstablished) {
        return instrumented(PostPassengerToAirlines.class, name, trips, airlineId, airlineName, airlineCountry, airlineLogo,
                airlineSlogan, airlineHeadQuarters, airlineWebsite, airlineEstablished);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/passenger").with(requestSpecification ->
                requestSpecification.contentType(ContentType.JSON).body("{" +
                        "\"name\": \"" + name + "\"," +
                        "\"trips\": " + trips + "," +
                        "\"airline\": [{" +
                        "\"_id\": \"" + airlineId + "\"," +
                        "\"name\": \"" + airlineName + "\"," +
                        "\"country\": \"" + airlineCountry + "\"," +
                        "\"logo\": \"" + airlineLogo + "\"," +
                        "\"slogan\": \"" + airlineSlogan + "\"," +
                        "\"head_quaters\": \"" + airlineHeadQuarters + "\"," +
                        "\"website\": \"" + airlineWebsite + "\"," +
                        "\"established\": \"" + airlineEstablished + "\"" +
                        "}]" +
                        "}").log().all()));

    }
}
