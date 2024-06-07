package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import java.time.Duration;

public class LoginTest extends Base {
    String validUsername = "tomsmith";
    String validPassword = "SuperSecretPassword!";
    String invalidUsername = "invalidUsername";
    String invalidPassword = "1234";
    String invalidUsernameMessage = "Your username is invalid!\n" + "×";
    String invalidPasswordMessage = "Your password is invalid!\n" + "×";
    String actualSecureAreaMessage;
    String expectedSecureAreaMessage = "Welcome to the Secure Area. When you are done click logout below.";
    String expectedUrl = "https://the-internet.herokuapp.com/login";
    String actualUrl;
    String secureUrl = "https://the-internet.herokuapp.com/secure";

    @BeforeMethod
    public void setUpPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    // Verifying that the login page is valid by checking the URL and the presence of login elements
    @Test
    public void isValidPage() {
        LoginPage loginPage = homePage.clickOnFormAuthenticationLink();
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }

    // Verifying successful login using valid username and password
    @Test
    public void successfulLogin() {
        LoginPage loginPage = homePage.clickOnFormAuthenticationLink();
        SecureAreaPage secureAreaPage = loginPage.login();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.login();
        actualUrl = driver.getCurrentUrl();
        actualSecureAreaMessage = secureAreaPage.getSecureAreaMessage();
        Assert.assertEquals(actualUrl, secureUrl);
        Assert.assertEquals(actualSecureAreaMessage, expectedSecureAreaMessage);
    }

    // Verifying that an invalid username triggers the correct error message
    @Test
    public void invalidUsername() {
        LoginPage loginPage = homePage.clickOnFormAuthenticationLink();
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(validPassword);
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorMessage(), invalidUsernameMessage);
    }

    // Verifying that an invalid password triggers the correct error message
    @Test
    public void invalidPassword() {
        LoginPage loginPage = homePage.clickOnFormAuthenticationLink();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(invalidPassword);
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorMessage(), invalidPasswordMessage);
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }


}
