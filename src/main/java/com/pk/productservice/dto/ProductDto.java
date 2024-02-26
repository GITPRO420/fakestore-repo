package com.pk.productservice.dto;

import com.pk.productservice.models.Categories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private Categories category;
    private Double price;
    private String description;
    private String imageUrl;
}
