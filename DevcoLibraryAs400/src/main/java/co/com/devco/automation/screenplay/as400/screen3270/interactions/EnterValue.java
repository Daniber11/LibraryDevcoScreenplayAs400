package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.PutString;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

public class EnterValue implements Performable {

    private final Coordinate coordinate;
    private final String name;
    private String text;
    private Target target;

    public EnterValue(String text, Target target) {
        this.text = text;
        this.target = target;
        this.name = this.target.getName();
        this.coordinate = this.target.getCoordinate();
    }

    @Override
    @Step("{0} enter the value #text into field #name with #coordinate")
    public <T extends Actor> void performAs(T actor) {

        if (coordinate == null) {
            PutString.putStringByLabel(text, target.getTag());
        } else {
            PutString.putString(this.text, this.coordinate.getRow(), this.getColumn());
        }

    }

    private int getColumn() {
        return target.getTag().isEmpty() ? this.coordinate.getInitialColumn() : this.coordinate.getFinalColumn();
    }
}
