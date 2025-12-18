package addToCartTest;

import baseTest.BaseTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.WomenCategoryPage;

public class AddToCartTest extends BaseTests {

    @Test
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        Assert.assertTrue(womenPage.getProductCount() > 0, "Women category should have products");

        womenPage.addFirstProductToCart();
        waitForElement();
        Assert.assertTrue(womenPage.isViewCartLinkVisible(), "View cart link should be visible after adding to cart");
    }

    @Test
    public void testCartIconUpdatesAfterAddingProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        String cartCountBefore = homePage.getCartCount();

        womenPage.addFirstProductToCart();
        waitForElement();

        String cartCountAfter = homePage.getCartCount();
        Assert.assertNotEquals(cartCountBefore, cartCountAfter, "Cart count should increase after adding product");
    }


    @Test
    public void testAddToCartButtonShowsCheckmark() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToWomen();

        WomenCategoryPage womenPage = new WomenCategoryPage(driver);
        womenPage.addFirstProductToCart();
        waitForElement();

        Assert.assertTrue(womenPage.isAddToCartButtonChanged(), "Add to cart button should show checkmark");
    }

    private void waitForElement() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}