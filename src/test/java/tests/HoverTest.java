package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

import java.time.Duration;

public class HoverTest extends Base {
    String actualUrl;
    String expectedUrl = "https://the-internet.herokuapp.com/hovers";
    String actualPageMessage;
    String expectedPageMessage = "Hovers\n" + "Hover over the image for additional information";
    String user1Message = "name: user1\n" + "View profile";
    String user2Message = "name: user2\n" + "View profile";
    String user3Message = "name: user3\n" + "View profile";
    String actualMessage;

    @BeforeMethod
    public void setUpPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    //Verifying that the valid page is displayed by checking the URL, ensuring that user images are displayed, and confirming that the page message matches the expected message
    @Test
    public void validPage() {
        HoverPage hoverPage = homePage.clickOnHoversLink();
        actualUrl = driver.getCurrentUrl();
        actualPageMessage = hoverPage.getPageMessage();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(hoverPage.getUsers().get(0).isDisplayed());
        Assert.assertTrue(hoverPage.getUsers().get(1).isDisplayed());
        Assert.assertTrue(hoverPage.getUsers().get(2).isDisplayed());
        Assert.assertEquals(actualPageMessage, expectedPageMessage);
    }

    // Verifying that the correct username message is displayed when hovering over the first user
    @Test
    public void hoverUser1() {
        HoverPage hoverPage = homePage.clickOnHoversLink();
        hoverPage.hover(0);
        actualMessage = hoverPage.getUsernames().get(0).getText();

        Assert.assertEquals(actualMessage, user1Message);
    }

    // Verifying that the correct username message is displayed when hovering over the second user
    @Test
    public void hoverUser2() {
        HoverPage hoverPage = homePage.clickOnHoversLink();
        hoverPage.hover(1);
        actualMessage = hoverPage.getUsernames().get(1).getText();

        Assert.assertEquals(actualMessage, user2Message);
    }

    // Verifying that the correct username message is displayed when hovering over the third user
    @Test
    public void hoverUser3() {
        HoverPage hoverPage = homePage.clickOnHoversLink();
        hoverPage.hover(2);
        actualMessage = hoverPage.getUsernames().get(2).getText();

        Assert.assertEquals(actualMessage, user3Message);
    }

    // Verifying that the correct username messages are displayed when hovering over the user
    @Test
    public void hoverAllUsers() {
        HoverPage hoverPage = homePage.clickOnHoversLink();
        hoverPage.hover(0);
        actualMessage = hoverPage.getUsernames().get(0).getText();
        Assert.assertEquals(actualMessage, user1Message);

        hoverPage.hover(1);
        actualMessage = hoverPage.getUsernames().get(1).getText();
        Assert.assertEquals(actualMessage, user2Message);

        hoverPage.hover(2);
        actualMessage = hoverPage.getUsernames().get(2).getText();
        Assert.assertEquals(actualMessage, user3Message);

    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }

}
