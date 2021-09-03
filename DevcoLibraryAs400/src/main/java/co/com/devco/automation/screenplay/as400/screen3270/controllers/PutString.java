package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.getClientScreen3270;

public class PutString {

    public static void putString(String text, int row, int column) {
        getClientScreen3270().setFieldTextByCoord(row, column, text);
        PrintScreen.printScreen();
    }

    public static void putStringByLabel(String text, String label) {
        getClientScreen3270().setFieldTextByLabel(label, text);
        PrintScreen.printScreen();
    }

}
