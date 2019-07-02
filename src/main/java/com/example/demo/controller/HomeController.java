package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model) {
		
		model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
		return "registration";
	}
	
	@PostMapping("/registration")
	public String submitRegistration(Model model) {
		model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
		return "login";
	}

}
