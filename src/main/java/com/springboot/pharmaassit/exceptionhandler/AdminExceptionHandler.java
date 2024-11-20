package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.AdminNotFoundByIdException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;


@RestControllerAdvice
public class AdminExceptionHandler {

	private final AppResponseBuilder appResponseBuilder;

	public AdminExceptionHandler(AppResponseBuilder appResponseBuilder) {
		super();
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@ExceptionHandler(AdminNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundByIdException(AdminNotFoundByIdException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin Not Found");
	}
	
	
}
