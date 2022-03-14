package com.ecom.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<com.ecom.service.entity.Employee, Long> {
	@Query(value = "select * from eshopee_employee e where e.name like %:name%", nativeQuery = true)
	com.ecom.service.entity.Employee findbyName(String name);

}
