package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.getClientScreen5250;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.printScreen;

public class PutString {

    public static void putString(String text, int row, int column) {
        getClientScreen5250().setFieldTextByCoord(row, column, text);
        printScreen();
    }

    public static void putStringByLabel(String text, String label) {
        getClientScreen5250().setFieldTextByLabel(label, text);
        printScreen();
    }

}
