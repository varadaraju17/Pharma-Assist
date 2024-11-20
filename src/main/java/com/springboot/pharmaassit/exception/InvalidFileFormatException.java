package com.springboot.pharmaassit.exception;


public class InvalidFileFormatException extends RuntimeException {
	
	private String messsage;

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public InvalidFileFormatException(String messsage) {
		super();
		this.messsage = messsage;
	}

}
