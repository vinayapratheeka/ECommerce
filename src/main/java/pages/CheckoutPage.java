package pages;

import base.CrossBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage() {
        this.driver = CrossBrowser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage enterDetails(String firstName, String lastName, String zip) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(zip);

        return this;
    }

    public CheckoutPage clickContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();

        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));

        return this;
    }

    public CheckoutPage clickFinish() {

        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();

        wait.until(ExpectedConditions.urlContains("checkout-complete.html"));

        return this;
    }

    public String getConfirmationMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return driver.findElement(confirmationMessage).getText();
    }
}