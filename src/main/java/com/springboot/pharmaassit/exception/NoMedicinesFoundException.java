package com.springboot.pharmaassit.exception;


public class NoMedicinesFoundException extends RuntimeException {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public NoMedicinesFoundException(String message) {
	super();
	this.message = message;
}

}
