package com.procatapi.payload;

import java.util.List;

public class ProductResponse {

	private List<ProductDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;

	private boolean lastPage;

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(List<ProductDto> content, int pageNumber, int pageSize, long totalElements, int totalPages,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}

	public List<ProductDto> getContent() {
		return content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setContent(List<ProductDto> content) {
		this.content = content;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}