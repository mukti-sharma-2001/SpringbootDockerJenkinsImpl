package com.example.CrudApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudApplication.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findProductByName(String name);

}
