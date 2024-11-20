package com.springboot.pharmaassit.exception;


public class PatientNotFoundByPharmacyIdException extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PatientNotFoundByPharmacyIdException(String message) {
		super();
		this.message = message;
	}
	
}
