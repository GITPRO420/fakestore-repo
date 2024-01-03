package com.pk.productservice.services;

import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;

import java.util.List;

public interface ICatagoryServices {
    List<Categories> getAllCategories();

    List<Product> getSpecificCategory(String category);
}
