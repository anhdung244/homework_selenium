package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Personal Information

    public WebElement getTitle(Integer number){
        return driver.findElement(By.xpath("//input[@id='id_gender"+number+"']"));
    }

    public WebElement getFirstName(){
        return driver.findElement(By.xpath("//input[@id='customer_firstname']"));
    }

    public WebElement getLastName(){
        return driver.findElement(By.xpath("//input[@id='customer_lastname']"));
    }
    public WebElement getEmail(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement getPassword(){
        return driver.findElement(By.xpath("//input[@id='passwd']"));
    }

    public void selectBirthday(String d){
        Select day= new Select(driver.findElement(By.name("days")));
        day.selectByValue(d);

//        Select month= new Select(driver.findElement(By.name("months")));
//        day.selectByValue(m);
//
//        Select year= new Select(driver.findElement(By.name("years")));
//        day.selectByValue(y);

    }
    public void selectBirthdayMonth(String m){


        Select month= new Select(driver.findElement(By.name("months")));
        month.selectByValue(m);



    }

    public void selectBirthdayYear(String m){


        Select year= new Select(driver.findElement(By.name("years")));
        year.selectByValue(m);



    }
    //Address

    public WebElement getFirstNameAddress(){
        return driver.findElement(By.xpath("//input[@id='firstname']"));
    }

    public WebElement getLastNameAddress(){
        return driver.findElement(By.xpath("//input[@id='lastname']"));
    }

    public WebElement getAddress(){
        return driver.findElement(By.xpath("//input[@id='address1']"));
    }

    public WebElement getCity(){
        return driver.findElement(By.xpath("//input[@id='city']"));
    }

    public void getState(){
       Select state= new Select(driver.findElement(By.name("id_state")));
       state.selectByVisibleText("California");
    }

    public WebElement getZipCode(){
        return driver.findElement(By.xpath("//input[@id='postcode']"));
    }


    public void getCountry(){
        Select state= new Select(driver.findElement(By.name("id_country")));
        state.selectByVisibleText("United States");
    }

    public void getPhone(String number){
        driver.findElement(By.name("phone_mobile")).sendKeys(number);
    }

    public void getAddressAlias(String address){
        driver.findElement(By.name("alias")).sendKeys(address);
    }

    public WebElement getBtnSubmit(){
        return driver.findElement(By.name("submitAccount"));
    }

}
