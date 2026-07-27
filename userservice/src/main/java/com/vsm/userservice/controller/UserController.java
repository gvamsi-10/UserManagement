package com.vsm.userservice.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsm.userservice.entity.User;
import com.vsm.userservice.service.UserService;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userservice;

	@GetMapping("/hello")
	public String userservice() {
		System.out.println("Hello from userservice");
		return "Hello";
	}
	
	@PostMapping()
	public User SaveUser(@RequestBody User user) {
		return userservice.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userservice.getUser(id);
	}
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userservice.deleteUser(id);
	}
	
	@PatchMapping("/{id}")
	public User PatchUser(@PathVariable Long id, @RequestBody User patchuser) {
		return userservice.patchUser(id,patchuser);
	}
	
}
