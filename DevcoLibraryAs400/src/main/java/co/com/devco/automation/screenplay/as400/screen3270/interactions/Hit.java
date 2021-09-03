package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.SendKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class Hit implements Interaction {

    private byte keyName;
    private String text = "";

    public Hit(byte key) {
        this.keyName = key;
    }

    public Hit(String test) {
        this.text = test;
    }


    @Override
    @Step("{0} Hit the key #keyName")
    public <T extends Actor> void performAs(T actor) {

        if (text.isEmpty()) {
            SendKey.sendKey(keyName, "ENTER");
        } else {
            SendKey.sendKeyWithoutWait(text);
        }

    }

    public static Hit the(byte key) {
        return new Hit(key);
    }

    public static Hit the(String text) {
        return new Hit(text);
    }


}

