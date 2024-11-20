package com.springboot.pharmaassit.exception;


public class PatientNotFoundByIdException extends RuntimeException{
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public PatientNotFoundByIdException(String message) {
	super();
	this.message = message;
}

}
