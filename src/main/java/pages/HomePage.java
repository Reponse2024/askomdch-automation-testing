package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By storeTab= By.linkText("Store");
    private By accountTab= By.linkText("Account");
    private By menTab = By.id("menu-item-1228");
    private By womenTab = By.id("menu-item-1229");
    private By accessoriesTab = By.id("menu-item-1230");
    private By cartIcon = By.cssSelector(".cart-container");
    private By cartCount = By.cssSelector(".ast-cart-menu-wrap .count");
    private By storeNavigationTab = By.linkText("Store");

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(8));
    }
    public void navigateToStoreTab(){
        wait.until(ExpectedConditions.elementToBeClickable(storeTab)).click();
    }
    public void navigateToAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(accountTab)).click();
    }
    public void navigateToWomen() {
        wait.until(ExpectedConditions.elementToBeClickable(womenTab)).click();
    }

   /* public void navigateToMen() {
        wait.until(ExpectedConditions.elementToBeClickable(menTab)).click();
    }
    public void navigateToAccessories() {
        wait.until(ExpectedConditions.elementToBeClickable(accessoriesTab)).click();
    }
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    */

    public String getCartCount() {
        try {
            waitForElement();
            WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));
            String count = cartCountElement.getText().trim();
            return count.isEmpty() ? "0" : count;
        } catch (Exception e) {
            return "0";
        }
    }
    private void waitForElement() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isStoreTabVisible(){
        return driver.findElement(storeTab).isDisplayed();
    }
    public boolean isAccountTabVisible(){
        return driver.findElement(accountTab).isDisplayed();
    }

    public void clickStoreNavigationTab() {
        wait.until(ExpectedConditions.elementToBeClickable(storeNavigationTab)).click();
    }



}
