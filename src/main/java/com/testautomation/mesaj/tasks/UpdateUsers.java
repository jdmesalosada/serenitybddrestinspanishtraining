package com.testautomation.mesaj.tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class UpdateUsers implements Task {

    private final List<Integer> ids;

    protected UpdateUsers(List<Integer> userIds) {
        this.ids = ImmutableList.copyOf(userIds);
    }

    //#id name of the variable to print in the report.
    @Step("{0} update the users with ids #ids")
    public <T extends Actor> void performAs(T actor) {
        ids.forEach(
                id -> actor.attemptsTo(
                        UpdateUser.withId(id)
                )
        );
    }

    public static UpdateUsers withIds(Integer... ids) {
        return Instrumented.instanceOf(UpdateUsers.class)
                .withProperties(ids);
    }
}
