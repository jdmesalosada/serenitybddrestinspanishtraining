package com.testautomation.mesaj;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TaskExamplesV3 {

    Actor julian = Actor.named("Julian");

    @Test
    public void eating_apples() {
        julian.attemptsTo(
                Eat.anApple(),
                Eat.aLargePear(),
                Eat.aSmallPear());
    }

    public static class Eat {
        public static Performable anApple() {
            return new EatsAnApple();
        }

        public static Performable aLargePear() {
            return new EatsAPear("large");
        }

        public static Performable aSmallPear() {
            return new EatsAPear("small");
        }

    }

    public static class EatsAnApple implements Performable {

        @Override
        public <T extends Actor> void performAs(T actor) {
            System.out.println("eats an apple");
        }
    }

    public static class EatsAPear implements Performable {

        // Tenemos que añadir un constructor por defecto con el fin
        //de que Serenity pueda construir el objeto EatsAPear.
        //Al hacer esto no podemos dejar que el parametro size sea final con lo cual
        //perdemos la inmutabilidad. Con los builders es recomendable tener los campos final
        //pero aca tenemos una restricción. Asi que aca tenemos que sacrificar
        //la inmutabilidad por la legibilidad que nos ofrece.
        public EatsAPear() {
        }

        private String size = "";

        public EatsAPear(String size) {
            this.size = size;
        }

        @Override
        @Step("{0} eats a #size pear")
        public <T extends Actor> void performAs(T actor) {
            System.out.println("eats a pear");
        }
    }
}
