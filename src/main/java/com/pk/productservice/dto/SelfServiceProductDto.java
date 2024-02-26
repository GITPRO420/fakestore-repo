package com.pk.productservice.dto;

import com.pk.productservice.models.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfServiceProductDto {
	private double price;
	private String title;
	private Categories categories;
	private String description;
	private String imageUrl;

}
