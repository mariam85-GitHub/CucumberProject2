package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebOrdersViewAllOrdersPage {

    public WebOrdersViewAllOrdersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table[class='SampleTable'] tr")
    public List<WebElement> rowsOfTheTable;
//
//    @FindBy(css = "table[class='SampleTable'] td")
//    public List<WebElement> enteredInfoInTheTable;
}