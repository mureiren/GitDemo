package testframework;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PrefCodePage;
import pageObjects.TogglePage;
import resources.BaseTest;

import java.io.IOException;

public class ATurnToggleSwitchOnTest extends BaseTest {





    @Test
    public void clickPrefCodeButton() throws InterruptedException {

        PrefCodePage prefpage = new PrefCodePage(driver);
        wait.waitForWebElement(prefpage.getPreferenceFromCode(),10);
       Thread.sleep(1000);
        prefpage.getPreferenceFromCode().click();

    }

    @Test
    public void toggleSwitchButton() throws InterruptedException {

        TogglePage togglePage = new TogglePage(driver);
        // toggle on
        togglePage.getSwitchToggle();

        Assert.assertTrue(togglePage.getSwitchToggleON().isDisplayed());

    }


}



