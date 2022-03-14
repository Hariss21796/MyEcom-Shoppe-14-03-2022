package com.ecom.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
