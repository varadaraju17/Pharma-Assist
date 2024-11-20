package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.BillNotFoundException;
import com.springboot.pharmaassit.exception.NoBillsFoundException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;



@RestControllerAdvice
public class BillExceptionHandler {

@Autowired
private AppResponseBuilder appResponseBuilder;
@ExceptionHandler(BillNotFoundException.class)
public ResponseEntity<ErrorStructure<String>> handleBillNotFoundException(BillNotFoundException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"No Bill Found");
	
}
@ExceptionHandler(NoBillsFoundException.class)
public ResponseEntity<ErrorStructure<String>> handleNoBillsFoundException(NoBillsFoundException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "No Bills Found");
}
}
