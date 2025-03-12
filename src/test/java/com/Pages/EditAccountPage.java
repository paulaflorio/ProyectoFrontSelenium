package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccountPage extends BasePage {
    private By linkSignIn = By.linkText("Sign In");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("pass");
    private By btnSignIn = By.xpath("//span[text()='Sign In']");
    private By dropdowMenu = By.xpath("//button[contains(@data-action, 'customer-menu-toggle')]");
    private By linkMyAccount = By.linkText("My Account");
    private By linkManageAddress = By.linkText("Manage Addresses");
    private By inputPhone = By.id("telephone");
    private By inputAddress = By.id("street_1");
    private By inputCity = By.id("city");
    private By selectState = By.id("region_id");
    private By state = By.xpath("//option[@value='1']");
    private By inputZip = By.id("zip");
    private By selectCountry = By.id("country");
    private By country = By.xpath("//option[@value='AL']");
    private By btnSave = By.xpath("//span[text()='Save Address']");
    private By savedAddressMessage = By.xpath("//div[contains(@class, 'message-success')]");

    public EditAccountPage(WebDriver driver, WebDriverWait wait){
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

    public void clickDropdownMenu(){
        this.clickElement(dropdowMenu);
    }

    public void clickLinkMyAccount(){
        this.clickElement(linkMyAccount);
    }

    public void clickLinkManageAddress(){
        this.clickElement(linkManageAddress);
    }

    public void setPhone(String phone){
        sendText(phone, inputPhone);
    }

    public void setAddress(String address){
        sendText(address, inputAddress);
    }

    public void setCity(String city){
        sendText(city, inputCity);
    }

    public void setState(){
        this.clickElement(selectState);
        this.clickElement(state);
    }

    public void setZip(String zip){
        sendText(zip, inputZip);
    }

    public void setCountry(){
        this.clickElement(selectCountry);
        this.clickElement(country);
    }

    public void clickSave(){
        this.clickElement(btnSave);
    }

    public String getSavedMessage(){
        System.out.println("Mensaje: " + this.getText(savedAddressMessage));
        return this.getText(savedAddressMessage);
    }
}
