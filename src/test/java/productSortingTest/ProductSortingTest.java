package productSortingTest;

import baseTest.BaseTests;
import pages.HomePage;
import pages.ProductSortingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSortingTest extends BaseTests {

    @Test
    public void testSortProductsByAverageRatingUnderMenCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToMen();

        ProductSortingPage productSortingPage = new ProductSortingPage(driver);
        productSortingPage.sortByAverageRating();

        Assert.assertTrue(productSortingPage.isProductsDisplayed(),
                "Products should be displayed after sorting by average rating");
    }

    @Test
    public void testVerifySortedProductsCountUnderMenCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToMen();

        ProductSortingPage productSortingPage = new ProductSortingPage(driver);
        productSortingPage.sortByAverageRating();

        int sortedProductsCount = productSortingPage.getDisplayedProductsCount();
        Assert.assertTrue(sortedProductsCount > 0,
                "Sorted products count should be greater than 0");
    }
}