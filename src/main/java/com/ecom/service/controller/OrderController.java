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

import com.ecom.service.entity.Order;
import com.ecom.service.exception.OrderNotFound;
import com.ecom.service.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/get-orders")
	public List<Order> getOrders() {
		List<Order> list = orderRepo.findAll();
		if (list.isEmpty()) {
			throw new OrderNotFound("Order list is empty, Zero records found !");
		}
		return list;

	}

	@PostMapping("/add-order")
	public Map<String, String> order(@RequestBody Order order) {
		Order rowsAffected = orderRepo.save(order);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Order created successfully !");
		response.put("rowAffected", String.valueOf(rowsAffected));
		return response;
	}

}
