import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio1 {

    @Test
    public void Ejercicio1(){

        //Acceder a Netflix: https://www.netflix.com/uy/
        WebDriver driver = getDriver("https://www.netflix.com/uy/");
        //Mostrar los elementos h1 y h2 que hay en el sitio

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("\n ********** Los datos para h1 son **********");

        for (WebElement a: listaH1s){
            System.out.println("H1-->" + a.getText());
        }

        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("\n ********** Los datos para h2 son **********");
        for (WebElement a: listaH2s){
            System.out.println("H2-->" +a.getText());
        }

        //Refrescar la página
        driver.navigate().refresh();

        //Mostrar el texto de los botones que se encuentran en la página

        List<WebElement> botones = driver.findElements(By.tagName("button"));
        System.out.println("\n ********** Botones **********");
        for(WebElement a: botones){
            System.out.println("botón: "+ a.getText());
        }

        //Mostrar la cantidad de elementos div que contiene el sitio
        List<WebElement> divElementos = driver.findElements(By.tagName("div"));
        System.out.println("\nLa cantidad de elementos div: "+ divElementos.size());

        //Obtener y mostrar el título de la página
        System.out.println("El titulo de la pagina es: "+ driver.getTitle());

        //Mostrar la cantidad de elementos de tipos link
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("\n ********** Los links son **********");
        for(WebElement a: links){
            if (a.getText().isEmpty()==false)
                System.out.println("Link: " + a.getText());
        }
    }

  
    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
}
