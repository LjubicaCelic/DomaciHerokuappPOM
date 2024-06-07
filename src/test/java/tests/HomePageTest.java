package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends Base {
    String expectedUrl = "https://the-internet.herokuapp.com/";
    String actualUrl;
    String expectedMessage = "Welcome to the-internet";
    String actualMessage;


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    //Verifying that the valid page is displayed
    @Test
    public void validPage() {
        actualUrl = driver.getCurrentUrl();
        actualMessage = homePage.getWelcomeMessage();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(homePage.getAddRemoveElementsLink().isDisplayed());
        Assert.assertTrue(homePage.getCheckBoxesLink().isDisplayed());
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }
}
