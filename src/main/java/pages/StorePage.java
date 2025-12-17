package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class StorePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By storeTab = By.linkText("Store");
    private By productItems = By.className("ast-woo-product-category");

    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickStoreTab() {
        wait.until(ExpectedConditions.elementToBeClickable(storeTab)).click();
    }

    public List<WebElement> getProducts() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productItems));
    }

    public int getProductCount() {
        return getProducts().size();
    }

    public boolean areProductsDisplayed() {
        return getProductCount() > 0;
    }
}