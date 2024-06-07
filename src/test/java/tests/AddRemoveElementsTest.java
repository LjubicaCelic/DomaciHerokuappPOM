package tests;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddElementPage;

import java.time.Duration;

public class AddRemoveElementsTest extends Base {
    String expectedUrl = "https://the-internet.herokuapp.com/add_remove_elements/";
    String actualUrl;
    int actualNumberOfElements;
    int expectedNumberOfElements;

    // Navigating to the page
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        actualNumberOfElements = 0;
    }


    // Verifying that the valid page is displayed by checking the URL, ensuring that the "Add" button is displayed, and confirming that there are no "Delete" buttons initially displayed
    @Test
    public void validPage() {
        AddElementPage addElementPage = homePage.clickOnAddElementsLink();
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(addElementPage.getAddElement().isDisplayed());
        Assert.assertTrue(addElementPage.getDeleteButtons().isEmpty());
    }


    //In this test one element is added, then it is verified that the "Add Element" button and the "Delete" button are displayed.
    @Test(priority = 10)
    public void addOneElement() {
        AddElementPage addElementPage = homePage.clickOnAddElementsLink();
        addElementPage.getAddElement().click();
        Assert.assertTrue(addElementPage.getAddElement().isDisplayed());
        Assert.assertTrue(addElementPage.getDeleteButtons().get(0).isDisplayed());
    }

    ///In this test 5 elements are added, then it is verified that the "Add Element" button is displayed.
    @Test(priority = 20)
    public void add5Elements() {
        AddElementPage addElementPage = homePage.clickOnAddElementsLink();
        expectedNumberOfElements = 5;
        for (int i = 0; i < 5; i++) {
            addElementPage.addButton();
            actualNumberOfElements++;
        }
        Assert.assertEquals(actualNumberOfElements, expectedNumberOfElements);
        Assert.assertTrue(addElementPage.getAddElement().isDisplayed());
    }


    //In this test 5 elements are added, then two of them are deleted, then it is verified that the elements are deleted.
    @Test(priority = 30)
    public void deleteTwoElements() {
        AddElementPage addElementPage = homePage.clickOnAddElementsLink();
        expectedNumberOfElements = 3;
        for (int i = 0; i < 5; i++) {
            addElementPage.addButton();
            actualNumberOfElements++;
        }

        for (int i = 0; i < 2; i++) {
            addElementPage.deleteButton();
            actualNumberOfElements--;
        }

        Assert.assertEquals(actualNumberOfElements, expectedNumberOfElements);
    }

    //In this test 5 elements are added, then all of them are deleted, then it is verified that the elements are deleted.
    @Test(priority = 40)
    public void deleteAllElements() {
        AddElementPage addElementPage = homePage.clickOnAddElementsLink();
        for (int i = 0; i < 5; i++) {
            addElementPage.addButton();
        }
        expectedNumberOfElements = 0;
        for (WebElement element : addElementPage.getDeleteButtons()) {
            element.click();
        }
        Assert.assertEquals(addElementPage.getDeleteButtons().size(), expectedNumberOfElements);
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }

}
