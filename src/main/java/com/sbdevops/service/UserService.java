package com.sbdevops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbdevops.dao.UserRepository;
import com.sbdevops.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		System.out.println("Getting data from DB " + users);
		return users;
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
