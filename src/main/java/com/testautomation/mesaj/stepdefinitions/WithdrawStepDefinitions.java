package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.models.Account;
import com.testautomation.mesaj.models.Money;
import com.testautomation.mesaj.transformers.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawStepDefinitions {

    @Given("^Julian es un cliente con una cuenta de ahorros$")
    public void julian_es_un_cliente_con_una_cuenta_de_ahorros() {
    }


    @Given("^en su cuenta tiene un saldo disponible de (\\d+\\.\\d+)$")
    public void en_su_cuenta_tiene_un_saldo_disponible_de(@Transform(MoneyConverter.class) Money pesos) {
        Account myAccount = new Account();
        myAccount.deposit(pesos);

    }

    @When("^el intenta retirar de su cuenta (\\d+)$")
    public void el_intenta_retirar_de_su_cuenta(int arg1) {

    }

    @Then("^el deberia obtener (\\d+)$")
    public void el_deberia_obtener(int arg1) {

    }

    @Then("^el nuevo saldo de su cuenta deberia ser (\\d+)$")
    public void el_nuevo_saldo_de_su_cuenta_deberia_ser(int arg1) {

    }
}
