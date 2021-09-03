package co.com.devco.automation.screenplay.as400.screen5250.controllers;

public class GetString {

    public static String getString(int row, int column, int lengtText) {

        String text;
        row = row - 1;
        column = column - 1;

        if (row > 0) {
            text = OpenSession.getClientScreen5250().getScreenText().substring(((81 * row) + column), ((81 * row) + column) + lengtText);
        } else {
            text = OpenSession.getClientScreen5250().getScreenText().substring(column, column + lengtText);
        }

        return text;

    }

}
