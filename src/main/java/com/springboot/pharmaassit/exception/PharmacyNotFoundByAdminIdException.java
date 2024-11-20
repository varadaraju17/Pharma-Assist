package com.springboot.pharmaassit.exception;


public class PharmacyNotFoundByAdminIdException extends RuntimeException{
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public PharmacyNotFoundByAdminIdException(String message) {
	super();
	this.message = message;
}


}
