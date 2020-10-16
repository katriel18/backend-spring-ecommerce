package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entiy.Product;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://app-ecommerce-480f0.firebaseapp.com")
public interface ProductRepository extends JpaRepository<Product,Long> {

	//https://ecommerce-20.herokuapp.com/api/products/search/findByCategoryId?id=2
	Page<Product> findByCategoryId(@RequestParam("id") Long id,Pageable pageable);
	
	//https://ecommerce-20.herokuapp.com/api/products/search/findByNameContaining?name=data
	Page<Product> findByNameContaining(@RequestParam("name") String name,Pageable pageable);
	
}
