package co.com.devco.example.as400.stepdefinitions;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ActorConfiguration {

    @Before
    public void actorConfiguration(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Pepito");
    }

}
