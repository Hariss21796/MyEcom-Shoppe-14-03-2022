package com.ecom.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.service.entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

}
