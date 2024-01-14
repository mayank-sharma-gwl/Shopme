package com.oops.JustBuyIt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oops.JustBuyIt.entity.Product;
import com.oops.JustBuyIt.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct()
	{
		return this.productRepository.findAll();
	}
	public void addProduct(Product product)
	{
		productRepository.save(product);
	}
	public void removeProductById(Long id)
	{
		productRepository.deleteById(id);
	}
	public Optional<Product> getProductById(Long id)
	{
		return productRepository.findById(id);
	}
	public List<Product> getAllProductsByCategories(int id)
	{
		return productRepository.findAllByCategory_id(id);
	}
}
