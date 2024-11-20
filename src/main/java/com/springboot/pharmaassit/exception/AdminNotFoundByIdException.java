package com.springboot.pharmaassit.exception;

public class AdminNotFoundByIdException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

}