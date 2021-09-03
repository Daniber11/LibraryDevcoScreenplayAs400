package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import jline.internal.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.getClientScreen3270;

public class ControlWait {

    private static final CountDownLatch lock = new CountDownLatch(1);


    public static void waitSystem() {

        String lastScreen = getClientScreen3270().getScreenText();
        int intentos = 0;

        while (!getClientScreen3270().getScreenText().isEmpty() && lastScreen.equals(getClientScreen3270().getScreenText())) {
            lastScreen = getClientScreen3270().getScreenText();
        }

        while (true) {
            intentos = (lastScreen.contains(getClientScreen3270().getScreenText().trim())) && !lastScreen.isEmpty() ? intentos + 1 : intentos;
            if (intentos >= 100) {
                break;
            }
            lastScreen = getClientScreen3270().getScreenText().trim();
        }

        waitTime(500);

    }

    public static void waitStringInScreen(String text) {

        while (!getClientScreen3270().getScreenText().toUpperCase().contains(text.toUpperCase())) {
            getClientScreen3270().getScreenText();
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
