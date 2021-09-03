package co.com.devco.automation.screenplay.as400.utils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class TakeProofEvidence {

    public static void InScreen5052InTheCase(CaseScreenshot takeScreenshot) {

        if (takeScreenshotFlag(takeScreenshot)) {
            Serenity.recordReportData().withTitle("▼").andContents(co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.getClientScreen5250().getScreenText());
        }

    }

    public static void InScreen3270InTheCase(CaseScreenshot takeScreenshot) {

        if (takeScreenshotFlag(takeScreenshot)) {
            Serenity.recordReportData().withTitle("▼").andContents(co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.getClientScreen3270().getScreenText());
        }

    }

    private static boolean takeScreenshotFlag(CaseScreenshot takeScreenshot) {

        if (CaseScreenshot.FOR_EACH_ACTION.name().equals(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("serenity.take.screenshots"))) {
            return true;
        } else if (CaseScreenshot.FOR_EACH_VALIDATION.name().equals(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("serenity.take.screenshots")) && takeScreenshot.name().equals(CaseScreenshot.FOR_EACH_VALIDATION.name())) {
            return true;
        } else {
            return CaseScreenshot.TAKE_SCREENSHOT.name().equals(takeScreenshot.name());
        }
    }

}
