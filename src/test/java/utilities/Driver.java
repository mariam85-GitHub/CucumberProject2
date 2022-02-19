package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){
        //First step to achieve singleton
    }

    private static WebDriver driver;//Second step to achieve singleton

    public static WebDriver getDriver(){////Third step to achieve singleton
        if (driver == null){
            String browser = ConfigReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless":
                    driver = new HtmlUnitDriver();
                    break;
                default:
                    throw new NotFoundException("Driver is NOT set properly: " + ConfigReader.getProperty("browser"));
            }
            if (!browser.equals("headless")){
                driver.manage().window().maximize();
                int time = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
                driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}