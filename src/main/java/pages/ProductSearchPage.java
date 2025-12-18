package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductSearchPage {
    WebDriver driver;
    WebDriverWait wait;

    By searchInput_InputElement = By.id("woocommerce-product-search-field-0");
    By searchButton_ButtonElement = By.cssSelector("button[type='submit']");
    By productItem_LiElement = By.cssSelector("li.product");

    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchInput_InputElement));
        driver.findElement(searchInput_InputElement).sendKeys(productName);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton_ButtonElement));
        driver.findElement(searchButton_ButtonElement).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productItem_LiElement));
    }

    public void searchForProduct(String productName) {
        searchProduct(productName);
        clickSearchButton();
    }

    public boolean isSearchResultsDisplayed() {
        return !driver.findElements(productItem_LiElement).isEmpty();
    }

    public int getSearchResultsCount() {
        return driver.findElements(productItem_LiElement).size();
    }
}