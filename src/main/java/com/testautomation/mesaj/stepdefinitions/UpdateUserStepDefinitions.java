package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.tasks.RegisterUser;
import com.testautomation.mesaj.tasks.UpdateUser;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserStepDefinitions {

    @When("^el envia el id (.*) el cual corresponde al usuario a actualizar$")
    public void elEnviaElIdDelUsuarioAActualizar(int id) {



        theActorInTheSpotlight().attemptsTo(
                UpdateUser.withId(id)
        );
    }
}
