package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.InvalidDataException;
import com.springboot.pharmaassit.exception.InvalidFileFormatException;
import com.springboot.pharmaassit.exception.MedicineOutOfStockException;
import com.springboot.pharmaassit.exception.NoMedicinesFoundException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;

@RestControllerAdvice
public class MedicineExceptionHandler {
private final AppResponseBuilder appResponseBuilder;

public MedicineExceptionHandler(AppResponseBuilder appResponseBuilder) {
	super();
	this.appResponseBuilder = appResponseBuilder;
}
@ExceptionHandler(InvalidFileFormatException.class)
public ResponseEntity<ErrorStructure<String>> handleInvalidFileFormatException(InvalidFileFormatException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Invalid File Format");
}

@ExceptionHandler(InvalidDataException.class)
public ResponseEntity<ErrorStructure<String>> handleInvalidDataException(InvalidDataException ex){
	return appResponseBuilder.error(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(),"Invaid Data");
}
@ExceptionHandler(NoMedicinesFoundException.class)
public ResponseEntity<ErrorStructure<String>> handleNoMedicinesFoundException(NoMedicinesFoundException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"No Medicine Found");
}
@ExceptionHandler(MedicineOutOfStockException.class)
public ResponseEntity<ErrorStructure<String>> handleMedicineOutOfStockException(MedicineOutOfStockException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(), "Medicine is Out of Stock");
}
}
