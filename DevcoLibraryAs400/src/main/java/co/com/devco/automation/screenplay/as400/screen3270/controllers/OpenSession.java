package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen3270.utils.PrintScreen;
import co.com.devco.automation.screenplay.as400.utils.SSLContextFactory;
import com.bytezone.dm3270.TerminalClient;
import com.bytezone.dm3270.display.ScreenDimensions;
import jline.internal.Log;

import javax.net.SocketFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class OpenSession {

    private static TerminalClient client;

    public static void OpenSession3270(Session session) {

        client = new TerminalClient(2, new ScreenDimensions(24, 80));
        client.setUsesExtended3270(false);
        client.setConnectionTimeoutMillis((int) 60000);
        client.setSocketFactory(getSocketFactory("TLS", session.getHost()));
        client.connect(session.getHost(), session.getPort());
        ControlWait.waitSystem();
        PrintScreen.printScreen();

    }

    public static TerminalClient getClientScreen3270() {
        return client;
    }

    private static SocketFactory getSocketFactory(String sslType, String server) {

        try {
            return SSLContextFactory.buildSSLContext(sslType).getSocketFactory();
        } catch (GeneralSecurityException | IOException var4) {
            Log.error(var4 + server);
        }

        return SocketFactory.getDefault();

    }
}