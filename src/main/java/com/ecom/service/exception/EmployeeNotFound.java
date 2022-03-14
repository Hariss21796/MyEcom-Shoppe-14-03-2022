package com.ecom.service.exception;

public class EmployeeNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message) {
		super(message);
	}

}
