package com.procatapi.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procatapi.Entity.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {

}
