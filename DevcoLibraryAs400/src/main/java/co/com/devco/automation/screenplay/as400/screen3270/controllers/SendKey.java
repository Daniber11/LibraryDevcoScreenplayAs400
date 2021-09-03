package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.screen3270.utils.PrintScreen;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.ControlWait.waitSystem;
import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.getClientScreen3270;

public class SendKey {

    private static String text = "";

    public static void sendKey(byte key, String keyName) {
        getClientScreen3270().sendAID(key, keyName);
        waitSystem();
        PrintScreen.printScreen();
    }

    public static void sendKeyWithoutWait(String textInput) {

        text = textInput;

        getClientScreen3270().getFields().stream().forEach(
                field -> {

                    if (field.getText().trim().equals("")) {
                        if (text.length() >= field.getDisplayLength()) {
                            field.setText(text.substring(0, field.getDisplayLength()));
                            text = text.substring(field.getDisplayLength());
                        } else if (!text.isEmpty()) {
                            field.setText(text);
                            text = text.substring(text.length());
                        }
                    }
                }
        );

        PrintScreen.printScreen();

    }

}
