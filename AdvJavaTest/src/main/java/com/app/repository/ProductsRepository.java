package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;
import com.app.pojos.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
	List<Products> findByProductName(String name);
	Optional<Products> findById(Long id);
	Optional<Products> findByProductCategory(Category category);

}
