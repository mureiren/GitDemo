package androidapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chromeTest {

    @Test
    public void startup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Beautystack\\src\\test\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
    }
}
