package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver= null;

    @Before
    public static void openBrowser(){
//        System.setProperty("webdriver.chrome.driver","D:\\FET\\EcommerceAutomation\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\FET\\EcommerceAutomation\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
