package org.example.testing.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.example.testing.question.ResponseCode;
import org.example.testing.task.GetPokemonByGender;
import org.example.testing.task.GetPokemonByName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PokemonStepDefinitions {
    public static Logger LOGGER = LoggerFactory.getLogger(PokemonStepDefinitions.class);



    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint GET para obtener el pokemon")
    public void elActorEstableceElEndpointGETParaObtenerElPokemon(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} consulta el pokemon llamado {string}")
    public void elActorConsultaElPokemonLlamado(Actor actor,String name) {
        actor.attemptsTo(GetPokemonByName.fromName(name));

    }


    @Then("el codigo de respuesta HTTP deberia ser {int} para la consulta")
    public void elCodigoDeRespuestaHTTPDeberiaSerParaLaConsulta(int responseCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código de respuesta", ResponseCode.getStatus(), equalTo(responseCode))
        );
    }


    @Given("el {actor} establece el endpoint GET para obtener los pokemones por genero")
    public void elActorEstableceElEndpointGETParaObtenerLosPokemonesPorGenero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} consulta los pokemones de genero {string}")
    public void elActorConsultaLosPokemonesDeGenero(Actor actor, String gender) {
        actor.attemptsTo(GetPokemonByGender.fromGender(gender));
    }
}
