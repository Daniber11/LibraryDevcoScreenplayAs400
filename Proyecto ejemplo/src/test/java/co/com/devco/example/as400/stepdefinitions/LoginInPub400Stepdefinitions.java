package co.com.devco.example.as400.stepdefinitions;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.Enter;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.Hit;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.OpenScreen5250;
import co.com.devco.automation.screenplay.as400.screen5250.questions.Text;
import co.com.devco.automation.screenplay.as400.screen5250.utils.Close;
import co.com.devco.automation.screenplay.as400.screen5250.utils.KeysScreen5250;
import co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.devco.example.as400.userinterfaces.login.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginInPub400Stepdefinitions {

    @When("^make the process login in the terminal pub400$")
    public void makeTheProcessLoginInTheTerminalPub() {

        PrintScreen.setPrintIndicator(false);
        theActorInTheSpotlight().attemptsTo(
                OpenScreen5250.session(Session.withHost("pub400.com").andPort(992)),
                Enter.theValue("GUSECHE").into(USUARIO),
                Enter.theValue("HOLA MUNDO").into(CLAVE),
                Hit.the(KeysScreen5250.ENTER)
        );

    }


    @Then("^the login process was successful$")
    public void theLoginProcessWasSuccessful() {

//        Ensure.that(Text.of(MENSAJE)).contains("Exxitoso").performAs(theActorInTheSpotlight());
        Ensure.that(Text.of(MENSAJE)).contains("CPF1107 - Password not correct for use").performAs(theActorInTheSpotlight());

        Close.session();

    }

}
