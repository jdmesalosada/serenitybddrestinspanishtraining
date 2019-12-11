package com.testautomation.mesaj.stepdefinitions;

import com.testautomation.mesaj.interactions.Post;
import cucumber.api.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;

public class CalculatorStepDefinitions {

    private static final String serviceUrl = "http://www.dneonline.com";

    private static HashMap<String, String> headers;

    static {
        headers = new HashMap<>();
        headers.put("Content-Type", "text/xml;charset=UTF-8");
        headers.put("SOAPAction", "http://tempuri.org/Add");
    }

    @Given("^el quiere sumar dos numeros$")
    public void el_quiere_sumar_dos_numeros() {
        Actor julian = Actor.named("Actor that can call a Soap Service.");

        julian.can(CallAnApi.at(serviceUrl));

        SerenityRest.given().headers(headers);

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tem:Add>\n" +
                "         <tem:intA>1</tem:intA>\n" +
                "         <tem:intB>1</tem:intB>\n" +
                "      </tem:Add>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        julian.attemptsTo(

                Post.to("/calculator.asmx").with(
                        requestSpecification -> requestSpecification
                                .body(request)
                        .headers(headers)

        ));

        String response = SerenityRest.lastResponse().asString();

        XmlPath result = SerenityRest.lastResponse().body().xmlPath();

        System.out.println(response);

    }

}
