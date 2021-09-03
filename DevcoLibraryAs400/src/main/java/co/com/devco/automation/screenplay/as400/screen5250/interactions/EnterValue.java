package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.PutString.putString;
import static co.com.devco.automation.screenplay.as400.screen5250.controllers.PutString.putStringByLabel;

public class EnterValue implements Interaction {

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
            putStringByLabel(text, target.getTag());
        } else {
            putString(this.text, this.coordinate.getRow(), this.getColumn());
        }

        TakeProofEvidence.InScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);
    }

    private int getColumn() {
        return target.getTag().isEmpty() ? this.coordinate.getInitialColumn() : this.coordinate.getFinalColumn();
    }
}
