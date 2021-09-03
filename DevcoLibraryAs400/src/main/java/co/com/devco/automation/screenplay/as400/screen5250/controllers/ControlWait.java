package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import jline.internal.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ControlWait {

    private static final CountDownLatch lock = new CountDownLatch(1);


    public static void waitSystem() {

        String lastScreen = OpenSession.getClientScreen5250().getScreenText();

        while (!OpenSession.getClientScreen5250().getScreenText().isEmpty() && lastScreen.equals(OpenSession.getClientScreen5250().getScreenText())) {
            lastScreen = OpenSession.getClientScreen5250().getScreenText();
        }

        waitTime(500);

    }

    public static void waitStringInScreen(String text) {

        while (!OpenSession.getClientScreen5250().getScreenText().toUpperCase().contains(text.toUpperCase())) {
            OpenSession.getClientScreen5250().getScreenText();
        }

    }

    public static void waitTime(long timeoutMillis) {

        try {
            lock.await(timeoutMillis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.error(e);
        } finally {
            lock.countDown();
        }
    }

}
