package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

public class PrefCodePage extends BaseTest {


    public PrefCodePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    @AndroidFindBy(uiAutomator = "text(\"5. Preferences from code\")")
    public WebElement preferenceFromCode;


    public WebElement getPreferenceFromCode(){

        return preferenceFromCode;
    }


}
