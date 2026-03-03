package pages;

import base.CrossBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    public ProductPage() {
        this.driver = CrossBrowser.getDriver();
    }

    private By addButton =
            By.cssSelector("[data-test='add-to-cart-sauce-labs-back-light']");

    private By removeButton =
            By.cssSelector("[data-test='remove-sauce-labs-back-light']");

    private By cartBadge =
            By.cssSelector(".shopping_cart_badge");

    private By cartIcon =
            By.cssSelector("[data-test='shopping-cart-link']");

    public ProductPage addProductToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until inventory page is fully loaded
        wait.until(ExpectedConditions.urlContains("inventory"));

        // Wait until either Add or Remove is visible
        wait.until(driver ->
                driver.findElements(addButton).size() > 0 ||
                driver.findElements(removeButton).size() > 0);

        // If Add button exists → click
        if (driver.findElements(addButton).size() > 0) {
            driver.findElement(addButton).click();
        }

        // Verify cart badge appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

        return this;
    }

    public CartPage goToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        driver.findElement(cartIcon).click();

        wait.until(ExpectedConditions.urlContains("cart"));

        return new CartPage();
    }
}