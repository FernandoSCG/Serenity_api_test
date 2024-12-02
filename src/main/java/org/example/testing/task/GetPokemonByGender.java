package org.example.testing.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPokemonByGender implements Task {
    private final String genderType;

    public GetPokemonByGender(String genderType) {
        this.genderType = genderType;
    }

    public static Performable fromGender(String genderType) {
        return instrumented(GetPokemonByGender.class, genderType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/gender/" + genderType).with(
                        requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.JSON)
                                        .log().all()
                )
        );
    }
}
