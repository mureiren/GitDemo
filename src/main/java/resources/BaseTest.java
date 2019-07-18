package resources;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.*;


import utilities.WaitTypes;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.net.PortUnreachableException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected AndroidDriver<AndroidElement> driver;
    protected InitialPreferencePage initpage;
    protected PrefCodePage prefpage;
    protected TogglePage togglePage;
    protected PrefDependencyPage dependencyPage;
    protected WifiPage wifiPage;
    protected AppiumDriverLocalService service;
    protected WaitTypes wait;
    protected ChildObjectPage chiobject;




    @BeforeSuite
    public AppiumDriverLocalService startAppiumServer() throws InterruptedException, IOException {

        boolean flag = checkIfServerIsRunnning(4723);
        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }



    @Parameters("{SampleApp}")
    @BeforeClass
    public void setupAMethod(@Optional("SampleApp")String AppName) throws IOException, InterruptedException {

        driver = capabilities(AppName);
        initpage = new InitialPreferencePage(driver);
        prefpage = new PrefCodePage(driver);
        togglePage = new TogglePage(driver);
        dependencyPage = new PrefDependencyPage(driver);
        wifiPage = new WifiPage(driver);
        wait = new WaitTypes(driver);
        chiobject = new ChildObjectPage(driver);

    }


    @Parameters("{SampleApp}")
    @BeforeClass
    public void setupClickPrefCode( @Optional("SampleApp") String AppName) throws IOException, InterruptedException {
        driver =capabilities(AppName);
        InitialPreferencePage initpage = new InitialPreferencePage(driver);
        initpage.getPreference().click();

    }


    @BeforeSuite
    public void killAllNodes() throws IOException {

        Runtime.getRuntime().exec("taskkill /F /IM Appium.exe");

    }


    public static void  startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/java/resources/startEmulator.bat");
        Thread.sleep(10000);

    }





    public static AndroidDriver<AndroidElement> capabilities(String AppName) throws IOException, InterruptedException {


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/utilities/global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        File f = new File("src");
        File fs = new File(f, (String) prop.get(AppName));

        DesiredCapabilities cap = new DesiredCapabilities();
        String dv = (String) prop.get("device");
        if(dv.contains("nel")){
            startEmulator();
        }
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, dv);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator1");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @AfterSuite
    public void closeAppiumServer() {
//        driver.quit();
        service.stop();
    }

}