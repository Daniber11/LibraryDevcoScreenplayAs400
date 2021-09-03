package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.Session;
import net.infordata.em.ExceptionHandler;
import net.infordata.em.TerminalClient;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.CountDownLatch;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitSystem;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.printScreen;
import static co.com.devco.automation.screenplay.as400.utils.SSLContextFactory.buildSSLContext;

public class OpenSession {

    private static TerminalClient client;
    private static ExceptionWaiter exceptionWaiter = new ExceptionWaiter();


    public static void openSessionTn5250(Session session) throws IOException, GeneralSecurityException {

        client = new TerminalClient();
        client.setConnectionTimeoutMillis(6000);
        client.setTerminalType("IBM-3179-2");
        client.setExceptionHandler(exceptionWaiter);
        client.setSocketFactory(buildSSLContext("TLS").getSocketFactory());
        client.connect(session.getHost(), session.getPort());
        waitSystem();
        printScreen();

    }

    public static TerminalClient getClientScreen5250() {
        return client;
    }

    private static class ExceptionWaiter implements ExceptionHandler {

        private CountDownLatch exceptionLatch = new CountDownLatch(1);
        private CountDownLatch closeLatch = new CountDownLatch(1);

        @Override
        public void onException(Throwable ex) {
            exceptionLatch.countDown();
        }

        @Override
        public void onConnectionClosed() {
            closeLatch.countDown();
        }

    }


}
