package com.oops.JustBuyIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oops.JustBuyIt.entity.Product;
import com.oops.JustBuyIt.global.GlobalData;
import com.oops.JustBuyIt.services.ProductService;

@Controller
public class CartController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addtoCart(@PathVariable long id)
	{
		GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model md)
	{
		md.addAttribute("cartCount",GlobalData.cart.size());
		md.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		md.addAttribute("cart",GlobalData.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index)
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	@GetMapping("/checkout")
	public String checkout(Model md)
	{
		md.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}
	
	
}
