package com.springboot.pharmaassit.exception;


public class BillNotFoundException extends RuntimeException{
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public BillNotFoundException(String message) {
	super();
	this.message = message;
}

}
