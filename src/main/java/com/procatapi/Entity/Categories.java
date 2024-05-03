package com.procatapi.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categories_id;
	private String category_name;
	
	@OneToMany(mappedBy="catergories",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Product> product;


	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Categories(int categories_id, String category_name, Set<Product> product) {
		super();
		this.categories_id = categories_id;
		this.category_name = category_name;
		this.product = product;
	}

	public Categories(int categories_id, String category_name) {
		super();
		this.categories_id = categories_id;
		this.category_name = category_name;
	}

	public int getCategories_id() {
		return categories_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

}
