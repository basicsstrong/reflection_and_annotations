package com.basicsstrong.spring;

public class Product {

	private String name;
	private Integer discount;
	private Double price;
	

	public Product(String name, Integer discount) {
		super();
		this.name = name;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", discount=" + discount + ", price=" + price + "]";
	}
	
	

}
