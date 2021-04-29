package com.sbdevops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbdevops.model.User;
import com.sbdevops.service.UserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return userService.getUsers();
	}
	
	@DeleteMapping(value = "/remove")
	public User removeUser(@RequestBody User user)
	{
		userService.deleteUser(user);
		return user;
	}
}
