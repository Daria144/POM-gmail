package Tests;

import Configuration.ConfProperties;
import context.loginContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest{


    @Test
            (groups = "LoginHPTest", priority = 1)
    public void logInWithValidCred(){
        loginContext.logIn(ConfProperties.getProperty("login"),ConfProperties.getProperty("password"));
        Assert.assertTrue(loginContext.userLabelIsDisplayed(),"Successful login Gmail");
        loginContext.logOutAndLogInWithOtherAccount();

    }

    @Test
            (groups = "LoginNPTest",priority = 3)
    public void logInWithInvalidPwd() {
        loginContext.logIn(ConfProperties.getProperty("login"), "blabla");
        Assert.assertTrue(loginContext.assertLabelIsDisplayed(), "Unsuccessful login entering incorrect password");

    }
}
