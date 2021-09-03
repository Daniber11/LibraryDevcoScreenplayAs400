package co.com.devco.automation.screenplay.as400.screen5250.utils;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;

public class Close {

    public static void session() {
        OpenSession.getClientScreen5250().disconnect();
    }

}
