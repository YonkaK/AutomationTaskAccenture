package com.automation.practice.data;

import com.automation.practice.model.Item;
import com.automation.practice.model.Product;
import com.automation.practice.model.ShoppingCart;

public class DataProducer {

    public static ShoppingCart generateDefaultShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product1 = Product.builder()
                .colour("White")
                .name("Printed Summer Dress")
                .singlePrice(30.5)
                .size("M")
                .build();

        Item item1 = Item.builder()
                .quantity(3)
                .product(product1)
                .build();

        shoppingCart.addItem(item1);

        return shoppingCart;
    }
}
