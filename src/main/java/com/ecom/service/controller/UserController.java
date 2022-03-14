package com.ecom.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.service.entity.User;
import com.ecom.service.exception.UserNotFound;
import com.ecom.service.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository repository;

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id) {
		Optional<User> user = repository.findById(id);
		if (user != null) {
			return user;
		}
		throw new UserNotFound("User Not Found by Given Id = " + id);
	}

	@GetMapping("/get-users")
	public List<User> getUsers() {
		List<User> list = repository.findAll();
		if (list.isEmpty()) {
			throw new UserNotFound("User list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-users")
	public Map<String, String> User(@RequestBody User user) {
		User rowsAffected = repository.save(user);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}

}
