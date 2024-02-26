package com.pk.productservice.controllers;

import com.pk.productservice.dto.ProductDto;
import com.pk.productservice.models.Product;
import com.pk.productservice.services.FakeStoreProductServiceImpl;
import com.pk.productservice.services.IProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier(value="selfProductServiceImpl")
	private IProductServices iProductService;

	/*
	 * @Autowired public ProductController(@Qualifier("selfProductServiceImpl")
	 * IProductServices iProductService) { this.iProductService = iProductService; }
	 */

	@GetMapping()
	public List<Product> getAllProducts() {
		return iProductService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable("id") Long id) {
		return iProductService.getSingleProduct(id);
	}

	@GetMapping("/limited")
	public List<Product> getLimitedProducts(@RequestParam("limit") String limit) {
		Long limitNum = Long.parseLong(limit);
		return iProductService.getLimitedProducts(limitNum);
	}

	@GetMapping("/sorted")
	public List<Product> getSortedProducts(@RequestParam("sort") String sort) {

		return iProductService.getSortedProducts(sort);
	}

	@PostMapping()
	public Product addNewProduct(@RequestBody ProductDto product) {
		return iProductService.addNewProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto products) {
		return iProductService.updateProduct(id, products);
	}

	@PatchMapping("/{id}")
	public Product patchProduct(@PathVariable("id") Long id, @RequestBody ProductDto products) {
		return iProductService.patchProduct(id, products);
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable("id") Long id) {
		return iProductService.deleteProduct(id);
	}

}
