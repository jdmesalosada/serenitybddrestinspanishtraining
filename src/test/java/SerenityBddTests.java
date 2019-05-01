import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import questions.ResponseCode;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(SerenityRunner.class)
public class SerenityBddTests {

    private final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void initialTest() {
        Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(
                GetUsers.fromPage(3)
        );

        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );
    }

}
