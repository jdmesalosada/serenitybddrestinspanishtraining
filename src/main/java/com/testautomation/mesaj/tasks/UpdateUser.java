package com.testautomation.mesaj.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUser {

    public static Task withId(int id) {
        return Task.where("{0} update the user with id",
                Put.to("/users/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }


    /*query param
    * /users?page=2
    * Get.resource("/users").with( request -> request.queryParam("page", 2))
    * */
}
