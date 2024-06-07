package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

import java.time.Duration;

public class CheckBoxesTest extends Base {

    String expectedUrl = "https://the-internet.herokuapp.com/checkboxes";
    String actualUrl;


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    // Verifying that the valid page is displayed by checking the URL and ensuring checkboxes are displayed
    @Test
    public void validPage() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(checkBoxesPage.getCheckbox1().isDisplayed());
        Assert.assertTrue(checkBoxesPage.getCheckbox2().isDisplayed());
    }

    // verifying that checkbox 2 is selected
    @Test
    public void checkbox2IsSelected() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        Assert.assertFalse(checkBoxesPage.getCheckbox1().isSelected());
        Assert.assertTrue(checkBoxesPage.getCheckbox2().isSelected());
    }

    // verifying that both checkboxes are selected
    @Test
    public void checkboxesBothSelected() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        checkBoxesPage.getCheckbox1().click();
        Assert.assertTrue(checkBoxesPage.getCheckbox1().isSelected());
        Assert.assertTrue(checkBoxesPage.getCheckbox2().isSelected());
    }

    // verifying that checkbox 1 is selected
    @Test
    public void checkbox1IsSelected() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        checkBoxesPage.getCheckbox1().click();
        checkBoxesPage.getCheckbox2().click();
        Assert.assertFalse(checkBoxesPage.getCheckbox2().isSelected());
        Assert.assertTrue(checkBoxesPage.getCheckbox1().isSelected());
    }

    // verifying that no checkboxes are selected
    @Test
    public void noSelectedCheckboxes() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        checkBoxesPage.getCheckbox2().click();
        Assert.assertFalse(checkBoxesPage.getCheckbox1().isSelected());
        Assert.assertFalse(checkBoxesPage.getCheckbox2().isSelected());
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }


}