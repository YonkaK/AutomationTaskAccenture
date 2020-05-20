package com.automation.practice.webpages;

import com.automation.practice.model.Item;
import com.automation.practice.model.Product;
import com.automation.practice.model.ShoppingCart;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class BasketContent {
    private WebDriver driver;

    @FindBy(css = ".quantity-formated .quantity")
    private WebElement quantity;

    @FindBy(className = "cart_block_product_name")
    private WebElement productName;

    @FindBy(className = "product-atributes")
    private WebElement productAtributes;

    @FindBy(className = "price")
    private WebElement price;


    @FindBy(xpath = "//span[contains(@class,'price cart_block_total')]")
    private WebElement totalPrice;

    public BasketContent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShoppingCart getShoppingCartData(){

        // Get data from UI

        // Quantity
        String quantityText = getQuantity().getText();
        Integer quantityValue = Integer.parseInt(quantityText);

        // Product name
        String productNameTitle = productName.getAttribute("title");

        //Product colour
        String productAttributesValue = getProductAtributes().getText();
        String[] productAttributes = productAttributesValue.split(",");

        String colourProduct = productAttributes[0].trim();

        //Product size
        String selectedSizeValue = productAttributes[1].trim();

        //Product price
        String priceText = getPrice().getText().substring(1);
        double price = Double.valueOf(priceText);
        price = price / quantityValue;

        // Populate shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = Product.builder()
                .colour(colourProduct)
                .name(productNameTitle)
                .size(selectedSizeValue)
                .singlePrice(price)
                .build();

        Item item = Item.builder()
                .quantity(quantityValue)
                .product(product)
                .build();

        shoppingCart.addItem(item);

        return shoppingCart;

    }
}
