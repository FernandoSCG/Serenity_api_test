package org.example.testing.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPokemonByName implements Task {
    private final String pokemonName;

    public GetPokemonByName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public static Performable fromName(String pokemonName) {
        return instrumented(GetPokemonByName.class, pokemonName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pokemon/" + pokemonName).with(
                        requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.JSON)
                                        .log().all()
                )
        );
    }
}
