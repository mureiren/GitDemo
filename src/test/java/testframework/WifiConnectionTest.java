package testframework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PrefDependencyPage;
import pageObjects.WifiPage;
import resources.BaseTest;

import java.io.IOException;

public class WifiConnectionTest extends BaseTest {




    @Test
    public void clickOnPrefDependency() throws InterruptedException {
        PrefDependencyPage dependencyPage = new PrefDependencyPage(driver);
        wait.waitForWebElement(dependencyPage.getPreferenceDependencies(), 10);
        Thread.sleep(1000);
        dependencyPage.getPreferenceDependencies().click();
    }


    @Parameters("{param-class}")
    @Test
    public void settingWifi(@Optional("param-class") String param) throws InterruptedException {

        WifiPage wifiPage = new WifiPage(driver);
        wifiPage.getWifiCheckBox().click();
        wait.waitForWebElement(wifiPage.getWifiSettingButton(), 10);
        wifiPage.getWifiSettingButton().click();
        wait.waitForWebElement(wifiPage.getWifiNameField(), 10);
        wifiPage.getWifiNameField().clear();
        wifiPage.getWifiNameField().sendKeys(param);
        Assert.assertTrue(wifiPage.getWifiNameField().isDisplayed());
        wifiPage.getOkButton().click();

    }

    //  @DataProvider
    //  public static   Object[][]getData(){

    //  return  new Object[][]{
    //           {new UserInfo("Test")}
//        };


    //}


}
