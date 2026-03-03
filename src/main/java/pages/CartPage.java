package pages;

import base.CrossBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage() {
        this.driver = CrossBrowser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By checkoutButton = By.id("checkout");
    private By cartTitle = By.className("title");

    public CheckoutPage clickCheckout() {

        // Ensure we are on Cart page
        wait.until(ExpectedConditions.urlContains("cart.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));

        // Click Checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();

        // Ensure navigation happened
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));

        return new CheckoutPage();
    }
}