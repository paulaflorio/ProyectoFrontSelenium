package com.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void open(String url){
        driver.get(url);
    }

    public void configureBrowser(){
        driver.manage().window().maximize();
    }

    public WebElement findElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void sendText(String text, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void sendKey(CharSequence key, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).sendKeys(key);
    }

    public void clickElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getText(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void close(){
        driver.quit();
    }

    public void takeScreenshot(String filename) {
        String evidenceDir = "target/evidence";
        File dir = new File(evidenceDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();

        File testDir = new File(evidenceDir + "/" + testName);
        if (!testDir.exists()) {
            testDir.mkdirs();
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshot.toPath(), Paths.get(testDir.getPath(), filename + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
