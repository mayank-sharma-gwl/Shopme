package com.oops.JustBuyIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oops.JustBuyIt.global.GlobalData;
import com.oops.JustBuyIt.services.CategoryService;
import com.oops.JustBuyIt.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model md)
	{
		md.addAttribute("cartCount",GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model md)
	{
		md.addAttribute("cartCount",GlobalData.cart.size());
		md.addAttribute("categories",categoryService.getAllCategory());
		md.addAttribute("products",productService.getAllProduct());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model md, @PathVariable int id)
	{
		md.addAttribute("cartCount",GlobalData.cart.size());
		md.addAttribute("categories",categoryService.getAllCategory());
		md.addAttribute("products",productService.getAllProductsByCategories(id));
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model md, @PathVariable Long id)
	{
		md.addAttribute("cartCount",GlobalData.cart.size());
		md.addAttribute("product",productService.getProductById(id).get());
		return "viewProduct";
	}
	
	
}
