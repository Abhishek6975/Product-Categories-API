package com.procatapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.procatapi.Entity.Categories;
import com.procatapi.Entity.Product;
import com.procatapi.Exceptions.ResourceNotFoundException;
import com.procatapi.payload.CategoryDto;
import com.procatapi.payload.CategoryResponse;
import com.procatapi.payload.ProductDto;
import com.procatapi.payload.ProductResponse;
import com.procatapi.repository.CategoryRepo;
import com.procatapi.repository.ProductRepo;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	public CategoryDto createCategory(CategoryDto catDto) {
		Categories toCategory = CategoryDtoToCategory(catDto);
		Categories save = categoryRepo.save(toCategory);

		CategoryDto toCategoryDto = CategoryTOCategoryDto(save);

		return toCategoryDto;
	}

	public CategoryDto UpdateCategory(CategoryDto catDto, int catId) {
		Categories categories = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Id " + catId + " Not Found!"));
		categories.setCategory_name(catDto.getCategory_name());
		Categories save = categoryRepo.save(categories);
		CategoryDto updatedCatDto = CategoryTOCategoryDto(save);
		return updatedCatDto;
	}

	public void DeleteCategory(int catId) {
		Categories delete = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Id is Not Available in list"));
		categoryRepo.delete(delete);
		return;
	}

	public CategoryDto CategoryById(int catId) {
		Categories findCatById = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Id " + catId + " Not Found!"));

		CategoryDto findCat = CategoryTOCategoryDto(findCatById);

		List<Product> productlist = productRepo.findAll();

		List<Product> ProductMatchList = productlist.stream()
				.filter(product -> product.getCatergories().getCategories_id() == catId).collect(Collectors.toList());

		List<ProductDto> collectCatDto = ProductMatchList.stream().map(product -> ProductToProductDto(product))
				.collect(Collectors.toList());

		findCat.setProducts(collectCatDto);
		return findCat;

		// old code implementation of CategoryById
//		Product productById = productRepo.findById(findCatById.getCategories_id())
//		.orElseThrow(() -> new ResourceNotFoundException("Category Product Not Found!"));
	}

	public CategoryResponse AllCategory(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);

		Page<Categories> pageCategories = categoryRepo.findAll(p);
		List<Categories> allCategories = pageCategories.getContent();

		List<CategoryDto> CategoriesallDto = allCategories.stream().map(category -> CategoryTOCategoryDto(category))
				.collect(Collectors.toList());

		CategoryResponse categoryResponse = new CategoryResponse();

		categoryResponse.setContent(CategoriesallDto);
		categoryResponse.setPageNumber(pageCategories.getNumber());
		categoryResponse.setPageSize(pageCategories.getSize());
		categoryResponse.setTotalElements(pageCategories.getTotalElements());
		categoryResponse.setTotalPages(pageCategories.getTotalPages());

		categoryResponse.setLastPage(pageCategories.isLast());
		return categoryResponse;
		
//		List<CategoryDto> list = categoryRepo.findAll().stream().map(category -> CategoryTOCategoryDto(category))
//				.collect(Collectors.toList());
//		return list;

	}

	// CategoryDto -> Categories
	public Categories CategoryDtoToCategory(CategoryDto catDto) {
		Categories categories = new Categories();
		categories.setCategories_id(catDto.getCategories_id());
		categories.setCategory_name(catDto.getCategory_name());
		return categories;
	}

	// Categories -> CategoryDto
	public CategoryDto CategoryTOCategoryDto(Categories cat) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategories_id(cat.getCategories_id());
		categoryDto.setCategory_name(cat.getCategory_name());

		return categoryDto;
	}

	public ProductDto ProductToProductDto(Product product) {

		ProductDto dto = new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setProduct_name(product.getProduct_name());
		dto.setProduct_prize(product.getProduct_prize());
		dto.setProduct_quantity(product.getProduct_quantity());
		dto.setStock(product.isStock());

		return dto;
	}
}
