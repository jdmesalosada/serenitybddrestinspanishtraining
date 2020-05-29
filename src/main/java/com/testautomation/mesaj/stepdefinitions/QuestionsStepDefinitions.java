package com.testautomation.mesaj.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class QuestionsStepDefinitions {


    Actor julian;
    String actualMessage;
    Question<String> actualQuestionMessage;

    @Given("^que tengo un dato cualquiera$")
    public void que_tengo_un_dato_cualquiera() {
        julian = Actor.named("julian");
        actualMessage = "hola mundo";
    }

    @When("^quiero obtener una question$")
    public void quiero_obtener_una_question() {
        actualQuestionMessage = Question.about("el mensaje actual")
                .answeredBy(actor -> actualMessage);

    }

    @Then("^puedo hacer una asercion$")
    public void puedo_hacer_una_asercion() {
        julian.should(
                seeThat("", actualQuestionMessage, equalTo("hola mundo1"))
        );
    }

}
