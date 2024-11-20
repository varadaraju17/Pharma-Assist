package com.springboot.pharmaassit.utility;

public class ErrorStructure <T> {
	private int httpStatus;
	private String message;
	private T rootCause;
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getRootCause() {
		return rootCause;
	}
	public void setRootCause(T rootCause) {
		this.rootCause = rootCause;
	}
	public static <T> ErrorStructure<T> create(int httpStatus, String message, T rootCause) {
		ErrorStructure<T> errorStructure = new ErrorStructure<T>();
		errorStructure.setHttpStatus(errorStructure.httpStatus);
		errorStructure.setMessage(errorStructure.message);
		errorStructure.setRootCause(errorStructure.rootCause);
			return errorStructure;
	}
	
	
	
	
	

}
