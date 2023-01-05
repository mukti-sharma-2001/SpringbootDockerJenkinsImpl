package com.example.CrudApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudApplication.entity.Product;
import com.example.CrudApplication.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts(){
		return repo.findAll();
	}
	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}
	public Product getProductByName(String name) {
		return repo.findProductByName(name);
	}
	public List<Product> saveProducts(List<Product> p){
		return repo.saveAll(p);
	}
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	public Product updateProduct(Product p) {
		Product existingProduct = repo.findById(p.getId()).orElse(null);
		existingProduct.setName(p.getName());
		existingProduct.setPrice(p.getPrice());
		existingProduct.setQuantity(p.getQuantity());
		return repo.save(existingProduct);
	}
}
