package com.oops.JustBuyIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oops.JustBuyIt.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
