package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;
import co.com.devco.automation.screenplay.as400.screen5250.utils.KeysScreen5250;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.SendKey.sendKey;
import static co.com.devco.automation.screenplay.as400.screen5250.controllers.SendKey.sendKeyWithoutWait;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Hit implements Interaction {

    private int key;
    private String keyName;
    private String text = "";

    public Hit(KeysScreen5250 key) {
        this.key = key.getNameKey();
        this.keyName = key.toString();
    }

    public Hit(String test) {
        this.text = test;
        this.keyName = test;
    }

    @Override
    @Step("{0} Hit the key #keyName")
    public <T extends Actor> void performAs(T actor) {

        if (text.isEmpty()) {
            sendKey(key);
        } else {
            sendKeyWithoutWait(text);
        }

        TakeProofEvidence.InScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    public static Hit the(KeysScreen5250 key) {
        return instrumented(Hit.class,key);
    }

    public static Hit the(String text) {
        return instrumented(Hit.class,text);
    }


}

