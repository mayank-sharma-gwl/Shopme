package com.oops.JustBuyIt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oops.JustBuyIt.entity.Category;
import com.oops.JustBuyIt.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory()
	{
		return this.categoryRepository.findAll();
	}
	public void addCategory(Category category)
	{
		this.categoryRepository.save(category);
	}
	public void removeCategoryById(int id)
	{
		this.categoryRepository.deleteById(id);
	}
	public Optional<Category> getCategoryById(int id)
	{
		return categoryRepository.findById(id);
	}
}
