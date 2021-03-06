package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entiy.ProductCategory;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://app-ecommerce-480f0.firebaseapp.com")
@RepositoryRestResource(collectionResourceRel="productCategory",path="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long>{

}
