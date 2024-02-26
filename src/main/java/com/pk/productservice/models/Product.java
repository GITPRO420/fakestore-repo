package com.pk.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Product extends BaseModel {

	private double price;
	private String title;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Categories categories;
	private String description;
	private String imageUrl;
}
