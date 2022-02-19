package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.WebOrdersAllOrdersListPage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersProductInformationPage;
import pages.WebOrdersViewAllOrdersPage;
import texts.ExpectedTextUserInformation;
import utilities.Driver;

import java.util.List;

public class WebOrdersSteps {

    public WebDriver driver;
    public WebOrdersLoginPage webOrdersLoginPage;
    public WebOrdersAllOrdersListPage webOrdersAllOrdersListPage;
    public WebOrdersProductInformationPage webOrdersProductInformationPage;
    public Select select;
    public WebOrdersViewAllOrdersPage webOrdersViewAllOrdersPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        webOrdersLoginPage = new WebOrdersLoginPage(driver);
        webOrdersAllOrdersListPage = new WebOrdersAllOrdersListPage(driver);
        webOrdersProductInformationPage = new WebOrdersProductInformationPage(driver);
        webOrdersViewAllOrdersPage = new WebOrdersViewAllOrdersPage(driver);
    }

    @Given("user is on{string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        webOrdersLoginPage.usernameInputBox.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        webOrdersLoginPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String textButton) {
        WebElement element;
        switch (textButton) {
            case "Login":
                element = webOrdersLoginPage.loginButton;
                break;
            case "Check All":
                element = webOrdersAllOrdersListPage.checkedAllLink;
                break;
            case "Uncheck All":
                element = webOrdersAllOrdersListPage.UncheckedAllLink;
                break;
            case "Process":
                element = webOrdersProductInformationPage.processButton;
                break;
            case "Delete Selected":
                element = webOrdersAllOrdersListPage.deleteSelectedButton;
                break;
            default:
                throw new NotFoundException("Button not Found");
        }
        element.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, webOrdersLoginPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        List<String> menuItemsListText = dataTable.asList();

        for (int i = 0; i < webOrdersAllOrdersListPage.menuItemsList.size(); i++) {
            Assert.assertTrue(webOrdersAllOrdersListPage.menuItemsList.get(i).isDisplayed());
            Assert.assertEquals(menuItemsListText.get(i), webOrdersAllOrdersListPage.menuItemsList.get(i).getText());
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < webOrdersAllOrdersListPage.checkBoxesInput.size(); i++) {
            Assert.assertTrue(webOrdersAllOrdersListPage.checkBoxesInput.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < webOrdersAllOrdersListPage.checkBoxesInput.size(); i++) {
            Assert.assertFalse(webOrdersAllOrdersListPage.checkBoxesInput.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        WebElement element;
        switch (menuItem) {
            case "View all orders":
                element = webOrdersAllOrdersListPage.menuItemsList.get(0);
                break;
            case "View all products":
                element = webOrdersAllOrdersListPage.menuItemsList.get(1);
                break;
            case "Order":
                element = webOrdersAllOrdersListPage.menuItemsList.get(2);
                break;
            default:
                throw new NotFoundException("Menu item NOT found!!");
        }
        element.click();
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String productOptions) {
        select = new Select(webOrdersProductInformationPage.productDropdown);
        select.selectByVisibleText(productOptions);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int num) {
        webOrdersProductInformationPage.quantityInputBox.clear();
        webOrdersProductInformationPage.quantityInputBox.sendKeys(num + "");
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation(DataTable dataTable) {
        List<String> menuItemsListText = dataTable.asList();
        webOrdersProductInformationPage.customerNameInputBox.sendKeys(menuItemsListText.get(0));
        webOrdersProductInformationPage.streetInputBox.sendKeys(menuItemsListText.get(1));
        webOrdersProductInformationPage.cityInputBox.sendKeys(menuItemsListText.get(2));
        webOrdersProductInformationPage.stateInputBox.sendKeys(menuItemsListText.get(3));
        webOrdersProductInformationPage.zipInputBox.sendKeys(menuItemsListText.get(4));
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation(DataTable dataTable) {
        webOrdersProductInformationPage.visaRadioButton.click();
        List<String> paymentInformationListText = dataTable.asList();
        webOrdersProductInformationPage.cardNumberInputBox.sendKeys(paymentInformationListText.get(0));
        webOrdersProductInformationPage.expireDateInputBox.sendKeys(paymentInformationListText.get(1));
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String arg0) {
        Assert.assertTrue(webOrdersViewAllOrdersPage.rowsOfTheTable.get(1).isDisplayed());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        List<String> userInfo = dataTable.asList();
        for (int i = 0; i < userInfo.size(); i++) {
            Assert.assertEquals(userInfo.get(i), ExpectedTextUserInformation.userInfo().get(i));
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String arg0) {
        try {
            Assert.assertFalse(webOrdersAllOrdersListPage.table.isDisplayed());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, webOrdersAllOrdersListPage.message.getText());
    }
}