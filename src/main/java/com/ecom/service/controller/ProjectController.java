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

import com.ecom.service.entity.Project;
import com.ecom.service.exception.ProjectNotFound;
import com.ecom.service.repository.ProjectRepository;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	ProjectRepository repository;

	@GetMapping("/Project/{id}")
	public Optional<Project> getProjectById(@PathVariable("id") long id) {
		Optional<Project> pro = repository.findById(id);
		if (pro != null) {
			return pro;
		}
		throw new ProjectNotFound("Project Not Found by Given Id = " + id);
	}

	@GetMapping("/get-projects")
	public List<Project> getProjects() {
		List<Project> list = repository.findAll();
		if (list.isEmpty()) {
			throw new ProjectNotFound("Project list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-projects")
	public Map<String, String> project(@RequestBody Project project) {
		Project rowsAffected = repository.save(project);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Project created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}

}
