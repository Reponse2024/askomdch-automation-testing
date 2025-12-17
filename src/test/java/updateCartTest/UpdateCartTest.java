package updateCartTest;

import BaseTest.BaseTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.WomenCategoryPage;
import pages.CartPage;

public class UpdateCartTest extends BaseTests {

    @Test
    public void testIncreaseProductQuantityInCart() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        womenPage.addFirstProductToCart();
        waitForElement();

        womenPage.clickViewCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertFalse(cartPage.isCartEmpty(), "Cart should not be empty after adding product");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should have at least one item");

        String quantityBefore = cartPage.getQuantityOfFirstItem();
        cartPage.increaseQuantityOfFirstItem();
        cartPage.clickUpdateCart();

        waitForElement();
        String quantityAfter = cartPage.getQuantityOfFirstItem();
        Assert.assertNotEquals(quantityBefore, quantityAfter, "Quantity should increase");
    }

    @Test
    public void testDecreaseProductQuantityInCart() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        womenPage.addFirstProductToCart();
        waitForElement();

        womenPage.clickViewCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertFalse(cartPage.isCartEmpty(), "Cart should not be empty after adding product");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should have at least one item");

        cartPage.increaseQuantityOfFirstItem();
        cartPage.clickUpdateCart();
        waitForElement();

        String quantityBefore = cartPage.getQuantityOfFirstItem();
        cartPage.decreaseQuantityOfFirstItem();
        cartPage.clickUpdateCart();

        waitForElement();
        String quantityAfter = cartPage.getQuantityOfFirstItem();
        Assert.assertNotEquals(quantityBefore, quantityAfter, "Quantity should decrease");
    }

    @Test
    public void testCartPageDisplaysCheckoutButton() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        womenPage.addFirstProductToCart();
        waitForElement();

        womenPage.clickViewCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertFalse(cartPage.isCartEmpty(), "Cart should not be empty");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should have items");
        Assert.assertTrue(cartPage.isCheckoutVisible(), "Checkout button should be visible on cart page");
    }

    private void waitForElement() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}