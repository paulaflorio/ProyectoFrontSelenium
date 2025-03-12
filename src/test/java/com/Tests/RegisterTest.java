package com.Tests;

import com.Pages.RegisterPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.extentReports.ExtentFactory;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes-Register.html");
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
    void Register() throws InterruptedException{
        ExtentTest test = extent.createTest("Prueba de Registro Exitoso");
        test.log(Status.INFO, "Comienza el test");

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.configureBrowser();
        registerPage.open("https://magento.softwaretestingboard.com/");
        test.log(Status.PASS, "Se ingresa correctamente a la página");
        registerPage.takeScreenshot("Ingreso correcto a la página");

        registerPage.clickLinkCreateAccount();
        test.log(Status.PASS, "Se ingresa correctamente a la sección de registro");
        registerPage.takeScreenshot("Ingreso correcto a la sección Registro");

        registerPage.setFirstName("Test");
        registerPage.setLastName("Test2");
        registerPage.setEmail("test@testv2578.com");
        registerPage.setPassword("test9876$");
        registerPage.setPassword("test9876$");
        registerPage.setConfirmPassword("test9876$");
        registerPage.takeScreenshot("Se completan todos los campos obligatorios");

        registerPage.clickCreateAccount();

        assertTrue(registerPage.getRegisteredMessage().equals("Thank you for registering with Main Website Store."));
        test.log(Status.PASS, "Se realiza el registro correctamente");
        registerPage.takeScreenshot("Se muestra mensaje registro exitoso");

    }

    @AfterEach
    public void closeTest(){
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void report(){
        extent.flush();
    }

}
