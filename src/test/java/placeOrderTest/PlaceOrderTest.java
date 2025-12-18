package placeOrderTest;

import baseTest.BaseTests;
import pages.HomePage;
import pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTests {

    @Test
    public void testPlaceOrderWithBillingDetails() {
        HomePage homePage = new HomePage(driver);
        homePage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder(
                "John",
                "Doe",
                "United States (US)",
                "123 Main Street",
                "Los Angeles",
                "California",
                "90001",
                "john.doe@example.com"
        );

        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation message should be displayed after placing order");
    }
}