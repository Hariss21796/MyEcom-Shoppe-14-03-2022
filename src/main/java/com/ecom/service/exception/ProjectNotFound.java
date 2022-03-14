package com.ecom.service.exception;

public class ProjectNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProjectNotFound(String message) {
		super(message);
	}

}
