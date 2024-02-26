package com.pk.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.productservice.models.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

	Categories findByName(String name);

}
