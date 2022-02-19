package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersLoginPage {

    public WebOrdersLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name*='username']")
    public WebElement usernameInputBox;

    @FindBy(css = "input[name*='password']")
    public WebElement passwordInputBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(css = "span[class='error']")
    public WebElement errorMessage;
}