package hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ConfHooks {

    /*private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor johnWick;

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");

        johnWick = Actor.named("Sam the supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl));
        OnStage.setTheStage(new OnlineCast());
    }*/

}
