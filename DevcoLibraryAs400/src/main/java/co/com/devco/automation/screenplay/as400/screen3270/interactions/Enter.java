package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.targets.Target;

public class Enter {

    private String text;

    public Enter(String text) {
        this.text = text;
    }

    public static Enter theValue(String text) {
        return new Enter(text);
    }

    public EnterValue into(Target target) {
        return new EnterValue(this.text, target);
    }

}

