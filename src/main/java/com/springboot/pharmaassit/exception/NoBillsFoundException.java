package com.springboot.pharmaassit.exception;


public class NoBillsFoundException extends RuntimeException {
	
private String messsage;


public String getMesssage() {
	return messsage;
}


public void setMesssage(String messsage) {
	this.messsage = messsage;
}


public NoBillsFoundException(String messsage) {
	super();
	this.messsage = messsage;
}

}
