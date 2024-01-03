package com.pk.productservice.controllers;

import com.pk.productservice.dto.FakeStoreProductDTO;
import com.pk.productservice.models.Product;
import com.pk.productservice.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   private IProductServices iProductService;
    @Autowired
    public ProductController(IProductServices iProductService){
        this.iProductService=iProductService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return iProductService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product  getSingleProduct(@PathVariable("id") Long id){
        return iProductService.getSingleProduct(id);
    }

    @GetMapping("/limited")
    public List<Product> getLimitedProducts(@RequestParam("limit") String limit){
        Long limitNum=Long.parseLong(limit);
        return iProductService.getLimitedProducts(limitNum);
    }
    @GetMapping("/sorted")
    public List<Product> getSortedProducts(@RequestParam("sort") String sort){

        return iProductService.getSortedProducts(sort);
    }

    @PostMapping()
    public Product  addNewProduct(@RequestBody FakeStoreProductDTO product){
        return iProductService.addNewProduct(product);
    }

    @PutMapping("/{id}")
    public Product  updateProduct(@PathVariable("id") Long id, @RequestBody FakeStoreProductDTO  products){
        return iProductService.updateProduct(id,products);
    }
    @PatchMapping("/{id}")
    public Product  patchProduct(@PathVariable("id") Long id, @RequestBody FakeStoreProductDTO  products){
        return iProductService.patchProduct(id,products);
    }

}
