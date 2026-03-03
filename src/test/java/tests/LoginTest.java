package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import utils.RetryAnalyser;

public class LoginTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyser.class)
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.enterUsername("standard_user").enterPassword("secret_sauce")
                .clickLogin();
        Assert.assertTrue(homePage.isHomePageDisplayed(),"Home page is not displayed after login");
    }
    @Test(retryAnalyzer = RetryAnalyser.class)
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("wrong_user").enterPassword("wrong_password").clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"),"Error message not displayed for invalid login");
    }
}