package homework_1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import resources.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Register extends base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialDriver();
    }

    @Test(dataProvider = "")
    public void register() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailCreate().sendKeys("quysu123bd@gmail.com");
        loginPage.btnRegister().click();
        Thread.sleep(1000);

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.getTitle(1).click();

        registerPage.getFirstName().sendKeys("Dung");
        registerPage.getLastName().sendKeys("Nguyen Anh");
//      registerPage.getEmail().sendKeys("anhdung0914@gmail.com");
        registerPage.getPassword().sendKeys("Anhdung0855");
        registerPage.selectBirthday("24");
        registerPage.selectBirthdayMonth("4");
        registerPage.selectBirthdayYear("2021");

//        registerPage.getFirstNameAddress().sendKeys("Dung");
//        registerPage.getLastNameAddress().sendKeys("Nguyen Anh");
        registerPage.getAddress().sendKeys("Thu Duc");
        registerPage.getCity().sendKeys("Ho Chi Minh");
        registerPage.getState();
        registerPage.getZipCode().sendKeys("00000");
        registerPage.getCountry();
        registerPage.getPhone("0855589818");
        registerPage.getAddressAlias("Binh Thanh");
        registerPage.getBtnSubmit().click();
    }


}