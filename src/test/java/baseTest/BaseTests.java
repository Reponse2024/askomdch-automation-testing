package baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    protected WebDriver driver;
    protected String baseURL = "https://askomdch.com/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}