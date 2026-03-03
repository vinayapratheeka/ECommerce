package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import base.CrossBrowser;

public class CartPage {

    WebDriver driver;

    public CartPage() {
        this.driver = CrossBrowser.getDriver();
    }

    private By checkoutButton = By.id("checkout");

    public CheckoutPage clickCheckout() {

        WebDriverWait wait = 
            new WebDriverWait(driver, Duration.ofSeconds(15));

        // Make sure we are on cart page
        wait.until(ExpectedConditions.urlContains("cart"));

        // Wait until checkout button visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));

        driver.findElement(checkoutButton).click();

        return new CheckoutPage();
    }
}