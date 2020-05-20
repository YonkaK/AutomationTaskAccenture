package com.automation.practice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String name;
    private String colour;
    private String size;
    private double singlePrice;
}
