package priceFilterTest;

import baseTest.BaseTests;
import pages.HomePage;
import pages.PriceFilterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceFilterTest extends BaseTests {

    @Test
    public void testFilterProductsByPriceRangeUnderMenCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccessories();

        PriceFilterPage priceFilterPage = new PriceFilterPage(driver);
        priceFilterPage.filterByPriceRangeWithSlider(50, 100);

        Assert.assertTrue(priceFilterPage.isProductsDisplayed(),
                "Products should be displayed after applying price filter");
    }

    @Test
    public void testVerifyFilteredProductsCount() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccessories();

        PriceFilterPage priceFilterPage = new PriceFilterPage(driver);
        priceFilterPage.filterByPriceRangeWithSlider(50, 100);

        int filteredCount = priceFilterPage.getFilteredProductsCount();
        Assert.assertTrue(filteredCount > 0,
                "Filtered products count should be greater than 0");
    }
}