package co.com.devco.automation.screenplay.as400.screen3270.utils;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession;
import jline.internal.Log;

public class Close {

    public static void sessionScreen3270() {
        try {
            OpenSession.getClientScreen3270().disconnect();
        } catch (InterruptedException e) {
            Log.error(e);
        }
    }

}
