package com.Tests;

import com.Pages.EditAccountPage;
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

public class EditAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes-Edit-Account.html");
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
    void EditAccount() throws InterruptedException{
        ExtentTest test = extent.createTest("Prueba de Editar Perfil");
        test.log(Status.INFO, "Comienza el test");

        EditAccountPage editAccountPage = new EditAccountPage(driver, wait);
        editAccountPage.configureBrowser();
        editAccountPage.open("https://magento.softwaretestingboard.com/");
        test.log(Status.PASS, "Se ingresa correctamente a la página");
        editAccountPage.takeScreenshot("Ingreso correcto a la página");

        editAccountPage.clickLinkSignIn();
        test.log(Status.PASS, "Se ingresa correctamente a la sección de login");
        editAccountPage.takeScreenshot("Ingreso correcto a la sección login");

        editAccountPage.setEmail("test@testv2578.com");
        editAccountPage.setPassword("test9876$");
        editAccountPage.takeScreenshot("Se completan todos los campos obligatorios");

        editAccountPage.clickSignIn();
        editAccountPage.takeScreenshot("Se muestra pantalla home");

        editAccountPage.clickDropdownMenu();
        editAccountPage.clickLinkMyAccount();
        editAccountPage.takeScreenshot("Se muestra pantalla My Account");

        editAccountPage.clickLinkManageAddress();
        editAccountPage.takeScreenshot("Se muestra pantalla Address Book");

        editAccountPage.setPhone("11223344");
        editAccountPage.setAddress("Test 456");
        editAccountPage.setCity("City");
        editAccountPage.setState();
        editAccountPage.setCountry();
        editAccountPage.setZip("2342");
        editAccountPage.takeScreenshot("Se completan todos los datos");

        editAccountPage.clickSave();
        assertTrue(editAccountPage.getSavedMessage().equals("You saved the address."));
        test.log(Status.PASS, "Se guardan los cambios");
        editAccountPage.takeScreenshot("Se muestra mensaje exitoso");
    }

    @AfterEach
    public void closeTest(){
        EditAccountPage editAccountPage = new EditAccountPage(driver, wait);
        editAccountPage.close();
    }

    @AfterAll
    public static void report(){
        extent.flush();
    }
}
