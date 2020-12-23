package com.testautomation.mesaj.stepdefinitions;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class CastOfUsers extends Cast {

    private EnvironmentVariables environmentVariables;

    public CastOfUsers() {
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");

        Actor user = super.actorNamed(actorName, abilities);
        user.can(CallAnApi.at(theRestApiBaseUrl));

        return user;
    }

}
