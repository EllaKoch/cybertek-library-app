package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        BrowserUtils.sleep(1);

    }



    @After
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){

            //  System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
            //if my scenario failed , go and take a screenshot

            if(scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

        }


        Driver.closeDriver();
    }

}
