package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private String welcomeMessage;
    private WebElement addRemoveElementsLink;
    private WebElement checkBoxesLink;
    private WebElement formAuthenticationLink;
    private WebElement keyPressesLink;
    private WebElement hoversLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddRemoveElementsLink() {
        return driver.findElement(By.linkText("Add/Remove Elements"));
    }

    public WebElement getCheckBoxesLink() {
        return driver.findElement(By.linkText("Checkboxes"));
    }

    public WebElement getFormAuthenticationLink() {
        return driver.findElement(By.linkText("Form Authentication"));
    }

    public WebElement getKeyPressesLink() {
        return driver.findElement(By.linkText("Key Presses"));
    }

    public WebElement getHoversLink() {
        return driver.findElement(By.linkText("Hovers"));
    }

    public String getWelcomeMessage() {
        WebElement message = driver.findElement(By.className("heading"));
        welcomeMessage = message.getText();
        return welcomeMessage;
    }


    //----------------------------------------------------------


    public AddElementPage clickOnAddElementsLink() {
        getAddRemoveElementsLink().click();
        return new AddElementPage(driver);
    }

    public CheckBoxesPage clickCheckBoxesLink() {
        getCheckBoxesLink().click();
        return new CheckBoxesPage(driver);
    }

    public LoginPage clickOnFormAuthenticationLink() {
        getFormAuthenticationLink().click();
        return new LoginPage(driver);
    }

    public KeyPressesPage clickOnKeyPressesLink() {
        getKeyPressesLink().click();
        return new KeyPressesPage(driver);
    }

    public HoverPage clickOnHoversLink() {
        getHoversLink().click();
        return new HoverPage(driver);
    }

}
