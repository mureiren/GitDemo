package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeClass;
import pageObjects.*;
import resources.BaseTest;
import utilities.WaitTypes;

import java.net.MalformedURLException;

public class Hooks extends BaseTest {
 AndroidDriver<AndroidElement> driver;

    {
        try {
            try {
                driver = capabilities("SampleApp");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }
/*
    @Before("@Second")
    public void beforeYouClickPrefCode() {
        initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

    }

    @Before("@Third")
    public void afterYouClickPrefCode() {
        initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

    }

*/

}
