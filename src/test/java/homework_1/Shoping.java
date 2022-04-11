package homework_1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class Shoping extends base {
    @BeforeTest
    public void initialize() throws IOException {
        driver = initialDriver();
    }

    @Test
    public void Shopping() throws InterruptedException {
        driver.get(prop.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys("19521394@gm.uit.edu.vn");
        loginPage.getPassword().sendKeys("Anhdung0855");
        loginPage.btnLogin().click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.getHome().click();


//        landingPage.addToCart(1);
//        Thread.sleep(1000);
//
//        landingPage.addToCart(2);
//        Thread.sleep(1000);
//
//        landingPage.checkOut();


        String[] additems = {"Blouse", "Printed Dress"};
        landingPage.addCart(additems);
        Thread.sleep(1000);
        landingPage.checkOut();
    }
}
