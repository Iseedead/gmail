package Util;

//Singleton

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = DriverWrapper.driver.get();
        if (driver == null) {
            driver = switchDriver();
            DriverWrapper.driver.set(driver);
            DriverWrapper.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void nullDriver() {
        driver.get().quit();
        driver.set(null);
    }

    private static WebDriver switchDriver() {

        WebDriver driverlol = null;
        String browserName = System.getProperty("browser");
        File file;
        URI browserURI = null;
        try {
            browserURI = DriverWrapper.class.getResource("/" + browserName + "driver").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        file = new File(browserURI);
        String driverPath = file.getPath();
        file.setExecutable(true, false);
        switch (System.getProperty("browser")) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", driverPath);
                driverlol = new ChromeDriver();
                break;
            }
            case "gecko": {
                System.setProperty("webdriver.gecko.driver", driverPath);
                driverlol = new FirefoxDriver();
                break;
            }
        }
        return driverlol;
    }
}