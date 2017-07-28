package Util;

//Singleton

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>() ;

    public static WebDriver getDriver(){
        String driverPath = DriverWrapper.class.getResource("/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = DriverWrapper.driver.get();
        if (driver == null){
                driver = new ChromeDriver();
                DriverWrapper.driver.set(driver);
                DriverWrapper.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void nullDriver(){
        driver.get().quit();
        driver.set(null);
    }
}