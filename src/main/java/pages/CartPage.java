package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By cartItems = By.cssSelector("tr.woocommerce-cart-form__cart-item");
    private By quantityInput = By.cssSelector("input[type='number'].qty");
    private By updateCart = By.cssSelector("button[name='update_cart']");
    private By cartEmpty = By.cssSelector(".woocommerce-cart-empty");
    private By checkoutBtn = By.linkText("Checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public int getCartItemCount() {
        try {
            return getCartItems().size();
        } catch (Exception e) {
            return 0;
        }
    }

    public List<WebElement> getCartItems() {
        try {
            Thread.sleep(1500);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartItems));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public boolean isCartEmpty() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cartEmpty)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getQuantityOfFirstItem() {
        try {
            Thread.sleep(1000);
            WebElement quantityField = getCartItems().getFirst().findElement(quantityInput);
            return quantityField.getAttribute("value");
        } catch (Exception e) {
            return "0";
        }
    }

    public void increaseQuantityOfFirstItem() {
        try {
            WebElement firstItem = getCartItems().getFirst();
            WebElement quantityField = firstItem.findElement(quantityInput);

            actions.moveToElement(quantityField).perform();
            Thread.sleep(500);

            WebElement increaseBtn = quantityField.findElement(By.xpath("./following-sibling::*[contains(@class, 'up')]"));
            wait.until(ExpectedConditions.elementToBeClickable(increaseBtn)).click();
        } catch (Exception e) {
            WebElement firstItem = getCartItems().getFirst();
            WebElement quantityField = firstItem.findElement(quantityInput);
            String currentQty = quantityField.getAttribute("value");
            assert currentQty != null;
            int newQty = Integer.parseInt(currentQty) + 10;
            quantityField.clear();
            quantityField.sendKeys(String.valueOf(newQty));
        }
    }

    public void decreaseQuantityOfFirstItem() {
        try {
            WebElement firstItem = getCartItems().getFirst();
            WebElement quantityField = firstItem.findElement(quantityInput);

            actions.moveToElement(quantityField).perform();
            Thread.sleep(500);

            WebElement decreaseBtn = quantityField.findElement(By.xpath("./following-sibling::*[contains(@class, 'down')]"));
            wait.until(ExpectedConditions.elementToBeClickable(decreaseBtn)).click();
        } catch (Exception e) {
            WebElement firstItem = getCartItems().getFirst();
            WebElement quantityField = firstItem.findElement(quantityInput);
            String currentQty = quantityField.getAttribute("value");
            assert currentQty != null;
            int newQty = Integer.parseInt(currentQty) - 1;
            if (newQty > 0) {
                quantityField.clear();
                quantityField.sendKeys(String.valueOf(newQty));
            }
        }
    }

    public void clickUpdateCart() {
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(updateCart)).click();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isCheckoutVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}