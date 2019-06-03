package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.datamodel.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("user details are :::: "+userName);
		User user = userRepository.findByEmail(userName)
				.orElseThrow(() -> new UsernameNotFoundException(userName + " not found"));
		System.out.println("user details after  "+user.getEmail()+":::"+user.getPassword()+"::::"+user.getAuthorities());
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getAuthorities());
	}

	
}
