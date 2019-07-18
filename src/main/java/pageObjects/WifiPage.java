package pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

public class WifiPage extends BaseTest {

    public WifiPage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="android:id/checkbox")
    public WebElement wifiCheckBox;

    @AndroidFindBy(uiAutomator = "text(\"WiFi settings\")")
    public WebElement wifiSettingButton;

    @AndroidFindBy(id = "android:id/edit")
        public WebElement wifiNameField;

    @AndroidFindBy(id="android:id/button1")
    public WebElement okButton;


    public WebElement getWifiCheckBox(){
        return wifiCheckBox;
    }

    public WebElement getWifiSettingButton(){

        TouchAction t  = new TouchAction(driver);
         t.tap(TapOptions.tapOptions().withElement(ElementOption.element(wifiSettingButton))).perform();
        return wifiSettingButton;
    }

    public WebElement getWifiNameField(){
        return wifiNameField;
    }

    public WebElement getOkButton() {
        return okButton;
    }
}
