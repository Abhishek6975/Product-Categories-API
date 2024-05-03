package com.procatapi.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;  // productId to product_id the Reason for making this Because At the time of
							// Pagination sortBy, product_id underscore not detected in Url that's Reason
							// Make this like of structure.
							// (http://localhost:8080/product/view?pageNumber=0&pageSize=10&sortBy=product_id)
							// not detect by url
							// http://localhost:8080/product/view?pageNumber=0&pageSize=10&sortBy=productId)
							// detected and fetch data from database
	private String product_name;
	private double product_prize;
	private boolean stock;
	private int product_quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Categories catergories;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String product_name, double product_prize, boolean stock, int product_quantity,
			Categories catergories) {
		super();
		this.productId = productId;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.stock = stock;
		this.product_quantity = product_quantity;
		this.catergories = catergories;
	}

	public Product(int product_id, String product_name, double product_prize, boolean stock, int product_quantity) {
		super();
		this.productId = product_id;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.stock = stock;
		this.product_quantity = product_quantity;
	}

	public int getProductId() {
		return productId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public double getProduct_prize() {
		return product_prize;
	}

	public boolean isStock() {
		return stock;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public Categories getCatergories() {
		return catergories;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public void setCatergories(Categories catergories) {
		this.catergories = catergories;
	}

}
