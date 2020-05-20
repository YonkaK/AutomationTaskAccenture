package com.automation.practice.tests;

import com.automation.practice.data.DataProducer;
import com.automation.practice.model.ShoppingCart;
import com.automation.practice.webpages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AddToCartTest {

    private WebDriver driver;
    private final String PAGE_URL = "http://automationpractice.com/index.php";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Yoni/Projects/AutomationTaskAccenture/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void testAddToCart() {

        // Given - conditions
        ShoppingCart shoppingCart = DataProducer.generateDefaultShoppingCart();

        HomePage home = new HomePage(driver);
        SummerDresses selectDress = new SummerDresses(driver);
        QuickView selectProduct = new QuickView(driver);
        ItemsOverlay closeOverlay = new ItemsOverlay(driver);
        BasketContent content = new BasketContent(driver);

        // When

        //Validate the logo
        home.isLogoPresent();

        selectDress.hoverAndClick(driver, selectDress.getCategoryWomen(), selectDress.getSummerDressCategory());

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        selectProduct.hoverAndClick(driver, selectProduct.getPrintedSummerDress(),selectProduct.getQuickViewButton());


        // Switch to iframe of product detail
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='fancybox-iframe']")));

        driver.switchTo().defaultContent();

        int framesOnPage = driver.findElements(By.tagName("iframe")).size();

        System.out.println("Frames in the page are "+ framesOnPage);

        driver.switchTo().frame(0);

        selectProduct.setSelectQuantity();

        selectProduct.setPickColor();

        WebElement selectSizedropdown = driver.findElement(By.xpath("//select[@id='group_1']"));
        Select selectSize = new Select(selectSizedropdown);
        selectSize.selectByValue("2");

        selectProduct.clickAddToCartButton();

        WebDriverWait waitAgain = new WebDriverWait(driver, 10);
        waitAgain.until(ExpectedConditions.presenceOfElementLocated(By.className("icon-ok")));

        closeOverlay.CloseButtonClick();

        //Switch back to default content
        driver.switchTo().defaultContent();

        home.goToPageUp();
        home.hover(driver, home.getShoppingCartView());

        ShoppingCart shoppingCartFromFlow = content.getShoppingCartData();

        // Then
        assertNotNull(shoppingCartFromFlow);
        assertEquals(shoppingCart, shoppingCartFromFlow);
    }

    @After
    public void close(){
        driver.quit();
    }
}