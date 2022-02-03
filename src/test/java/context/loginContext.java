package context;

import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Tests.BaseTest.driver;

public class loginContext {
    public static LoginPage loginPage = new LoginPage(driver);
    public static void logIn(String login,String pwd){
        loginPage.inputLogin(login);
        loginPage.inputPassword(pwd);
    }
    public static boolean userLabelIsDisplayed(){
        return loginPage.waitForUserLabel().isDisplayed();
    }
    public static boolean assertLabelIsDisplayed(){
        return loginPage.waitForAsserLabel().isDisplayed();
    }
    public static void logOutAndLogInWithOtherAccount(){
        loginPage.logOut();
        loginPage.chooseOtherAccount();
    }

}
