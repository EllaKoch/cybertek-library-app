package com.cybertek.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {
                String browser = ConfigurationReader.getProperty("browser");


                switch (browser) {
                    case "remote-chrome":
                        try {
                            URL url = new URL("http://18.205.247.86:4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");//firefox
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "remote-firefox"://remote-firefox
                        try {
                            URL url = new URL("http://18.205.247.86:4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("firefox");//firefox
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().fullscreen();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        // WebDriverManager.firefoxdriver().setup();
                        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().fullscreen();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }

}
