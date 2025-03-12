package com.Tests;

import com.Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.extentReports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes-Login.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    @Test
    void Login() throws InterruptedException{
        ExtentTest test = extent.createTest("Prueba de Ingreso Exitoso");
        test.log(Status.INFO, "Comienza el test");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.configureBrowser();
        loginPage.open("https://magento.softwaretestingboard.com/");
        test.log(Status.PASS, "Se ingresa correctamente a la página");
        loginPage.takeScreenshot("Ingreso correcto a la página");

        loginPage.clickLinkSignIn();
        test.log(Status.PASS, "Se ingresa correctamente a la sección de login");
        loginPage.takeScreenshot("Ingreso correcto a la sección login");

        loginPage.setEmail("test@testv23.com");
        loginPage.setPassword("test9876$");
        loginPage.takeScreenshot("Se completan todos los campos obligatorios");

        loginPage.clickSignIn();

        assertTrue(loginPage.getGreet().contains("Welcome,"));
        test.log(Status.PASS, "Se visualiza mensaje de saludo al ingresar");
        loginPage.takeScreenshot("Se muestra mensaje de saludo al ingresar");

    }

    @AfterEach
    public void closeTest(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void report(){
        extent.flush();
    }
}
