package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClaseLoginFailureTest {

    public static final String SALEFORCE_URL = "https://login.salesforce.com/?locale=eu";
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriverAnt.exe");
        driver = new ChromeDriver();
        driver.get(SALEFORCE_URL);

    }

    @Test (priority = 3)
    public void LoginFailureTest(){
        WebElement hasLogo = driver.findElement(By.id("logo"));
         Assert.assertTrue(hasLogo.getText().isEmpty());

         driver.findElement(By.name("username")).sendKeys("test@test.com");
         driver.findElement(By.name("pw")).sendKeys("123466");
         driver.findElement(By.name("Login")).click();

        WebElement error =driver.findElement(By.id("error"));
        String errorEsperado = "Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.";

        Assert.assertTrue(error.getText().contains(errorEsperado));

    }
    @AfterTest
    public void afterTestNotation() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.close();

    }

}
