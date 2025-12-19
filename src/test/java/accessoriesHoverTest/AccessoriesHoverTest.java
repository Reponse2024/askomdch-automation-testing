package accessoriesHoverTest;

import baseTest.BaseTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.AccessoriesHoverPage;

public class AccessoriesHoverTest extends BaseTests {

    @Test
    public void testAccessoriesCategoryDisplaysProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccessories();

        AccessoriesHoverPage accessoriesPage = new AccessoriesHoverPage(driver);
        Assert.assertTrue(accessoriesPage.getProductCount() > 0, "Accessories category should have products");
    }

    @Test
    public void testClickProductOpensDetails() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccessories();

        AccessoriesHoverPage accessoriesPage = new AccessoriesHoverPage(driver);
        String initialUrl = driver.getCurrentUrl();

        accessoriesPage.clickFirstProduct();
        waitForElement();

        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(initialUrl, newUrl, "Product details page should open");
    }

    @Test
    public void testHoverOverProductImageZooms() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccessories();

        AccessoriesHoverPage accessoriesPage = new AccessoriesHoverPage(driver);
        accessoriesPage.clickFirstProduct();
        waitForElement();

        accessoriesPage.hoverOverProductImage();
        Assert.assertTrue(accessoriesPage.isImageZoomed(), "Product image should be zoomed on hover");
    }

    private void waitForElement() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}