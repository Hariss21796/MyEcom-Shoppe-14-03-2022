package com.ecom.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.service.entity.Role;
import com.ecom.service.exception.RoleNotFound;
import com.ecom.service.repository.RoleRepository;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleRepository repository;

	@GetMapping("/get-roles")
	public List<Role> getRole() {
		List<Role> list = repository.findAll();
		if (list.isEmpty()) {
			throw new RoleNotFound("Role list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-Role")
	public Map<String, String> addRole(@RequestBody Role role) {
		Role rowsAffected = repository.save(role);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Role created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}

}
