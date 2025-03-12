package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By linkSignIn = By.linkText("Sign In");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("pass");
    private By btnSignIn = By.xpath("//span[text()='Sign In']");
    private By greetText = By.xpath("//span[contains(text(), 'Welcome,')]");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickLinkSignIn(){
        this.clickElement(linkSignIn);
    }

    public void setEmail(String email){
        sendText(email, inputEmail);
    }

    public void setPassword(String password){
        sendText(password, inputPassword);
    }

    public void clickSignIn(){
        this.clickElement(btnSignIn);
    }

    public String getGreet(){
        System.out.println("Mensaje: " + this.getText(greetText));
        return this.getText(greetText);
    }
}

