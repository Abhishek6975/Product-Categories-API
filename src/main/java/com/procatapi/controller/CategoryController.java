package com.procatapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.procatapi.payload.CategoryDto;
import com.procatapi.payload.CategoryResponse;
import com.procatapi.payload.ProductDto;
import com.procatapi.services.CategoryServices;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryservices;
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto carDto) {
		
		CategoryDto category = categoryservices.createCategory(carDto);
		return new ResponseEntity<CategoryDto>(category ,HttpStatus.CREATED);
	}
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDto> UpdateCategory(@RequestBody CategoryDto catDto ,@PathVariable int catId) {
		CategoryDto updateCategory = categoryservices.UpdateCategory(catDto,catId);
		return new ResponseEntity<CategoryDto>(updateCategory , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<String> DeleteCategory(@PathVariable int catId) {
		  categoryservices.DeleteCategory(catId);
		return new ResponseEntity<String>("Category Delete successfully" ,HttpStatus.OK);
	}
	
	@GetMapping("/view/{catId}")
	public ResponseEntity<CategoryDto> CategoryById(@PathVariable int catId) {
		CategoryDto categoryById = categoryservices.CategoryById(catId);
		return new ResponseEntity<CategoryDto>(categoryById ,HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<CategoryResponse> AllCategory(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		CategoryResponse allCategory = categoryservices.AllCategory(pageNumber,pageSize);
		return new ResponseEntity<CategoryResponse>(allCategory ,HttpStatus.OK);
	}
	
	
	

}
