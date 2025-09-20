package com.platinum.tests.stepdefs;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.es.*;

public class LoginSteps {
    private WebDriver driver;

    @Dado("que abro la aplicación de Banco Platinum")
    public void abrirApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/CtaCorriente/login.jsp");
    }

    @Cuando("ingreso rut {string} y nombre {string}")
    public void ingresoCredenciales(String rut, String nombre) {
        driver.findElement(By.name("rut")).sendKeys(rut);
        driver.findElement(By.name("nombre")).sendKeys(nombre);
    }

    @Cuando("presiono Ingresar")
    public void presionoIngresar() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Entonces("debería ver la página de inicio del ejecutivo")
    public void validarHome() {
        assertTrue(driver.getCurrentUrl().contains("home.jsp"));
        driver.quit();
    }
}
