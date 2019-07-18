package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

public class PrefDependencyPage extends BaseTest {

    public PrefDependencyPage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(uiAutomator = "text(\"3. Preference dependencies\")")
    public WebElement preferenceDependencies;



    public WebElement getPreferenceDependencies() {
        return preferenceDependencies;
    }
}
