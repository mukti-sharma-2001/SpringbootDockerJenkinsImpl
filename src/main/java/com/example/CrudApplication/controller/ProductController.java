package com.example.CrudApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApplication.entity.Product;
import com.example.CrudApplication.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.getProducts();
	}
	@GetMapping("/productById/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	@GetMapping("product/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	@PostMapping("/add/products")
	public List<Product> saveProducts(@RequestBody List<Product>pList){
		return service.saveProducts(pList);
	}
	@PostMapping("/add/product")
	public Product saveProduct(@RequestBody Product p) {
		return service.saveProduct(p);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product p) {
		return service.updateProduct(p);
	}
	
	
}
