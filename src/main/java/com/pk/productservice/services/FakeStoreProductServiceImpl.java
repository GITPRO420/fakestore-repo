package com.pk.productservice.services;

import com.pk.productservice.dto.FakeStoreProductDTO;
import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements IProductServices {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
       FakeStoreProductDTO productDTO= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
       return fakeStoreProductToProductObject(productDTO);
    }

    @Override
    public List<Product> getAllProducts() {
      //  FakeStoreProductDTO productDTO=new FakeStoreProductDTO();
        List<Product>productsList=new ArrayList<>();

        List<FakeStoreProductDTO> fakeStoreProductList= List.of(restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class));
        fakeStoreProductList.forEach(e->{
           productsList.add(fakeStoreProductToProductObject(e));

        });

return  productsList;

    }

    @Override
    public List<Product> getLimitedProducts(Long limit) {
        List<Product>productsList=new ArrayList<>();

        List<FakeStoreProductDTO> fakeStoreProductList= List.of(restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class)).stream().limit(limit).toList();
        fakeStoreProductList.forEach(e->{
            productsList.add(fakeStoreProductToProductObject(e));

        });

        return  productsList;

    }

    @Override
    public List<Product> getSortedProducts(String sort) {
        List<Product>productsList=new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductList;
        if(sort.equalsIgnoreCase("desc"))
        {
             fakeStoreProductList= List.of(
                            restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class))
                    .stream().sorted(Comparator.comparingLong(FakeStoreProductDTO::getId).reversed()).toList();
        }else {
            fakeStoreProductList = List.of(
                    restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class));
        }
        fakeStoreProductList.forEach(e->{
            productsList.add(fakeStoreProductToProductObject(e));

        });

        return  productsList;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDTO product) {
        product=restTemplate.postForObject("https://fakestoreapi.com/products",product,FakeStoreProductDTO.class);
        return fakeStoreProductToProductObject(product);
    }

    @Override
    public Product updateProduct(Long id, FakeStoreProductDTO product) {
        restTemplate.put("https://fakestoreapi.com/products/"+id,product,FakeStoreProductDTO.class);
        return  fakeStoreProductToProductObject(product);
    }

    @Override
    public Product patchProduct(Long id, FakeStoreProductDTO product) {
        product=restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,product,FakeStoreProductDTO.class);
        return  fakeStoreProductToProductObject(product);
    }

    public Product fakeStoreProductToProductObject(FakeStoreProductDTO fakeStoreProduct){
        Product product=new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setId(fakeStoreProduct.getId());
        product.setCategories(new Categories());
        product.getCategories().setName(fakeStoreProduct.getCategory());
        return product;
    }
}
