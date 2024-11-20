package com.springboot.pharmaassit.exception;


public class PharmacyNotFoundByIdException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PharmacyNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
}
