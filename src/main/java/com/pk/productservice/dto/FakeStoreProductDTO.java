package com.pk.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String category;
    private Double price;
    private String description;
    private String image;
}
