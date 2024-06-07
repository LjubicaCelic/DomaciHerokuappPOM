package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {
    WebDriver driver;
    WebElement loggedInMessage;
    WebElement secureAreaText;
    WebElement logoutButton;
    String secureAreaMessage;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoggedInMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getSecureAreaText() {
        return driver.findElement(By.className("subheader"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public String getSecureAreaMessage() {
        return getSecureAreaText().getText();
    }

    //---------------------------------------------------------------------
    public void getToSecurePage() {
        driver.get("https://the-internet.herokuapp.com/secure");
    }

    public void logout() {
        getLogoutButton().click();
    }

}
