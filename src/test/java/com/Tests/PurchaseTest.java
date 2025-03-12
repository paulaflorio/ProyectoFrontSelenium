package com.Tests;

import com.Pages.PurchasePage;
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

public class PurchaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes-Purchase.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(15000));
    }

    @Test
    void Purchase() throws InterruptedException{
        ExtentTest test = extent.createTest("Prueba de Realizar Compra");
        test.log(Status.INFO, "Comienza el test");

        PurchasePage purchasePage = new PurchasePage(driver, wait);
        purchasePage.configureBrowser();
        purchasePage.open("https://magento.softwaretestingboard.com/");
        test.log(Status.PASS, "Se ingresa correctamente a la página");
        purchasePage.takeScreenshot("Ingreso correcto a la página");

        purchasePage.clickLinkSignIn();
        test.log(Status.PASS, "Se ingresa correctamente a la sección de login");
        purchasePage.takeScreenshot("Ingreso correcto a la sección login");

        purchasePage.setEmail("test@testv2578.com");
        purchasePage.setPassword("test9876$");
        purchasePage.takeScreenshot("Se completan todos los campos obligatorios");

        purchasePage.clickSignIn();
        purchasePage.takeScreenshot("Se muestra pantalla home");

        purchasePage.clickWomenMenu();
        purchasePage.clickTopsMenu();
        purchasePage.takeScreenshot("Se muestran los productos");

        purchasePage.clickLinkItem();
        purchasePage.takeScreenshot("Se muestra detalle del producto");

        purchasePage.selectColor();
        purchasePage.selectSize();

        purchasePage.clickAddToCart();
        purchasePage.takeScreenshot("Se muestra mensaje de producto agregado al carrito");

        purchasePage.clickLinkShoppingCart();
        purchasePage.takeScreenshot("Se muestra detalle del carrito");

        purchasePage.clickCheckout();
        purchasePage.takeScreenshot("Se muestra detalle del envío");

        purchasePage.clickNext();
        purchasePage.takeScreenshot("Se muestra detalle de pago");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        purchasePage.clickPlaceOrder();
        assertTrue(purchasePage.getPurchaseMessage().equals("Thank you for your purchase!"));
        test.log(Status.PASS, "Se realiza la compra correctamente");
        purchasePage.takeScreenshot("Se muestra mensaje exitoso");
    }

    @AfterEach
    public void closeTest(){
        PurchasePage purchasePage = new PurchasePage(driver, wait);
        purchasePage.close();
    }

    @AfterAll
    public static void report(){
        extent.flush();
    }
}
