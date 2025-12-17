package dropdownPageTest;

import BaseTest.BaseTests;
import pages.HomePage;
import pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreDropdownPageTest extends BaseTests {

    @Test
    public void testSelectMensJeansCategoryFromBrowseByCategoriesDropdown() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStoreNavigationTab();

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMensJeansCategory();

        Assert.assertTrue(dropdownPage.isProductsListDisplayed(),
                "Products list should be displayed after selecting Men's Jeans category");
    }

    @Test
    public void testMensJeansCategoryDisplaysFourProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStoreNavigationTab();

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMensJeansCategory();

        Assert.assertEquals(dropdownPage.getDisplayedProductsCount(), 4,
                "Should display exactly 4 Men's Jeans products");
    }
}