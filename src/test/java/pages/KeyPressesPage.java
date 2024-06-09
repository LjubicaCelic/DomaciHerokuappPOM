package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {
    private WebDriver driver;
    private WebElement inputField;
    private WebElement result;
    private WebElement message;
    private WebElement messagePoweredBy;

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputField() {
        return driver.findElement(By.id("target"));
    }

    public WebElement getResult() {
        return driver.findElement(By.id("result"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("example"));
    }

    public WebElement getMessagePoweredBy() {
        return driver.findElement(By.linkText("Elemental Selenium"));
    }


}
