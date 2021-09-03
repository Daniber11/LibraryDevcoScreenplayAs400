import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.OpenScreen5250;
import co.com.devco.automation.screenplay.as400.screen5250.utils.Close;
import co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen;
import com.bytezone.dm3270.display.ScreenDimensions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import com.bytezone.dm3270.TerminalClient;

public class principal {

    public static void main(String[] args) {

        TerminalClient terminal = new TerminalClient(2, new ScreenDimensions(24, 80));

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Pepito");

        PrintScreen.setPrintIndicator(true);

        theActorInTheSpotlight().attemptsTo(
                OpenScreen5250.session(Session.withHost("pub400.com").andPort(992))
        );

        PrintScreen.printScreen();

        Close.session();

        elemento(co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.getClientScreen5250());
        elemento(terminal);



    }


    public static void elemento(Object elemento){
        System.out.println(elemento.getClass());
    }

}
