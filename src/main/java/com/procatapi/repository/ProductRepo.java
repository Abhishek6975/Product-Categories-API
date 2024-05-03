package com.procatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procatapi.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//	public Product save(Product productDtoToProduct);

//	public Product findById(int id);

}
