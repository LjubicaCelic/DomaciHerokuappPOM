package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddElementPage {
    private WebDriver driver;
    private List<WebElement> deleteButtons;
    private WebElement addElement;


    public AddElementPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getAddRemove() {
        return driver.findElement(By.linkText("Add/Remove Elements"));
    }

    public WebElement getAddElement() {
        return driver.findElement(By.cssSelector("button[onclick='addElement()']"));
    }

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(By.className("added-manually"));
    }

    //-------------------------------------------------------------------------------------


    public void addButton() {
        getAddElement().click();
    }

    //deleting first element
    public void deleteButton() {
        if (!getDeleteButtons().isEmpty()) {
            getDeleteButtons().get(0).click();
        }
    }


}
