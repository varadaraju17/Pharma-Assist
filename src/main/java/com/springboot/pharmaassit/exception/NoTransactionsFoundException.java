package com.springboot.pharmaassit.exception;

public class NoTransactionsFoundException extends RuntimeException {
private String messsage;

public String getMesssage() {
	return messsage;
}

public void setMesssage(String messsage) {
	this.messsage = messsage;
}

public NoTransactionsFoundException(String messsage) {
	super();
	this.messsage = messsage;
}


}
