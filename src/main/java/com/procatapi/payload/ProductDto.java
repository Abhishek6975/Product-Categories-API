package com.procatapi.payload;

public class ProductDto {

	private int productId;
	private String product_name;
	private double product_prize;
	private boolean stock;
	private int product_quantity;

	private CategoryDto category;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int productId, String product_name, double product_prize, boolean stock, int product_quantity,
			CategoryDto category) {
		super();
		this.productId = productId;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.stock = stock;
		this.product_quantity = product_quantity;
		this.category = category;
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

	public CategoryDto getCategory() {
		return category;
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

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

}
