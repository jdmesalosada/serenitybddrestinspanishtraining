package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.models.users.RegisterUserInfo;
import com.testautomation.mesaj.questions.ResponseCode;
import com.testautomation.mesaj.tasks.RegisterUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDefinitions {

    private final String restApiUrl = "http://localhost:5000/api";
    Actor julian;

    @Given("^Julian es un cliente que quiere poder administrar sus productos bancarios$")
    public void julianEsUnClienteQueQuierePoderAdministrarSusProductosBancarios() {
        julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

    }

    @When("^el envia la informacion requerida para el registro$")
    public void elEnviaLaInformacionRequeridaParaElRegistro() {
        julian.attemptsTo(
                RegisterUser
                        .withName("morpheus")
                        .andEmail("tracey.ramos@reqres.in")
                        .andPassword("security")
                        .andJob("leader")
        );

    }

    @Then("^el debe obtener una cuenta virtual para poder ingresar cuando lo requiera$")
    public void elDebeObtenerUnaCuentaVirtualParaPoderIngresarCuandoLoRequiera() {
        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );
    }
}
