package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.openSessionTn5250;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenScreen5250 implements Interaction {

    private Session sessionScreen;
    private String host;
    private int port;

    public OpenScreen5250(Session session) {

        this.sessionScreen = session;
        this.host = session.getHost();
        this.port = session.getPort();

    }

    @Step("{0} starts the session with host #host on port #port")
    public <T extends Actor> void performAs(T Actor) {
        try {
            openSessionTn5250(this.sessionScreen);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }

        TakeProofEvidence.InScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    public static OpenScreen5250 session(Session sessionName) {
        return instrumented(OpenScreen5250.class, sessionName);
    }
}