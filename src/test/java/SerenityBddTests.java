import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SerenityBddTests {


    private final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void initialTest(){
        Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(
                Get.resource("/users?page=2")
        );

        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }
}
