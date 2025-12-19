package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductSortingPage {
    WebDriver driver;
    WebDriverWait wait;

    By sortingDropdown_SelectElement = By.cssSelector("select.orderby");
    By sortByAverageRatingOption_OptionElement = By.cssSelector("option[value='rating']");
    By productItem_LiElement = By.cssSelector("li.product");

    public ProductSortingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectSortingOption(String sortingText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(sortingDropdown_SelectElement));
        Select sortingDropdown = new Select(driver.findElement(sortingDropdown_SelectElement));
        sortingDropdown.selectByVisibleText(sortingText);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productItem_LiElement));
    }

    public void sortByAverageRating() {
        selectSortingOption("Sort by average rating");
    }

    public boolean isProductsDisplayed() {
        return !driver.findElements(productItem_LiElement).isEmpty();
    }

    public int getDisplayedProductsCount() {
        return driver.findElements(productItem_LiElement).size();
    }
}