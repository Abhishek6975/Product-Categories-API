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

import com.procatapi.payload.ProductDto;
import com.procatapi.payload.ProductResponse;
import com.procatapi.services.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServices productservices;

	@PostMapping("/create/{catId}")
	@ResponseBody
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productdto, @PathVariable int catId) {
		ProductDto createProduct = productservices.createProduct(productdto, catId);
		return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);
	}

	@GetMapping("/view")
	public ResponseEntity<ProductResponse> viewAllProduct(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "productId", required = false) String sortBy) {

		ProductResponse viewAllProduct = productservices.viewAllProduct(pageNumber, pageSize , sortBy);

		return new ResponseEntity<ProductResponse>(viewAllProduct, HttpStatus.ACCEPTED);
	}

	@GetMapping("/view/{pid}")
	public ResponseEntity<ProductDto> ProductById(@PathVariable int pid) {
		ProductDto productById = productservices.ProductById(pid);

		return new ResponseEntity<ProductDto>(productById, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> DeleteProduct(@PathVariable int pid) {
		System.out.print("Enter into Delete Method");
		productservices.DeleteProduct(pid);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@PutMapping("/update/{pid}")
	public ResponseEntity<ProductDto> productUpdateById(@PathVariable int pid, @RequestBody ProductDto product) {
		ProductDto productUpdateById = productservices.productUpdateById(pid, product);

		return new ResponseEntity<ProductDto>(productUpdateById, HttpStatus.ACCEPTED);
	}
}
