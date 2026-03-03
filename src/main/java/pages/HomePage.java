package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.CrossBrowser;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage() {
        this.driver = CrossBrowser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By pageTitle = By.className("title");
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    private By cartBadge = By.className("shopping_cart_badge");

    public boolean isHomePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).isDisplayed();
    }

    public HomePage addProductToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addBackpack));
        driver.findElement(addBackpack).click();
        return this;
    }

    public CartPage goToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        driver.findElement(cartIcon).click();
        return new CartPage();
    }
}