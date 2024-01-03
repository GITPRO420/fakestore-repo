package com.pk.productservice.services;

import com.pk.productservice.dto.FakeStoreProductDTO;
import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreCategoryServiceImpl implements ICatagoryServices {

    private RestTemplate restTemplate;
    @Autowired
    FakeStoreProductServiceImpl fakeStoreProductServiceImpl;

    @Autowired
    public FakeStoreCategoryServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public List<Categories> getAllCategories() {
        List<Categories> listCategories=new ArrayList<>();
        String[] fakeListCategories=restTemplate.getForObject("https://fakestoreapi.com/products/categories",String[].class);
        List<String>fakeCat= Arrays.stream(fakeListCategories).toList();
        fakeCat.forEach(e->{
            Categories c=new Categories();
            c.setName(e);
            listCategories.add(c);
        });
        return listCategories;
    }

    @Override
    public List<Product> getSpecificCategory(String category) {
       List<FakeStoreProductDTO> listFakeStoreCatDto=List.of(restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category,FakeStoreProductDTO[].class));
        List<Product>productList=new ArrayList<>();
        listFakeStoreCatDto.forEach(e->{
            productList.add(fakeStoreProductServiceImpl.fakeStoreProductToProductObject(e));
        });
        return productList;
    }
}
