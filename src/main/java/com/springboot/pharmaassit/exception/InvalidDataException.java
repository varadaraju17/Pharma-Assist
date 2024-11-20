package com.springboot.pharmaassit.exception;


public class InvalidDataException extends RuntimeException {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public InvalidDataException(String message) {
	super();
	this.message = message;
}

}
