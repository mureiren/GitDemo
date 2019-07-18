package testframework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.InitialPreferencePage;
import pageobjects.PrefCodePage;
import pageobjects.TogglePage;
import resources.BaseTest;

import java.net.MalformedURLException;

public class VerifySwitchPreferenceTest extends  BaseTest {



    @Test
    public void AccessPreferenceButton(){

        InitialPreferencePage initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

    }

    @Test
    public void clickingPrefCode(){
        PrefCodePage prefpage = new PrefCodePage(driver);

        prefpage.preferenceFromCode.click();
    }


    @Test
    public void toggleSwitchButton() throws InterruptedException {

        TogglePage togglePage = new TogglePage(driver);
        // toggle on
        togglePage.getSwitchToggle();

    }



}



