package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.questions.ResponseCode;
import com.testautomation.mesaj.tasks.RegisterUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Given("^Julian es un cliente que quiere poder administrar sus productos bancarios$")
    public void julianEsUnClienteQueQuierePoderAdministrarSusProductosBancarios() {
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");

        SerenityRest.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        //Create the cast to put the actor in scene.
        setTheStage(new OnlineCast());
        theActorCalled("Julian").describedAs("the trainer")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("^el envia la informacion requerida para el registro$")
    public void elEnviaLaInformacionRequeridaParaElRegistro() {
        theActorInTheSpotlight().attemptsTo(
                RegisterUser
                        .withName("morpheus")
                        .andEmail("tracey.ramos@reqres.in")
                        .andPassword("security")
                        .andJob("leader")
        );

    }

    @Then("^el debe obtener una cuenta virtual para poder ingresar cuando lo requiera$")
    public void elDebeObtenerUnaCuentaVirtualParaPoderIngresarCuandoLoRequiera() {
        theActorInTheSpotlight().should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );
    }
}
