package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        String URL= "https://www.facebook.com/";
        WebDriver driver = getDriver(URL);

        driver.findElement(By.partialLinkText("Crear cuenta")).click();
        Thread.sleep(1000);

        //Completamos segun datos
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");

        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        setBirthdate(driver,26,06,1980);

        //Genero
        List<WebElement> listaGenero = driver.findElements(By.name("sex"));
        WebElement seleccionMasculino = listaGenero.get(1);
        seleccionMasculino.click();

    }

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
    public void setBirthdate(WebDriver aSetear, int día, int mes, int anio){
        WebElement diaCumple= aSetear.findElement(By.name("birthday_day"));
        WebElement mesCumple= aSetear.findElement(By.name("birthday_month"));
        WebElement anioCumple= aSetear.findElement(By.name("birthday_year"));

        Select elegirDia = new Select(diaCumple);
        Select elegirMes= new Select(mesCumple);
        Select elegirAnio = new Select(anioCumple);

        elegirDia.selectByValue(String.valueOf(día));
        elegirMes.selectByValue(String.valueOf(mes));
        elegirAnio.selectByVisibleText(String.valueOf(anio));

    }



}
