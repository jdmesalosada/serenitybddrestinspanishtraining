import models.users.Datum;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


@RunWith(SerenityRunner.class)
public class SerenityBddTests {

    private final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void initialTest() {
        Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(
                GetUsers.fromPage(1)
        );

        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );


        Datum user = new GetUsersQuestion().answeredBy(julian)
                .getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);


        julian.should(
                seeThat("usuario no es nulo", act -> user, notNullValue())
        );

        julian.should(
                seeThat("el email del usuario", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("el avatar del usuario", act -> user.getAvatar(), equalTo("avatar"))
        );
    }
}