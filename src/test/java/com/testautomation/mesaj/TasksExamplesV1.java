package com.testautomation.mesaj;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TasksExamplesV1 {
    Actor julian = Actor.named("Julian");

    @Test
    public void eating_apples() {
        Performable eatAnApple = new EatsAnApple();

        julian.attemptsTo(eatAnApple);
    }

    public static class EatsAnApple implements Performable {

        @Override
        public <T extends Actor> void performAs(T actor) {
            System.out.println("sssss");
        }
    }
}
