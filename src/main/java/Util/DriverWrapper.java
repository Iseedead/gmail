package Util;

//Singleton

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {
        private static WebDriver driver;

        private static void initDriver() {
            String driverPath = DriverWrapper.class.getResource("/chromedriver").getPath();
            System.setProperty("webdriver.chrome.driver", driverPath);

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        public static synchronized WebDriver getDriver() {
            if (driver == null) {
                initDriver();
            }
            return driver;
        }
}
