package com.automation.practice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsOverlay {
    private WebDriver driver;

    @FindBy(css = ".cross")
    private WebElement closeButton;

    public ItemsOverlay(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }

    public void CloseButtonClick(){
        closeButton.click();
    }
}
