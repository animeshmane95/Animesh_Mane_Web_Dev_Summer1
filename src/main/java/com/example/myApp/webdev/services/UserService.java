package com.example.myApp.webdev.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myApp.webdev.models.User;
import com.example.myApp.webdev.repositories.UserRepository;

import java.util.*;

import javax.servlet.http.HttpSession;


@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;
	HttpSession session1;
		
	// login function returns 
	@PostMapping("/api/login")
	public User login(@RequestBody User user,HttpSession session) {	
		session1 = session;
		List<User> usersList = userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(usersList.size() == 0) {
			user =  new User();
		}
		
		else {
			user = usersList.get(0);
			session1.setAttribute("id", user);
		}
		return user;
	}
	
	@PutMapping("/api/profile")
	public User updateProfile(@RequestBody User user){
		User user1 = (User) session1.getAttribute("id");
		int id1 =user1.getId();
		user.setId(id1);
		userRepository.save(user);
		return user;
		}
	
	@GetMapping("/api/profile")
	public User getProfile( HttpSession session) {
		User user1 ;
		user1 = (User) session1.getAttribute("id");
		return user1;
		
	}
	
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
