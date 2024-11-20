package com.springboot.pharmaassit.utility;

import org.springframework.http.HttpStatus;

public class SimpleResponseStructure {
private int status;
private String message;
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public static SimpleResponseStructure create(HttpStatus status, String message) {
	SimpleResponseStructure simpleResponseStructure = new SimpleResponseStructure();
	simpleResponseStructure.setStatus(status.value());
	simpleResponseStructure.setMessage(message);
	return simpleResponseStructure;
}

}
