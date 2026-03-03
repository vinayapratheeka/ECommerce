package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.ExcelUtil;
import utils.RetryAnalyser;

public class OrderTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(OrderTest.class);

    @DataProvider(name = "orderData")
    public Object[][] getOrderData() throws IOException {
        return ExcelUtil.getTestData("Sheet1");
    }

    @Test(dataProvider = "orderData")
    public void completeOrderFlowTest(String username,
                                      String password,
                                      String firstName,
                                      String lastName,
                                      String zip) throws InterruptedException {

        logger.info("STARTING ORDER FLOW TEST");

        // Step 1: Login
        logger.info("Launching Login Page");

        LoginPage loginPage = new LoginPage();

        logger.info("Entering username and password");

        HomePage homePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        Thread.sleep(1500);
        logger.info("Validating Home Page after login");

        Assert.assertTrue(homePage.isHomePageDisplayed(),
                "Login failed - Home page not displayed");

        // Step 2: Add product to cart
        logger.info("Adding product to cart");
        homePage.addProductToCart();
        Thread.sleep(1500);
        // Step 3: Navigate to cart
        logger.info("Navigating to Cart Page");
        CartPage cartPage = homePage.goToCart();
        Thread.sleep(1500);
        // Step 4: Checkout
        logger.info("Clicking Checkout button");
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        Thread.sleep(1500);
        // Step 5: Enter checkout details
        logger.info("Entering checkout details");
        checkoutPage
                .enterDetails(firstName, lastName, zip)
                .clickContinue()
                .clickFinish();
        Thread.sleep(1500);
        // Step 6: Validate confirmation
        logger.info("Validating order confirmation message");

        String confirmationMessage = checkoutPage.getConfirmationMessage();

        Assert.assertEquals(confirmationMessage,
                "Thank you for your order!",
                "Order confirmation message mismatch");

        logger.info("========= ORDER FLOW TEST COMPLETED SUCCESSFULLY =========");
    }
}