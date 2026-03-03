package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.CrossBrowser;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage() {
        this.driver = CrossBrowser.getDriver();
    }
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");
    public CheckoutPage enterDetails(String fname, String lname, String zip) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
        return this;
    }
    public CheckoutPage clickContinue() {
        driver.findElement(continueButton).click();
        return this;
    }
    public CheckoutPage clickFinish() {
        driver.findElement(finishButton).click();
        return this;
    }
    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}