package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    WebDriver driver;
    WebDriverWait driverWait;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(id = "identifierId")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@id=\"password\"]//input")
    private WebElement passwordInput;
    @FindBy(xpath = "(//header//a[@role=\"button\"])[4]")
    private WebElement signOutLabel;
    @FindBy(id="gb_71")
    private WebElement logOutbutton;
    @FindBy(xpath = "//section//li[2]")
    private WebElement logInWithOtherAccount;




    public void inputLogin(String login){
        loginInput.sendKeys(login);
        loginInput.sendKeys(Keys.ENTER);
    }

    public void inputPassword(String pwd){
        passwordInput.sendKeys(pwd);
        passwordInput.sendKeys(Keys.ENTER);
    }
    public WebElement waitForUserLabel(){
        driverWait=new WebDriverWait(driver,20);
        WebElement userLabel = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By
        .xpath("//a[@class=\"gb_A gb_Ka gb_f\"]")));
        return userLabel;
    }
    public WebElement waitForAsserLabel(){
        driverWait=new WebDriverWait(driver,20);
        WebElement assertLabel = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@aria-live=\"assertive\"]/div[@jsname=\"B34EJ\"]")));
        return assertLabel;
    }
    public void logOut(){
        signOutLabel.click();
        logOutbutton.click();
    }
    public void chooseOtherAccount(){
        logInWithOtherAccount.click();
    }






}
