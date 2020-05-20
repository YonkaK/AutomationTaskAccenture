package com.automation.practice.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement ShoppingCartView;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isLogoPresent(){
        logo.isDisplayed();
    }

    public WebElement getShoppingCartView() {
        return ShoppingCartView;
    }

   public void hover(WebDriver driver, WebElement element){
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click(element).perform();
    }

    public void goToPageUp(){
        Actions goUp = new Actions(driver);
        goUp.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
    }

}

