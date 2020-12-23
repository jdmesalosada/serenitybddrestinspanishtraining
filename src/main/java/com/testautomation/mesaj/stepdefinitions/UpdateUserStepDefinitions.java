package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.tasks.UpdateUser;
import com.testautomation.mesaj.tasks.UpdateUsers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserStepDefinitions {

    @When("^el envia el id (.*) el cual corresponde al usuario a actualizar$")
    public void elEnviaElIdDelUsuarioAActualizar(int id) {
        theActorInTheSpotlight().attemptsTo(
                UpdateUser.withId(id)
        );
    }

    @When("^el envia los ids (.*) de los usuarios a actualizar$")
    public void elEnviaLosUsuariosAActualizar(Integer... ids) {
        theActorInTheSpotlight().attemptsTo(
                UpdateUsers.withIds(ids)
        );
    }

    @Then("^el usuario con id (.*) deberia ser actualizado$")
    public void elUsuarioDeberiaSerActualizado(int id) {

    }
}
