package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pageObjects.*;
import resources.BaseTest;
import utilities.WaitTypes;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class NewSteps extends BaseTest {
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


    @Given("^User Navigates to Switch Preferences screen$")
    public void user_navigates_to_switch_preferences_screen() throws Throwable {
        //  driver = capabilities();
        initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

        prefpage = new PrefCodePage(driver);
        prefpage.getPreferenceFromCode().click();
    }

    @Given("^User navigates to select Preference dependencies button$")
    public void user_navigates_to_select_preference_dependencies_button() throws Throwable {

        initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

        dependencyPage = new PrefDependencyPage(driver);
        dependencyPage.getPreferenceDependencies().click();
    }


    @Given("^User Navigates to select Preferences From code button$")
    public void user_navigates_to_select_preferences_from_code_button() throws Throwable {

        initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

        prefpage = new PrefCodePage(driver);
        prefpage.getPreferenceFromCode().click();

    }


    @When("^User taps toggle button to On status$")
    public void user_taps_toggle_button_to_on_status() throws Throwable {


        togglePage = new TogglePage(driver);
        // toggle on
        togglePage.getSwitchToggle();

    }

    @When("^User selects the WiFi checkbox$")
    public void user_selects_the_wifi_checkbox() throws Throwable {



        wifiPage = new WifiPage(driver);
        wifiPage.getWifiCheckBox().click();

    }

    @When("^User select the child checkbox with a tick$")
    public void user_select_the_child_checkbox_with_a_tick() throws Throwable {

        chiobject = new ChildObjectPage(driver);
        chiobject.getChildCheckBox().click();

    }


    @Then("^Toggle button is activated$")
    public void toggle_button_is_activated() throws Throwable {

        Assert.assertTrue(togglePage.getSwitchToggleON().isDisplayed());

    }

    @Then("^WiFi connection is successfully added$")
    public void wifi_connection_is_successfully_added() throws Throwable {

        Assert.assertTrue(wifiPage.getWifiNameField().isDisplayed());
        wifiPage.getOkButton().click();

    }

    @Then("^Child checkbox is successfully marked as ticked$")
    public void child_checkbox_is_successfully_marked_as_ticked() throws Throwable {
        Assert.assertTrue(chiobject.getChildCheckBox().isEnabled());

    }

    @And("^User sets the WiFi name as \"([^\"]*)\"$")
    public void user_sets_the_wifi_name_as_something(String strArg1) throws Throwable {

        wifiPage.getWifiSettingButton();
        wifiPage.getWifiNameField().sendKeys(strArg1);
    }


}

