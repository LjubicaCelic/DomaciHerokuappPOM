package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement error;
    private String errorMessage;
    private String secureAreaMessage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getError() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    public String getErrorMessage() {
        return getError().getText();
    }

    //-----------------------------------------------------------------------------

    public void enterUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public SecureAreaPage login() {
        getLoginButton().click();
        return new SecureAreaPage(driver);
    }


}
