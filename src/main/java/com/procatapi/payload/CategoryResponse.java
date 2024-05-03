package com.procatapi.payload;

import java.util.List;

public class CategoryResponse {

	private List<CategoryDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;

	private boolean lastPage;

	public CategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryResponse(List<CategoryDto> content, int pageNumber, int pageSize, long totalElements, int totalPages,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}

	public List<CategoryDto> getContent() {
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

	public void setContent(List<CategoryDto> content) {
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
