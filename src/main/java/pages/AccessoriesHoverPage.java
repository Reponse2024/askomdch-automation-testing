package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class AccessoriesHoverPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By productList = By.cssSelector("ul.products li.product");
    private By productImage = By.cssSelector(".woocommerce-LoopProduct-link img");

    public AccessoriesHoverPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public List<WebElement> getProducts() {
        try {
            Thread.sleep(1500);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int getProductCount() {
        return getProducts().size();
    }

    public void clickFirstProduct() {
        WebElement firstProduct = getProducts().getFirst();
        WebElement productLink = firstProduct.findElement(By.cssSelector("a.woocommerce-LoopProduct-link"));
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    public void hoverOverProductImage() {
        try {
            Thread.sleep(1000);
            WebElement productImg = driver.findElement(productImage);
            actions.moveToElement(productImg).perform();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private By zoomImage = By.cssSelector("img.zoomImg");

    public boolean isImageZoomed() {
        try {
            WebElement zoomImg = driver.findElement(zoomImage);
            String opacity = zoomImg.getCssValue("opacity");
            return !opacity.equals("0") && !opacity.equals("0.0");
        } catch (Exception e) {
            return false;
        }
    }
}