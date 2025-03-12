package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage extends BasePage {
    private By linkSignIn = By.linkText("Sign In");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("pass");
    private By btnSignIn = By.xpath("//span[text()='Sign In']");
    private By womenMenu = By.xpath("//span[text()='Women']");
    private By topsMenu = By.xpath("//a[text()='Tops']");
    private By linkItem = By.xpath("(//div[contains(@class, 'product-item-info')])[1]");
    private By sizeItem = By.id("option-label-size-143-item-166");
    private By colorItem = By.id("option-label-color-93-item-57");
    private By btnAddToCart = By.id("product-addtocart-button");
    private By linkShoppingcart = By.linkText("shopping cart");
    private By btnCheckout = By.xpath("//button[contains(@data-role, 'proceed-to-checkout')]");
    private By btnNext = By.xpath("//span[text()='Next']");
    private By btnPlaceOrder = By.xpath("//button[contains(@class, 'checkout')]");
    private By purchaseMessage = By.xpath("//span[text()='Thank you for your purchase!']");

    public PurchasePage(WebDriver driver, WebDriverWait wait){
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

    public void clickWomenMenu(){
        this.clickElement(womenMenu);
    }

    public void clickTopsMenu(){
        this.clickElement(topsMenu);
    }

    public void clickLinkItem(){
        this.clickElement(linkItem);
    }

    public void selectSize(){
        this.clickElement(sizeItem);
    }

    public void selectColor(){
        this.clickElement(colorItem);
    }

    public void clickAddToCart(){
        this.clickElement(btnAddToCart);
    }

    public void clickLinkShoppingCart(){
        this.clickElement(linkShoppingcart);
    }

    public void clickCheckout(){
        this.clickElement(btnCheckout);
    }

    public void clickNext(){
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        this.clickElement(btnNext);
    }

    public void clickPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder));
        this.clickElement(btnPlaceOrder);
    }

    public String getPurchaseMessage(){
        System.out.println("Mensaje: " + this.getText(purchaseMessage));
        return this.getText(purchaseMessage);
    }

}
