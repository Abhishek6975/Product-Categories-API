package com.procatapi.payload;

import java.util.List;

public class CategoryDto {
	private int categories_id;
	private String category_name;
	
	private List<ProductDto> products;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(int categories_id, String category_name, List<ProductDto> products) {
		super();
		this.categories_id = categories_id;
		this.category_name = category_name;
		this.products = products;
	}

	public int getCategories_id() {
		return categories_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	
	
	

	

}
