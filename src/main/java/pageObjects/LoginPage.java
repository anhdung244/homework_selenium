package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By emailCreate = By.xpath("//input[@id='email_create']");
    By btnRegister = By.xpath("//button[@id='SubmitCreate']");

    By email = By.xpath("//input[@id='email']");
    By password = By.xpath("//input[@id='passwd']");
    By btnLogin = By.xpath("//button[@id='SubmitLogin']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Email Create
    public WebElement getEmailCreate() {
        return driver.findElement(emailCreate);
    }

    public WebElement btnRegister() {
        return driver.findElement(btnRegister);
    }

    // Login
    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement btnLogin() {
        return driver.findElement(btnLogin);

    }
}
