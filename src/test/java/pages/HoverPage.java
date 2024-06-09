package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage {
    private WebDriver driver;
    private List<WebElement> users;
    private List<WebElement> usernames;
    private String hoverMessage;

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getUsers() {
        return driver.findElements(By.className("figure"));
    }

    public List<WebElement> getUsernames() {
        return driver.findElements(By.className("figcaption"));
    }

    public String getPageMessage() {
        WebElement hoverText = driver.findElement(By.className("example"));
        return hoverText.getText();
    }

    //------------------------------------------------------------------

    public void hover(int i) {
        Actions action = new Actions(driver);
        action.moveToElement(getUsers().get(i)).perform();
    }

}
