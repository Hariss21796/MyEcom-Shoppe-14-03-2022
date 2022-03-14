package com.ecom.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.service.entity.Employee;
import com.ecom.service.exception.EmployeeNotFound;
import com.ecom.service.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if (emp != null) {
			return emp;
		}
		throw new EmployeeNotFound("Emplyee Not Found by Given Id = " + id);
	}

	@GetMapping("/employee-name")
	public Optional<Employee> getEmployeeByName(@RequestParam("name") String name) {
		Employee emp = employeeRepo.findbyName(name);
		if (emp != null) {
			return Optional.of(emp);
		}
		throw new EmployeeNotFound("Employee Not Found with given name = " + name);
	}

	@GetMapping("/get-employees")
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeRepo.findAll();
		if (list.isEmpty()) {
			throw new EmployeeNotFound("Employee list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-employee")
	public Map<String, String> addEmployee(@Validated @RequestBody Employee employee) {
		Employee rowsAffected = employeeRepo.save(employee);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Employee created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}
}
