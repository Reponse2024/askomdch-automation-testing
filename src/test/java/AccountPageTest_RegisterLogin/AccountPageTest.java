package AccountPageTest_RegisterLogin;

import BaseTest.BaseTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.AccountPage;

public class AccountPageTest extends BaseTests {

    @Test
    public void testRegistrationFormIsVisible() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccount();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isRegistrationFormVisible(), "Registration form should be visible");
    }

    @Test
    public void testLoginFormIsVisible() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccount();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isLoginFormVisible(), "Login form should be visible");
    }

    @Test
    public void testUserRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccount();

        AccountPage accountPage = new AccountPage(driver);
        String uniqueUsername = "Reponse" + System.currentTimeMillis();
        String email = uniqueUsername + "@gmail.com";
        accountPage.registerUser(uniqueUsername, email, "Reponse123");
        Assert.assertTrue(accountPage.isRegistrationSuccessful(), "Registration should be successful");
    }

    @Test
    public void testUserLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAccount();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.loginUser("Albert", "123");
        Assert.assertTrue(accountPage.isLoginSuccessful(), "Login should be successful");
    }
}