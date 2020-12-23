package com.testautomation.mesaj.questions;

import com.testautomation.mesaj.models.UpdatedUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class WasTheUserUpdated {

    public Question<UpdatedUser> at() {
        return Question.about("user update status").answeredBy(
                actor -> SerenityRest.lastResponse().as(UpdatedUser.class));
    }
}




/*actor.attemptsTo(
        Ensure.that(lastResponse.body().jsonPath().get("attempts").toString()).isEqualTo("-1")
    );
* */

/*
* public class WasTheUserUpdated implements Question {

    @Override
    public UpdatedUser answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UpdatedUser.class);
    }
}*/