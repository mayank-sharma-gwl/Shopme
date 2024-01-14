package com.oops.JustBuyIt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oops.JustBuyIt.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
	List<Product>findAllByCategory_id(int id);
}
