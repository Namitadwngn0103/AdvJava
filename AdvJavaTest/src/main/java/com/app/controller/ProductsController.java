package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginRequestDto;
import com.app.dto.prodSignupDto;
import com.app.pojos.Products;
import com.app.service.ProductsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService prodService;
	
	private ModelMapper mapper;
	
	public ProductsController()
	{
		System.out.println("in def ctor of"+getClass());
	}
	
	@GetMapping
	public List<Products> getallProducts() {
		System.out.println("in get all prod details");
		return prodService.getAllProductsDetails();
}
	
	@PostMapping("/{prodId}")
	public Products saveprodDetails(@RequestBody Products transientProd) {
		System.out.println("in save emp"+transientProd);
		return prodService.addProdDetails(transientProd);
}

	@DeleteMapping("/{prodId}")
	public ApiResponse deletProdDetails(@PathVariable Long ProdId)
	{
		System.out.println("in del prod"+ProdId);
		return new ApiResponse(prodService.deleteProdDetails(ProdId));
	}
	
	@GetMapping("/{prodId}")
	public Products getProdDetails(@PathVariable Long ProdId)
	{
		System.out.println("in get prod details"+ProdId);
		return prodService.fetchProdDetails(ProdId);
	}
	
	@PutMapping
	public Products updateProdDetails(@RequestBody Products detachedProd)
	{
		System.out.println("in update"+detachedProd);
		return prodService.updateProdDetails(detachedProd);
	}
	
		

		@PostMapping("/signin")
		public Products validateUser(@RequestBody LoginRequestDto dto){
			System.out.println("in emp signin "+dto);
			return prodService.authenticateProducts(dto);
		}
		
		@PostMapping("/signup")
		public Products saveProdDetails(@RequestBody prodSignupDto user){
			Products newUser = mapper.map(user, Products.class);
			return prodService.addProdDetails(newUser);	
		}
	}
	
	

