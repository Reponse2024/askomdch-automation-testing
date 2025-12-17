package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class WomenCategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productList = By.cssSelector("ul.products li.product");
    private By addToCartBtn = By.cssSelector(".add_to_cart_button.ajax_add_to_cart");
    private By viewCartLink = By.cssSelector(".added_to_cart.wc-forward");

    public WomenCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void addFirstProductToCart() {
        WebElement firstProduct = getProducts().getFirst();
        WebElement addBtn = firstProduct.findElement(addToCartBtn);
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
    }

    public boolean isViewCartLinkVisible() {
        try {
            Thread.sleep(1500);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

    public boolean isAddToCartButtonChanged() {
        try {
            WebElement firstProduct = getProducts().getFirst();
            WebElement button = firstProduct.findElement(addToCartBtn);
            String buttonClass = button.getAttribute("class");
            return buttonClass != null && buttonClass.contains("added");
        } catch (Exception e) {
            return false;
        }
    }
}