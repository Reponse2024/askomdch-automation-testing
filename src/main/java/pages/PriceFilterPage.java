package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class PriceFilterPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By priceSlider_DivElement = By.cssSelector("div.price_slider");
    By minPriceSliderHandle_SpanElement = By.cssSelector("div.price_slider span.ui-slider-handle:nth-of-type(1)");
    By maxPriceSliderHandle_SpanElement = By.cssSelector("div.price_slider span.ui-slider-handle:nth-of-type(2)");
    By filterButton_ButtonElement = By.cssSelector("button.button[type='submit']");
    By productItem_LiElement = By.cssSelector("li.product");

    public PriceFilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void dragMinPriceSlider(int pixels) {
        wait.until(ExpectedConditions.presenceOfElementLocated(minPriceSliderHandle_SpanElement));
        WebElement minHandle = driver.findElement(minPriceSliderHandle_SpanElement);
        actions.dragAndDropBy(minHandle, pixels, 0).perform();
    }

    public void dragMaxPriceSlider(int pixels) {
        wait.until(ExpectedConditions.presenceOfElementLocated(maxPriceSliderHandle_SpanElement));
        WebElement maxHandle = driver.findElement(maxPriceSliderHandle_SpanElement);
        actions.dragAndDropBy(maxHandle, pixels, 0).perform();
    }

    public void clickFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(filterButton_ButtonElement));
        driver.findElement(filterButton_ButtonElement).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productItem_LiElement));
    }

    public void filterByPriceRangeWithSlider(int minPixels, int maxPixels) {
        dragMinPriceSlider(minPixels);
        dragMaxPriceSlider(maxPixels);
        clickFilterButton();
    }

    public boolean isProductsDisplayed() {
        return !driver.findElements(productItem_LiElement).isEmpty();
    }

    public int getFilteredProductsCount() {
        return driver.findElements(productItem_LiElement).size();
    }
}