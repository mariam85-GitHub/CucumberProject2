package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersProductInformationPage {

    public WebOrdersProductInformationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[name*='Product']")
    public WebElement productDropdown;

    @FindBy(css = "input[name*='Quantity']")
    public WebElement quantityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy(css = "input[id*='TextBox2']")
    public WebElement streetInputBox;

    @FindBy(css = "input[id*='TextBox3']")
    public WebElement cityInputBox;

    @FindBy(css = "input[id*='TextBox4']")
    public WebElement stateInputBox;

    @FindBy(css = "input[id*='TextBox5']")
    public WebElement zipInputBox;

    @FindBy(css = "input[value*='Visa']")
    public WebElement visaRadioButton;

    @FindBy(css = "input[id*='TextBox6']")
    public WebElement cardNumberInputBox;

    @FindBy(css = "input[id*='TextBox1']")
    public WebElement expireDateInputBox;

    @FindBy(className = "btn_light")
    public WebElement processButton;
}
