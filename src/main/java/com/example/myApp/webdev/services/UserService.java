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
	
	@GetMapping("/api/user")
	public Iterable<User> findAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/api/user/findUserById")
	public Optional<User> findUserById(int userId) {
		return userRepository.findById(userId);
	}
	
	@PutMapping("/api/user/{userid}")
	public User updateUser(@PathVariable("userid")int userid, @RequestBody User user){
		user.setId(userid);
		userRepository.save(user);
		return user;
		}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/api/register/{username}")
	public Map<String, String> findUserbyUserName(@PathVariable("username") String username) {
		Map<String, String> result = new HashMap<String, String>();
		String exists;
		
		 List<User> usersList = userRepository.findUserbyUserName(username);
		 if (usersList.size() == 0) {
			 exists = "false";
		 }
		 else {
			 exists = "true";
		 }
		 result.put("exists",""+exists);
		 return result;
		 
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
}
