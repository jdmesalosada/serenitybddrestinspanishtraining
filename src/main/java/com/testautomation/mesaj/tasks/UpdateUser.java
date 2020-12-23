package com.testautomation.mesaj.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUser {

    public static Task withId(int id) {
        return Task.where("{0} update the user with id #id",
                Put.to("/users/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }

    /*query param
    * /users?page=2
    * Get.resource("/users").with( request -> request.queryParam("page", 2))
    * */
}

/*
* public class FindAUser implements Task{
    private final int id;

    public FindAUser(int id) {
        this.id = id;
    }

    public static FindAUser withId(int id) {
        return instrumented(FindAUser.class, id);
    }

    @Override
    @Step("{0} fetches the user with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users/{id}")
                   .with(request -> request.pathParam("id", id))
        );
    }
}*/
