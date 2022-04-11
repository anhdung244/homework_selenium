package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initialDriver() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(
                "D:\\Pratice\\homework_1\\src\\main\\java\\resources\\data.properties");

        prop.load(file);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Pratice\\homework_1\\src\\main\\java\\resources\\chromedriver.exe");

            driver = new ChromeDriver();
        } else if (browserName.equals("IE")) {
            // IE code
        }
//        System.setProperty("webdriver.chrome.driver", "D:\\Pratice\\homework_1\\src\\main\\java\\resources\\chromedriver.exe");
//        WebDriver driver= new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}