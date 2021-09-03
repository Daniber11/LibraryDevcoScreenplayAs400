package co.com.devco.example.as400.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login_in_pub400.feature",
        glue = "co.com.devco.example.as400.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class LoginInPub400 {}
