package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHome() {
        return driver.findElement(By.xpath("//a[@title='Home']"));
    }

}
