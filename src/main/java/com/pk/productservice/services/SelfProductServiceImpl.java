package com.pk.productservice.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.productservice.dto.ProductDto;
import com.pk.productservice.exception.ProductNotFoundException;
import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;
import com.pk.productservice.repository.CategoryRepository;
import com.pk.productservice.repository.ProductRepository;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements IProductServices {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Product getSingleProduct(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if (!product.isPresent()) {
			throw new ProductNotFoundException("PRODUCT NOT FOUND WITH ID:" + id, "PRODUCT_NOT_FOUND");

		}
		return product.get();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = productRepo.findAll();
		return allProducts;
	}

	@Override
	public List<Product> getLimitedProducts(Long limit) {
		List<Product>productsList=new ArrayList<>();

     //   List<Product> selfProduct= ((ProductRepository) productRepo).findLimitedProduct(limit);
        		return  productsList;
	}

	@Override
	public List<Product> getSortedProducts(String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addNewProduct(ProductDto product) {
		Categories categories = product.getCategory();
		Product p = new Product();
		if (categories.getId() != null) {
			
			// Due to CAsceding no need to specifically save it to Category
			/*
			 * categories.setCreatedAt(Instant.now());
			 * p.setCategories(categoryRepo.save(categories)); 
			 */
		}

		p.setCreatedAt(Instant.now());
		p.setDescription(product.getDescription());
		p.setImageUrl(product.getImageUrl());
		p.setPrice(product.getPrice());
		p.setTitle(product.getTitle());
		p.setCategories(categories);

		return productRepo.save(p);
	}

	@Override
	public Product updateProduct(Long id, ProductDto products) {
		Optional<Product> p = productRepo.findById(id);
		if (p.isPresent()) {
			p.get().setCategories(products.getCategory());
			p.get().setLastUpdatedAt(Instant.now());
			p.get().setDescription(products.getDescription());
			p.get().setImageUrl(products.getImageUrl());
			p.get().setPrice(products.getPrice());
			p.get().setTitle(products.getTitle());
		} else
			throw new ProductNotFoundException("Product with id :::->" + id + " Not Found", "PRODUCT_noT_FOUND");
		return productRepo.save(p.get());
	}

	@Override
	public Product patchProduct(Long id, ProductDto products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
