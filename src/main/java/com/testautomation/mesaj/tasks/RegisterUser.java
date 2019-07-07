package com.testautomation.mesaj.tasks;

import com.testautomation.mesaj.interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final Object userInfo;

    public RegisterUser(Object userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(Object userInfo) {
        return instrumented(RegisterUser.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
