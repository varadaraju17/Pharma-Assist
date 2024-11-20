package com.springboot.pharmaassit.utility;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {
private int httpStatus;
private String message;
private T data;
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
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}

public static <T> ResponseStructure<T> create(HttpStatus status, String message, T data) {
	ResponseStructure<T> responseStructure = new ResponseStructure<T>();
	responseStructure.setHttpStatus(status.value());
	responseStructure.setMessage(message);
	responseStructure.setData(data);
	return responseStructure;
}

}
