package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By registrationUsernameInput = By.id("reg_username");
    private By registrationEmailInput = By.id("reg_email");
    private By registrationPasswordInput = By.id("reg_password");
    private By registrationSubmitBtn = By.cssSelector("button[name='register']");
    private By registrationForm = By.cssSelector(".woocommerce-form-register");

    private By loginEmailInput = By.id("username");
    private By loginPasswordInput = By.id("password");
    private By loginSubmitBtn = By.cssSelector("button[name='login']");
    private By loginForm = By.cssSelector(".woocommerce-form-login");

    private By dashboardLink = By.linkText("Dashboard");
    private By welcomeMessage = By.xpath("//p[contains(text(), 'Hello')]");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeAds() {
        try {
            WebElement closeBtn = driver.findElement(By.cssSelector(".ad-close, .close-ad, [aria-label='Close']"));
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }

    public boolean isRegistrationFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationForm)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void registerUser(String username, String email, String password) {
        closeAds();
        wait.until(ExpectedConditions.elementToBeClickable(registrationUsernameInput)).sendKeys(username);
        driver.findElement(registrationEmailInput).sendKeys(email);
        driver.findElement(registrationPasswordInput).sendKeys(password);
        driver.findElement(registrationSubmitBtn).click();
    }

    public void loginUser(String email, String password) {
        closeAds();
        wait.until(ExpectedConditions.elementToBeClickable(loginEmailInput)).sendKeys(email);
        driver.findElement(loginPasswordInput).sendKeys(password);
        driver.findElement(loginSubmitBtn).click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            Thread.sleep(2000);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)) != null;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isLoginSuccessful() {
        try {
            Thread.sleep(2000);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)) != null;
        } catch (Exception e) {
            return false;
        }
    }
}