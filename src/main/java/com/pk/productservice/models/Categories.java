package com.pk.productservice.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categories extends BaseModel {

	private String name;
	@OneToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
	List<Product>products;
}
