package tests;

import base.Base;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import java.time.Duration;
import java.util.Random;


public class KeyPressesTest extends Base {
    String expectedMessage = "Key Presses\n" + "Key presses are often used to interact with a website (e.g., tab order, enter, escape, etc.). Press a key and see what you inputted.";
    String expectedUrl = "https://the-internet.herokuapp.com/key_presses";
    Random r = new Random();
    char c = (char) (r.nextInt(26) + 'a');
    String enteredChar = "" + c;
    String expectedResult = "You entered: " + enteredChar.toUpperCase();
    String youEnteredMessage = "You entered: ";

    @BeforeMethod
    public void setUpPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    // Verifying that the page is valid by checking the URL, message, input field, and "Powered by" message
    @Test
    public void isValidPage() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(keyPressesPage.getMessage().getText(), expectedMessage);
        Assert.assertTrue(keyPressesPage.getInputField().isDisplayed());
        Assert.assertTrue(keyPressesPage.getMessagePoweredBy().isDisplayed());
    }

    // Verifying that the entered character is displayed correctly
    @Test
    public void isValidEnter() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        keyPressesPage.getInputField().sendKeys(enteredChar);
        String actualResult = keyPressesPage.getResult().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }


    // Verifying that the correct message is displayed when pressing the TAB key
    @Test
    public void enterTab() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        keyPressesPage.getInputField().sendKeys(Keys.TAB);
        String message = youEnteredMessage + "TAB";
        Assert.assertEquals(keyPressesPage.getResult().getText(), message);
    }

    // Verifying that the correct message is displayed when pressing the ALT key
    @Test
    public void enterAlt() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        keyPressesPage.getInputField().sendKeys(Keys.ALT);
        String message = youEnteredMessage + "ALT";
        Assert.assertEquals(keyPressesPage.getResult().getText(), message);
    }

    // Verifying that the correct message is displayed when pressing the ESCAPE key
    @Test
    public void enterEsc() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        keyPressesPage.getInputField().sendKeys(Keys.ESCAPE);
        String message = youEnteredMessage + "ESCAPE";
        Assert.assertEquals(keyPressesPage.getResult().getText(), message);
    }

    // Verifying that the correct message is displayed when pressing the F10 key
    @Test
    public void enterF10() {
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPressesLink();
        keyPressesPage.getInputField().sendKeys(Keys.F10);
        String message = youEnteredMessage + "F10";
        Assert.assertEquals(keyPressesPage.getResult().getText(), message);
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }


}
