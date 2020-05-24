package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.example.demo.entiy.Product;
import com.example.demo.entiy.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
/*
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnsuportActions = { HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };

		// DISABLE HTTP METHODS FOR PRODUCTS: POST PUT DELETE
		config.getExposureConfiguration().forDomainType(Product.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportActions));

		// DISABLE HTTP METHODS FOR PRODUCTS: POST PUT DELETE
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportActions));

	}*/

}
