package com.pk.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pk.productservice.models.Categories;
import com.pk.productservice.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdAndCategoriesOrderByTitle(Long id, Categories categories);
	
	@Query(value="select * from Product p order by id limit ?1", nativeQuery=true)
    public List<Product> findLimitedProduct(Long limit );

	

	/*
	 * @Query("select p from Product p LIMIT ?limit") List<Product>
	 * findLimitedProduct(@Param("limit") Long limit);
	 */
}
