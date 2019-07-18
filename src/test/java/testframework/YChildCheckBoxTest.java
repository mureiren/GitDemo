package testframework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChildObjectPage;
import pageObjects.PrefCodePage;
import resources.BaseTest;

import java.io.IOException;

public class YChildCheckBoxTest extends BaseTest {



    @Test
    public void clickOnPreferencCode() throws InterruptedException {
        PrefCodePage prefpage = new PrefCodePage(driver);
        wait.waitForWebElement(prefpage.getPreferenceFromCode(),10);
        Thread.sleep(1000);
        prefpage.getPreferenceFromCode().click();
    }

    @Test
    public void dclickChildCheckBox() throws InterruptedException {
        ChildObjectPage chiobject = new ChildObjectPage(driver);
        wait.waitForWebElement(chiobject.getChildCheckBox(),10);
        Thread.sleep(1000);
        chiobject.getChildCheckBox().click();
        Assert.assertTrue(chiobject.getChildCheckBox().isEnabled());
    }
}
