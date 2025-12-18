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
                "Reponse",
                "Iduha",
                "Rwanda",
                "123 Main Street",
                "Kigali",
                "Gasabo",
                "90001",
                "reponseiduha777@gmail.com"
        );

        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation message should be displayed after placing order");
    }
}