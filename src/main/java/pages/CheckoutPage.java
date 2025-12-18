package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By billingFirstNameInput_InputElement = By.id("billing_first_name");
    By billingLastNameInput_InputElement = By.id("billing_last_name");
    By billingCountrySelect_SelectElement = By.id("billing_country");
    By billingAddressInput_InputElement = By.id("billing_address_1");
    By billingCityInput_InputElement = By.id("billing_city");
    By billingStateInput_InputElement = By.id("billing_state");
    By billingPostcodeInput_InputElement = By.id("billing_postcode");
    By billingEmailInput_InputElement = By.id("billing_email");
    By paymentMethodRadio_RadioElement = By.id("payment_method_cod");
    By placeOrderButton_ButtonElement = By.id("place_order");
    By orderConfirmationMessage_DivElement = By.cssSelector("div.woocommerce-message");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillBillingFirstName(String firstName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(billingFirstNameInput_InputElement));
        driver.findElement(billingFirstNameInput_InputElement).sendKeys(firstName);
    }

    public void fillBillingLastName(String lastName) {
        driver.findElement(billingLastNameInput_InputElement).sendKeys(lastName);
    }

    public void selectBillingCountry(String country) {
        Select countrySelect = new Select(driver.findElement(billingCountrySelect_SelectElement));
        countrySelect.selectByVisibleText(country);
    }

    public void fillBillingAddress(String address) {
        driver.findElement(billingAddressInput_InputElement).sendKeys(address);
    }

    public void fillBillingCity(String city) {
        driver.findElement(billingCityInput_InputElement).sendKeys(city);
    }

    public void fillBillingState(String state) {
        driver.findElement(billingStateInput_InputElement).sendKeys(state);
    }

    public void fillBillingPostcode(String postcode) {
        driver.findElement(billingPostcodeInput_InputElement).sendKeys(postcode);
    }

    public void fillBillingEmail(String email) {
        driver.findElement(billingEmailInput_InputElement).sendKeys(email);
    }

    public void fillBillingDetails(String firstName, String lastName, String country, String address, String city, String state, String postcode, String email) {
        fillBillingFirstName(firstName);
        fillBillingLastName(lastName);
        selectBillingCountry(country);
        fillBillingAddress(address);
        fillBillingCity(city);
        fillBillingState(state);
        fillBillingPostcode(postcode);
        fillBillingEmail(email);
    }

    public void selectPaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodRadio_RadioElement));
        driver.findElement(paymentMethodRadio_RadioElement).click();
    }

    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton_ButtonElement));
        driver.findElement(placeOrderButton_ButtonElement).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(orderConfirmationMessage_DivElement));
    }

    public void placeOrder(String firstName, String lastName, String country, String address, String city, String state, String postcode, String email) {
        fillBillingDetails(firstName, lastName, country, address, city, state, postcode, email);
        selectPaymentMethod();
        clickPlaceOrderButton();
    }

    public boolean isOrderConfirmationDisplayed() {
        return !driver.findElements(orderConfirmationMessage_DivElement).isEmpty();
    }
}