package com.gcu.gamehive_cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.gamehive_cloud.model.Product;
import com.gcu.gamehive_cloud.repository.ProductRepository;

// The controller that handles all request with the query parameter /products
@Controller
@RequestMapping("/products")
public class ProductController {

	// SLF4J Logger which writes messages to the console
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	// Dependency Injection
	private ProductRepository productRepository;
	
	// Constructor injection to use for the repository
	public ProductController(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	// GET all products
	@GetMapping
	public String GetAllProducts(Model model)
	{
		logger.info("Loading all products");
		model.addAttribute("products", productRepository.findAll());
		return "products";
	}
	
	// Show the add product form
	@GetMapping("/new")
	public String ShowAddForm(Model model)
	{
		logger.info("Opening product form");
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	// Save the new Product
	@PostMapping
	public String SaveNewProduct(@ModelAttribute Product product)
	{
		productRepository.save(product);
		logger.info("Saved new product: {}", product.getName());
		// After new product has been saved go back to the list
		return "redirect:/products";
	}
}
