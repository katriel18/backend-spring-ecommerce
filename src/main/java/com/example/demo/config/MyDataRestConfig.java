package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.example.demo.entiy.Product;
import com.example.demo.entiy.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	

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
		
		//LLAMANDO AL METODO QUE EXPONGA LAS IDS
		exposeIds(config);
	}


	private void exposeIds(RepositoryRestConfiguration config) {

		//OBTENGO UNA COLECCION DE TODAS LAS CLASES DE ENTIDAD DEL ADMINISTRADOR DE ENTIDADES
		Set<EntityType<?>> entities=entityManager.getMetamodel().getEntities();
		
		//SE CREA UN ARRAY LIST PARA LOS TIPOS DE ENTIDAD
		List<Class<?>> entityClasses=new ArrayList<>();
		
		//OBTENGO LOS TIPOS DE ENTIDAD PARA LAS ENTIDADES
		for(EntityType<?> e:entities ) {
			
			entityClasses.add(e.getJavaType());
		}
		
		//EXPONGO LOS IDS PARA LOS TIPOS DE ENTIDAD DE DOMINIO
		Class<?>[] domainTypes=entityClasses.toArray(new Class[0]);
		
		config.exposeIdsFor(domainTypes);
		
	}
	

	//git pull	//BAJA LAS MODIFICACIONES  REMOTAS DE GIT HUB A TU REPOSITORIO LOCAL
	// git push origin master	//SUBE TUS MODIFICACIONES LOCALES AL GIT HUB
	
}
