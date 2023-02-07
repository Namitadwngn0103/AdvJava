package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products extends BaseEntity{
	
	@Column(name="product_name",length=30, unique=true)
	private String productName;
	
	private double price;
	
	@Column(length=300)
	private String discription;
	
	@Column(name="in_stock")
	private boolean inStock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category productCategory;
	
	public Products() {
		super();
	}
	public Products(String productName, double price, String discription, boolean inStock) {
		super();
		this.productName = productName;
		this.price = price;
		this.discription = discription;
		this.inStock = inStock;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public Category getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "Products ID"+getId()+ "[productName=" + productName + ", price=" + price + ", discription=" + discription
				+ ", inStock=" + inStock + "]";
	}
	
	
	

}
