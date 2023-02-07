package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	
	@Column(name="category_name",length=30,unique=true)
	private String categoryName;
	
	@Column(length=300)
	private String discription;
	
	@OneToMany(mappedBy="productCategory", cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Products> products=new ArrayList<>();
	
	public Category() {
		super();
	}

	public Category(String categoryName, String discription) {
		super();
		this.categoryName = categoryName;
		this.discription = discription;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category ID"+getId()+"[categoryName=" + categoryName + ", discription=" + discription + ", products=" + products
				+ "]";
	}
	
	public void addProducts(Products p)
	{
		products.add(p);
		p.setProductCategory(this);
	}
	
	public void removeProducts(Products p)
	{
		products.remove(p);
		p.setProductCategory(null);
	}
	
	
	

}
