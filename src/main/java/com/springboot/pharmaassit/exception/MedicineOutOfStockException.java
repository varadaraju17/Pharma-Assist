package com.springboot.pharmaassit.exception;


public class MedicineOutOfStockException extends RuntimeException {
 private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public MedicineOutOfStockException(String message) {
	super();
	this.message = message;
}
 
}
