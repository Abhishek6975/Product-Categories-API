package com.procatapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.procatapi.Entity.Categories;
import com.procatapi.Entity.Product;
import com.procatapi.Exceptions.ResourceNotFoundException;
import com.procatapi.payload.CategoryDto;
import com.procatapi.payload.ProductDto;
import com.procatapi.payload.ProductResponse;
import com.procatapi.repository.CategoryRepo;
import com.procatapi.repository.ProductRepo;

@Service
public class ProductServices {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	public ProductDto createProduct(ProductDto productdto, int catId) {
		// fetch Category Available or not
		Categories categories = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Id " + catId + " Not Found!"));

		// productDto -> product
		Product toProduct = ProductDtoToProduct(productdto);
		toProduct.setCatergories(categories);

		Product save = productRepo.save(toProduct);

		// Product -> ProductDto
		ProductDto toProductDto = ProductToProductDto(save);

		return toProductDto;
	}

	public ProductResponse viewAllProduct(Integer pageNumber, Integer pageSize, String sortBy) {

		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

		Page<Product> pageProduct = productRepo.findAll(p);
		List<Product> allProduct = pageProduct.getContent();

		List<ProductDto> productallDto = allProduct.stream().map(product -> this.ProductToProductDto(product))
				.collect(Collectors.toList());

		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productallDto);
		productResponse.setPageNumber(pageProduct.getNumber());
		productResponse.setPageSize(pageProduct.getSize());
		productResponse.setTotalElements(pageProduct.getTotalElements());
		productResponse.setTotalPages(pageProduct.getTotalPages());
		productResponse.setLastPage(pageProduct.isLast());

		return productResponse;

		// old implementation of get all product view
//		List<Product> findall = productRepo.findAll();
//
//		List<ProductDto> findallDto = findall.stream().map(product -> this.ProductToProductDto(product))
//				.collect(Collectors.toList());
//		return findallDto;
	}

	public ProductDto ProductById(int pid) {
		Product productId = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id " + pid + " Not Found!"));
		ProductDto productDto = this.ProductToProductDto(productId);
		return productDto;
	}

	public void DeleteProduct(int pid) {
		Product productId = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id is Not Available in list"));
		productRepo.delete(productId);
	}

	// Product Update
	public ProductDto productUpdateById(int pid, ProductDto productdto) {
		Product oldProduct = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id " + pid + " Not Found!"));
		oldProduct.setProduct_name(productdto.getProduct_name());
		oldProduct.setProduct_prize(productdto.getProduct_prize());
		oldProduct.setProduct_quantity(productdto.getProduct_quantity());
		oldProduct.setStock(productdto.isStock());
		Product save = productRepo.save(oldProduct);
		ProductDto updatedDto = ProductToProductDto(save);
		return updatedDto;
	}

//	ProductDto -> Product
	public Product ProductDtoToProduct(ProductDto productdto) {
		Product product = new Product();
		product.setProductId(productdto.getProductId());
		product.setProduct_name(productdto.getProduct_name());
		product.setProduct_prize(productdto.getProduct_prize());
		product.setProduct_quantity(productdto.getProduct_quantity());
		product.setStock(product.isStock());

		return product;
	}

//	Product -> ProductDto
	public ProductDto ProductToProductDto(Product product) {

		ProductDto dto = new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setProduct_name(product.getProduct_name());
		dto.setProduct_prize(product.getProduct_prize());
		dto.setProduct_quantity(product.getProduct_quantity());
		dto.setStock(product.isStock());

		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategories_id(product.getCatergories().getCategories_id());
		categoryDto.setCategory_name(product.getCatergories().getCategory_name());

		dto.setCategory(categoryDto);

		return dto;
	}
}
