package com.gcu.gamehive_cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.gamehive_cloud.model.Order;
import com.gcu.gamehive_cloud.repository.OrderRepository;
import com.gcu.gamehive_cloud.repository.ProductRepository;
import com.gcu.gamehive_cloud.repository.UserRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {

	// SLF4J Logger which writes messages to the console
		private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	// Dependency injection for all three tables
		private OrderRepository orderRepository;
		private UserRepository userRepository;
		private ProductRepository productRepository;
		
			public OrderController(OrderRepository orderRepository,
									UserRepository userRepository,
									ProductRepository productRepository)
			{
				this.orderRepository = orderRepository;
				this.userRepository = userRepository;
				this.productRepository = productRepository;
			}
			
			// GET request for the order page
			// Loading the order form and listing all of the orders
			@GetMapping
			public String GetAllOrders(Model model)
			{
				logger.info("Loading all orders");
				model.addAttribute("orders", orderRepository.findAll());
				// Filling out the dropdowns on the form
				model.addAttribute("users", userRepository.findAll());
				model.addAttribute("products", productRepository.findAll());
				return "orders";
			}
			
			// Save a new order to the form
			@PostMapping
			public String PlaceOrder(@RequestParam Integer userId,
									@RequestParam Integer productId,
									@RequestParam Integer quantity)
			{
				Order order = new Order();
				
				// It will look up the real user and product 
				order.setUser(userRepository.findById(userId).orElseThrow());
				order.setProduct(productRepository.findById(productId).orElseThrow());
				order.setQuantity(quantity);
				
				orderRepository.save(order);
				
				logger.info("Order has been placed: {} x{} for {}",
						order.getProduct().getName(), quantity, order.getUser().getUsername());
				return "redirect:/orders";
			}
}
