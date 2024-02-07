package com.pk.productservice.services;

import com.pk.productservice.dto.FakeStoreProductDTO;
import com.pk.productservice.models.Product;
import java.util.List;

public interface IProductServices {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();

    List<Product> getLimitedProducts(Long limit);

    List<Product> getSortedProducts(String sort);

    Product addNewProduct(FakeStoreProductDTO product);

    Product updateProduct(Long id, FakeStoreProductDTO products);

    Product patchProduct(Long id, FakeStoreProductDTO products);

    Product deleteProduct(Long id);
}
