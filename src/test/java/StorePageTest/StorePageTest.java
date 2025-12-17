package StorePageTest;

import BaseTest.BaseTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.StorePage;

public class StorePageTest extends BaseTests {

    @Test
    public void testClickStoreTabDisplaysProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToStoreTab();

        StorePage storePage = new StorePage(driver);
        Assert.assertTrue(storePage.areProductsDisplayed(), "Products should be displayed after clicking Store tab");
    }
    @Test
    public void testProductCountIsGreaterThanZero() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToStoreTab();

        StorePage storePage = new StorePage(driver);
        int productCount = storePage.getProductCount();
        Assert.assertTrue(productCount > 0, "Product count should be greater than zero");
    }
}