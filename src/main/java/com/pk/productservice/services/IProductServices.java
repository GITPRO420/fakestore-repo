package com.pk.productservice.services;

import com.pk.productservice.dto.ProductDto;
import com.pk.productservice.models.Product;
import java.util.List;

public interface IProductServices {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();

    List<Product> getLimitedProducts(Long limit);

    List<Product> getSortedProducts(String sort);

    Product addNewProduct(ProductDto product);

    Product updateProduct(Long id, ProductDto products);

    Product patchProduct(Long id, ProductDto products);

    Product deleteProduct(Long id);
}
