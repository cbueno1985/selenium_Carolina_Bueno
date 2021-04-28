package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

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
        driver.findElement(By.cssSelector("#__next > main > div.encore-light-theme > div > form > fieldset > div > div:nth-child(2) > label > span.Indicator-sc-16vj7o8-0.iBjMfh")).click();

        driver.findElement(By.cssSelector("#__next > main > div.encore-light-theme > div > form > div:nth-child(8) > div > label > span.Indicator-sc-11vkltc-0.ioJObh")).click();

        //Botón Registro
        driver.findElement(By.cssSelector("#__next > main > div.encore-light-theme > div > form > div.EmailForm__Center-jwtojv-0.eaexVT > div > button > div.ButtonInner-peijbp-0.hlHQCm.encore-bright-accent-set.SignupButton___StyledButtonPrimary-cjcq5h-1.gzFCtx")).click();

    }

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
}
