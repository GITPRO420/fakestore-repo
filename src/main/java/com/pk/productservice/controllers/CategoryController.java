package com.pk.productservice.controllers;

import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;
import com.pk.productservice.services.ICatagoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private ICatagoryServices iCatagoryServices;
    @Autowired
    public CategoryController(ICatagoryServices iCatagoryServices){
        this.iCatagoryServices=iCatagoryServices;
    }

    @GetMapping()
    public List<Categories> getAllCategories(){
        return iCatagoryServices.getAllCategories();
    }
    @GetMapping("/{category}")
    public List<Product> getSpecificCategory(@PathVariable("category") String category){
        return iCatagoryServices.getSpecificCategory(category);
    }


}
