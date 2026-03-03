package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.CrossBrowser;

public class LoginPage {
    WebDriver driver;
    public LoginPage() {
        this.driver = CrossBrowser.getDriver();
    }
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    public LoginPage enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
        return this;
    }
    public LoginPage enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
        return this;
    }
    public HomePage clickLogin() {
        driver.findElement(loginButton).click();
        return new HomePage();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}