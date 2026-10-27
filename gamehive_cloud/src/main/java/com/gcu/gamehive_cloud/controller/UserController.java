package com.gcu.gamehive_cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.gamehive_cloud.model.User;
import com.gcu.gamehive_cloud.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	// SLF4J Logger which writes messages to the console
		private static Logger logger = LoggerFactory.getLogger(UserController.class);

		private UserRepository userRepository;
		
		// Constructor injection to use for the repository
		public UserController(UserRepository userRepository)
		{
			this.userRepository = userRepository;
		}
		
		// Show the empty registration form
		@GetMapping("/register")
		public String ShowRegisterForm(Model model)
		{
			logger.info("Opening registration form");
			model.addAttribute("user", new User());
			return "register";
		}
		
		@PostMapping("/register")
		public String SaveNewUser(@ModelAttribute User user)
		{
			userRepository.save(user);
			logger.info("Added new user: {}", user.getUsername());
			
			// Once the user has been registered, redirect them to the store
			return "redirect:/products";
		}
}
