package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebOrdersAllOrdersListPage {

    public WebOrdersAllOrdersListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li>a")
    public List<WebElement> menuItemsList;

    @FindBy(css = "a[id*='btnCheckAll']")
    public WebElement checkedAllLink;

    @FindBy(css = "a[id*='btnUncheckAll']")
    public WebElement UncheckedAllLink;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkBoxesInput;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(id = "ctl00_MainContent_orderGrid")
    public WebElement table;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement message;
}