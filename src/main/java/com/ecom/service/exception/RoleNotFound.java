package com.ecom.service.exception;

public class RoleNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoleNotFound(String message) {
		super(message);
	}

}
