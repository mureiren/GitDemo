package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
    WebDriver driver;

    public WaitTypes(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebElement(WebElement element, int timeout) throws Error {

        try {

            System.out.println("Waiting time will be: " + timeout + " seconds until element is located");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            System.out.println("Element was clicked on the page");

        } catch (Exception e) {
            System.out.println("Element wasn't clicked on the page");
        }
    }

    public void waitForWebElement(WebElement element, int timeout) throws Error {

        try {

            System.out.println("Waiting time will be: " + timeout + " seconds until element is located");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("Element was located on the page");

        } catch (Exception e) {
            System.out.println("Element wasn't located on the page");
        }
    }

    public void waitForListMobileElement(By elements, int timeout) throws Error {

        try {

            System.out.println("Waiting time: " + timeout + " seconds until element is located");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elements, 1));
            System.out.println("Element located on the page");

        } catch (Exception e) {
            System.out.println("Element was NOT located on the page");
        }
    }
}
