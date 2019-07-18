package resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.openqa.selenium.logging.LoggingHandler;
import pageobjects.InitialPreferencePage;

public abstract class BaseTest {

    protected AppiumDriver driver;




    @BeforeTest
    public AppiumDriver<AndroidElement> capabilities() throws MalformedURLException {

        File f = new File("src\\test\\java\\resources");
        File fs = new File(f, "SampleAppium.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "nelson");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator1");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }


    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
