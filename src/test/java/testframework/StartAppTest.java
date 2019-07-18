package testframework;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class StartAppTest {

    @BeforeSuite
    public void browse() throws InterruptedException, IOException {

        Runtime.getRuntime().exec("cmd /c start C:\\startappium.bat");
        Thread.sleep(10000);

    }

}
