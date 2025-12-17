package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DropdownPage {
    WebDriver driver;
    WebDriverWait wait;

    By browseByCategories_SelectElement = By.id("product_cat");
    By productItem_LiElement = By.cssSelector("li.product");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectCategoryFromDropdown(String categoryVisibleText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(browseByCategories_SelectElement));
        Select browseByCategories = new Select(driver.findElement(browseByCategories_SelectElement));
        browseByCategories.selectByVisibleText(categoryVisibleText);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productItem_LiElement));
    }

    public void selectMensJeansCategory() {
        selectCategoryFromDropdown("Men’s Jeans  (4)");
    }

    public boolean isProductsListDisplayed() {
        return !driver.findElements(productItem_LiElement).isEmpty();
    }

    public int getDisplayedProductsCount() {
        return driver.findElements(productItem_LiElement).size();
    }
}