package pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

public class TogglePage extends BaseTest  {

    public TogglePage(AndroidDriver<AndroidElement> driver){
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "android:id/switch_widget")
    public WebElement switchToggle;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='ON']")
    public WebElement switchToggleON;


    public TouchAction getSwitchToggle() throws InterruptedException {

        Point point = driver.findElementById("android:id/switch_widget").getLocation();
        TouchAction t = new TouchAction(driver);
        // toggle on
      TouchAction switchToggle =  t.tap(PointOption.point(point.x+20, point.y+30)).perform();
        Thread.sleep(3000);

      return  switchToggle;
    }

    public WebElement getSwitchToggleON(){

        return switchToggleON;
    }
}
