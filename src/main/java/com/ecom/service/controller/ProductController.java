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

import com.ecom.service.entity.Product;
import com.ecom.service.exception.ProductNotFound;
import com.ecom.service.repository.ProductRepositry;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepositry repositry;

	@GetMapping("/get-products")
	public List<Product> getProduct() {
		List<Product> list = repositry.findAll();
		if (list.isEmpty()) {
			throw new ProductNotFound("Product list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-product")
	public Map<String, String> addProduct(@RequestBody Product product) {
		Product rowsAffected = repositry.save(product);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}

}
