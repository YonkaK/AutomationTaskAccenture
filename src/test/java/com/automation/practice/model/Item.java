package com.automation.practice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private int quantity;
    private Product product;
}
