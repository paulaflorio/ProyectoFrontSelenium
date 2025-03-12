package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    private By linkCreateAccount = By.linkText("Create an Account");
    private By inputFirstName = By.id("firstname");
    private By inputLastName = By.id("lastname");
    private By inputEmail = By.id("email_address");
    private By inputPassword = By.id("password");
    private By inputConfirmPassword = By.id("password-confirmation");
    private By btnCreateAccount = By.xpath("//span[text()='Create an Account']");
    private By registeredMessage = By.xpath("//div[contains(@class, 'message-success')]");

    public RegisterPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickLinkCreateAccount() throws InterruptedException{
        this.clickElement(linkCreateAccount);
    }

    public void setFirstName(String name) throws InterruptedException{
        sendText(name, inputFirstName);
    }

    public  void setLastName(String lastname) throws InterruptedException{
        sendText(lastname, inputLastName);
    }

    public void setEmail(String email) throws InterruptedException{
        sendText(email, inputEmail);
    }

    public void setPassword(String password) throws InterruptedException{
        sendText(password, inputPassword);
    }

    public void setConfirmPassword(String password) throws InterruptedException{
        sendText(password, inputConfirmPassword);
    }

    public void clickCreateAccount() throws InterruptedException{
        this.clickElement(btnCreateAccount);
    }

    public String getRegisteredMessage(){
        System.out.println("Mensaje: " + this.getText(registeredMessage));
        return this.getText(registeredMessage);
    }
}
