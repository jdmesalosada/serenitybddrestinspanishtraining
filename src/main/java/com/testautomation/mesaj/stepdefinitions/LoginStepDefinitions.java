package com.testautomation.mesaj.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

    @Given("^Julian es un cliente que quiere iniciar sesion para administrar sus productos$")
    public void julian_es_un_cliente_que_quiere_iniciar_sesion_para_administrar_sus_productos() {

    }

    @Then("^el debe ser informado que la contrasena no es valida$")
    public void el_debe_ser_informado_que_la_contrasena_no_es_valida() {

    }

    @When("^el envia la contrasena (.*)$")
    public void el_envia_la_contrasena(String pass) {

        System.out.println(pass);
    }


}
