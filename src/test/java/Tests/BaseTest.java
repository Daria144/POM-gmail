package Tests;

import Configuration.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
            (alwaysRun = true)
    public static void launch(){
        System.setProperty(ConfProperties.getProperty("chromeKey"),ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("loginPage"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }



    @AfterMethod
            (alwaysRun = true)
    public void turnDown(){
        driver.quit();
    }
}
