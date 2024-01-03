package com.pk.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private double price;
    private String title;
    private Categories categories;
    private String description;
    private String imageUrl;
}
