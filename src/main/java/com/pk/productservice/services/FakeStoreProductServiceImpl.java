package com.pk.productservice.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.pk.productservice.dto.ProductDto;
import com.pk.productservice.exception.ProductNotFoundException;
import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements IProductServices {

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
       ProductDto productDTO= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
       if(productDTO==null)
    	   throw new ProductNotFoundException("PRODUCT NOT FOUND WITH ID::"+id,"PRODUCT_NOT_FOUND");
       return fakeStoreProductToProductObject(productDTO);
    }

    @Override
    public List<Product> getAllProducts() {
      //  FakeStoreProductDTO productDTO=new FakeStoreProductDTO();
        List<Product>productsList=new ArrayList<>();

        List<ProductDto> fakeStoreProductList= List.of(restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class));
        fakeStoreProductList.forEach(e->{
           productsList.add(fakeStoreProductToProductObject(e));

        });

return  productsList;

    }

    @Override
    public List<Product> getLimitedProducts(Long limit) {
        List<Product>productsList=new ArrayList<>();

        List<ProductDto> fakeStoreProductList= List.of(restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class)).stream().limit(limit).toList();
        fakeStoreProductList.forEach(e->{
            productsList.add(fakeStoreProductToProductObject(e));

        });

        return  productsList;

    }

    @Override
    public List<Product> getSortedProducts(String sort) {
        List<Product>productsList=new ArrayList<>();
        List<ProductDto> fakeStoreProductList;
        if(sort.equalsIgnoreCase("desc"))
        {
             fakeStoreProductList= List.of(
                            restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class))
                    .stream().sorted(Comparator.comparingLong(ProductDto::getId).reversed()).toList();
        }else {
            fakeStoreProductList = List.of(
                    restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class));
        }
        fakeStoreProductList.forEach(e->{
            productsList.add(fakeStoreProductToProductObject(e));

        });

        return  productsList;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        product=restTemplate.postForObject("https://fakestoreapi.com/products",product,ProductDto.class);
        return fakeStoreProductToProductObject(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDto product) {
       RequestCallback requestCallback= restTemplate.httpEntityCallback(product,ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor=new HttpMessageConverterExtractor<>(ProductDto.class,restTemplate.getMessageConverters());
        ProductDto res=restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,requestCallback,responseExtractor);
        return  fakeStoreProductToProductObject(res);
    }

    @Override
    public Product patchProduct(Long id, ProductDto product) {

        RequestCallback requestCallback= restTemplate.httpEntityCallback(product,ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor=new HttpMessageConverterExtractor<>(ProductDto.class,restTemplate.getMessageConverters());
        ProductDto res=restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,requestCallback,responseExtractor);
        return  fakeStoreProductToProductObject(res);
    }

    @Override
    public Product deleteProduct(Long id) {
        ProductDto productDto=new ProductDto();
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        ProductDto productDTO= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
        return fakeStoreProductToProductObject(productDTO);
    }

    public Product fakeStoreProductToProductObject(ProductDto fakeStoreProduct){
        Product product=new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImageUrl());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setId(fakeStoreProduct.getId());
        product.setCategories(new Categories());
        product.getCategories().setName(fakeStoreProduct.getCategory().getName());
        return product;
    }
}
