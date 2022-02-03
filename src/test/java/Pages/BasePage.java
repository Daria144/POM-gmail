package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {
    @FindBy(name = "header")
    private WebElement header;

    public boolean isDisplayed(WebElement element){return element.isDisplayed();}
}
