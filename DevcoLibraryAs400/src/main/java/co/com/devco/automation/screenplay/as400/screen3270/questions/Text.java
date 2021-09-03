package co.com.devco.automation.screenplay.as400.screen3270.questions;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.GetString;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;

public class Text {

    public Text() {
    }

    public static String of(Target target) {
        Coordinate coordinate = target.getCoordinate();
        return GetString.getString(coordinate.getRow(), coordinate.getInitialColumn(), coordinate.getLength()).trim();
    }

}
