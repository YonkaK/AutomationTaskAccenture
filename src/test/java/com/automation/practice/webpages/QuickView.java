package com.automation.practice.webpages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


@Getter
public class QuickView {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "(//img[@itemprop='image'])[2]")
    private WebElement printedSummerDress;

    @FindBy(how = How.XPATH, using = "(//a[@class='quick-view']//span)[2]")
    private WebElement quickViewButton;

    @FindBy(how = How.XPATH, using = "//iframe[@class='fancybox-iframe']")
    private WebElement quickView;

    @FindBy(id = "quantity_wanted")
    private WebElement selectQuantity;

    @FindBy(css = "a#color_8")
    private WebElement pickColour;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartButton;

    public QuickView(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSelectQuantity(){
        selectQuantity.clear();
        selectQuantity.sendKeys("3");
    }

    public void setPickColor(){
        pickColour.click();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick){
        Actions hoverAndClick = new Actions(driver);
        hoverAndClick.moveToElement(elementToHover).click(elementToClick).build().perform();
    }


}
