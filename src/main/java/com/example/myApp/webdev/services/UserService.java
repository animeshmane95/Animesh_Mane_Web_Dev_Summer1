package com.example.myApp.webdev.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myApp.webdev.models.User;
import com.example.myApp.webdev.repositories.UserRepository;

import java.util.*;
@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
}
