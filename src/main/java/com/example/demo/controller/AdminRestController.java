package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.datamodel.User;
import com.example.demo.service.UserService;

@RestController

public class AdminRestController {

	@Autowired
	private UserService userService;

	// @PreAuthorize("hasRole('USER')")
	@GetMapping("/admin/users/{id}")
	public Optional<User> getUsers(@PathVariable("id") Integer userId) {
		getRoleDetails();
		Optional<User> user = userService.findUserById(userId);

		return user;
	}

	@PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
	@PutMapping("/admin/users/{id}")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/admin/users/{id}")
	public void deleteUser(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
	}

	public void getRoleDetails() {

		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		System.out.println("Roles are ::: " + authorities);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ADMIN"));
		System.out.println("hasUserRole::: " + hasUserRole);

	}
}