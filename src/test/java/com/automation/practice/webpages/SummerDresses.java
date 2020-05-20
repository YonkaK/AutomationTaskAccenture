package com.automation.practice.webpages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SummerDresses {

    private WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "sf-with-ul")
    private WebElement categoryWomen;

    @FindBy(how = How.XPATH, using = "//a[@title='Summer Dresses']")
    private WebElement summerDressCategory;

    public SummerDresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick){
        Actions hoverAndClick = new Actions(driver);
        hoverAndClick.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

}
