package com.ecom.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.service.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
