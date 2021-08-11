package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyWithCssSelectorTest {

    @Test
    public void spotifyByPlaceHolderTest(){
        String URL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = getDriver(URL);

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("pruebatesting@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("pruebatesting@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("contraseña12433");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("PruebaTest");

        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("20");

        WebElement ListaMes= driver.findElement(By.cssSelector("select[name='month']"));
        Select mes = new Select(ListaMes);
        mes.selectByIndex(2);

        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1978");

        //Sexo
        driver.findElement(By.xpath("//*[contains(text(), 'Mujer' )]")).click();


        driver.findElement(By.xpath("//*[contains(text(), 'Prefiero no recibir' )]")).click();

        driver.findElement(By.xpath("//*[contains(text(), 'Compartir mis datos de ' )]")).click();

        //Botón Registro
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriverAnt.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
}
