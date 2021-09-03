package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class OpenScreen3270 implements Interaction {

    private Session sessionScreen;

    public OpenScreen3270(Session session) {
        this.sessionScreen = session;

    }

    @Step("{0} open session #pathSession")
    public <T extends Actor> void performAs(T Actor) {
        OpenSession.OpenSession3270(this.sessionScreen);

    }

    public static OpenScreen3270 session(Session sessionName) {
        return new OpenScreen3270(sessionName);
    }
}