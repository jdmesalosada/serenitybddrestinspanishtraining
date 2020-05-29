package com.testautomation.mesaj.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PayUtilitiesStepDefinitions {
    @Given("^Pedro es un cliente del banco$")
    public void pedro_es_un_cliente_del_banco() {

        System.out.println("cliente de banco");
    }


    @Given("^el ya inicio sesion en la aplicacion$")
    public void el_ya_inicio_sesion_en_la_aplicacion() {
        System.out.println("inicio de sesion");
    }

    @Given("^el tiene pendiente el pago del servicio del gas$")
    public void el_tiene_pendiente_el_pago_del_servicio_del_gas() {

    }

    @When("^el intente realizar el pago del servicio$")
    public void el_intente_realizar_el_pago_del_servicio() {

    }

    @Then("^el debe ser notificado del pago exitoso$")
    public void el_debe_ser_notificado_del_pago_exitoso() {

    }

    @Given("^el tiene pendiente el pago del servicio de la electricidad$")
    public void el_tiene_pendiente_el_pago_del_servicio_de_la_electricidad() {

    }

    @Then("^el debe ser notificado que el pago no fue exitoso$")
    public void el_debe_ser_notificado_que_el_pago_no_fue_exitoso() {

    }

    @Given("^el tiene vencido el pago del servicio de internet$")
    public void el_tiene_vencido_el_pago_del_servicio_de_internet() {

    }
}
