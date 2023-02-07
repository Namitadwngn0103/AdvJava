package com.app.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Products;
import com.app.repository.ProductsRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository prodRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init" + mapper);
	}
	
	@Override
	public List<Products> getAllProductsDetails() {
		return prodRepo.findAll();
	}
	
	@Override
	public Products addProdDetails(Products transientProd )
	{
		return prodRepo.save(transientProd);
	}
	
	@Override
	public String deleteProdDetails(Long prodId)
	{
		if(prodRepo.existsById(prodId))
		{
			prodRepo.deleteById(prodId);
			return "Product details deleted";
		}
		return "Deletion failed: Invalid Product Id";
	}
	
	@Override
	public Products fetchProdDetails(Long ProdId)
	{
		return prodRepo.findById(ProdId).orElseThrow(()->new ResourceNotFoundException("Invalid Prod id"));
	}
	
	@Override
	public Products updateProdDetails(Products detachedProd)
	{
		if(prodRepo.existsById(detachedProd.getId())) {
			return prodRepo.save(detachedProd) ;
		}
		throw new ResourceNotFoundException("Invalid ProdId: updation failed");
	}

	@Override
	public Products authenticateProducts(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
