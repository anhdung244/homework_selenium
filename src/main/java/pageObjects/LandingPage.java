package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LandingPage extends base {
    public WebDriver driver;
    WebDriverWait wait;
    By signIn = By.xpath("//a[@class='login']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage getLogin() {
        driver.findElement(signIn).click();

        LoginPage lp = new LoginPage(driver);
        return lp;
    }

    //method 1
    public void addToCart(Integer number) {
        driver.findElement(By.xpath("(//a[@title='Add to cart'])[" + number + "]")).click();
        WebElement continueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();


    }

    //method 2
    public void addCart(String[] additems) throws InterruptedException {
        List<WebElement> list = driver.findElements(By.cssSelector("a.product-name"));

        for (int i = 0; i < list.size(); i++) {
            String productname = list.get(i).getText();
//            String frmtdname = productname[0].trim();
            List itemsneeded = Arrays.asList(additems);

            if (itemsneeded.contains(productname)) {

                List<WebElement> list2 = driver.findElements(By.xpath("//a[@title='Add to cart']"));
                list2.get(i).click();

                WebElement continueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
                wait.until(ExpectedConditions.visibilityOf(continueShopping));
                continueShopping.click();
                System.out.println("One product added");
                Thread.sleep(1000);

            }
        }
    }

    public void checkOut() throws InterruptedException {
        WebElement elementHover = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));

//        scroll
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementHover);
        Thread.sleep(500);

        WebElement elementClick = driver.findElement(By.xpath("//a[@title='Check out']"));
        Actions action = new Actions(driver);

        action.moveToElement(elementHover).build().perform();
//        Thread.sleep(1000);
//        action.moveToElement(elementClick);
//        action.click().build().perform();
        elementClick.click();

    }

}
