package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.NoTransactionsFoundException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;


@RestControllerAdvice
public class TransactionExceptionHandler {
@Autowired
private AppResponseBuilder appResponseBuilder;

@ExceptionHandler(NoTransactionsFoundException.class)
public ResponseEntity<ErrorStructure<String>> handleNoTransactionsFoundException(NoTransactionsFoundException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "No Transaction Found");
	
}
}
