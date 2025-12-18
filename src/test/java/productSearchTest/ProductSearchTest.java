package productSearchTest;


import baseTest.BaseTests;
import pages.HomePage;
import pages.ProductSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchTest extends BaseTests {

    @Test
    public void testSearchProductFromStorePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStoreNavigationTab();

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.searchForProduct("Blue Jeans");

        Assert.assertTrue(productSearchPage.isSearchResultsDisplayed(),
                "Search results should be displayed for 'Blue Jeans'");
    }

    @Test
    public void testVerifySearchResultsCount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStoreNavigationTab();

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.searchForProduct("Blue Jeans");

        int searchResultsCount = productSearchPage.getSearchResultsCount();
        Assert.assertTrue(searchResultsCount > 0,
                "Search results count should be greater than 0 for 'Blue Jeans'");
    }

    @Test
    public void testSearchForDifferentProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStoreNavigationTab();

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.searchForProduct("Shoes");

        Assert.assertTrue(productSearchPage.isSearchResultsDisplayed(),
                "Search results should be displayed for 'Shoes'");
    }
}
