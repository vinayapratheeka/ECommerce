package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.CrossBrowser;

public class HomePage {
    WebDriver driver;
    public HomePage() {
        this.driver = CrossBrowser.getDriver();
    }
    private By pageTitle = By.className("title");
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    public boolean isHomePageDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }
    public HomePage addProductToCart() {
        driver.findElement(addBackpack).click();
        return this;
    }
    public CartPage goToCart() {
        driver.findElement(cartIcon).click();
        return new CartPage();
    }
}