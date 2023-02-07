package com.app.service;

import java.util.List;

import com.app.dto.LoginRequestDto;
import com.app.pojos.Products;
import com.app.pojos.Products;

public interface ProductsService {

	List<Products> getAllProductsDetails();

	Products addProdDetails(Products transientProd);

	String deleteProdDetails(Long prodId);

	Products fetchProdDetails(Long ProdId);

	Products updateProdDetails(Products detachedProd);

	Products authenticateProducts(LoginRequestDto dto);


}
