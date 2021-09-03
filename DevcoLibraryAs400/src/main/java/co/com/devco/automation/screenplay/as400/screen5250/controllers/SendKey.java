package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitSystem;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.printScreen;

public class SendKey {

    private static String text = "";

    public static void sendKey(int key) {
        OpenSession.getClientScreen5250().sendKeyEvent(key, 0);
        waitSystem();
        printScreen();
    }

    public static void sendKeyWithoutWait(String textInput) {

        text = textInput;

        OpenSession.getClientScreen5250().getFields().stream().forEach(
                field -> {

                    if (text.length() >= field.getLength()) {
                        field.setString(text.substring(0, field.getLength()));
                        text = text.substring(field.getLength());
                    } else if (!text.isEmpty()) {
                        field.setString(text);
                        text = text.substring(text.length());
                    }
                }
        );

        printScreen();

    }

}
