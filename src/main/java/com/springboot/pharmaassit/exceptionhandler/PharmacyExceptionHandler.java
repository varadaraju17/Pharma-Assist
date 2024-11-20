package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.PharmacyNotFoundByAdminIdException;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByIdException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;

@RestControllerAdvice
public class PharmacyExceptionHandler {
	@Autowired
	private AppResponseBuilder appResponseBuilder;
	
	@ExceptionHandler(PharmacyNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handlePharamacyNotFoundByIdException( PharmacyNotFoundByIdException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacy Not Found BY ID");
	}
	@ExceptionHandler(PharmacyNotFoundByAdminIdException.class)
	public ResponseEntity<ErrorStructure<String>> handlePharmacyNotFoundByAdminIdException(PharmacyNotFoundByAdminIdException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Pharamacy not found by admin id");
	}
}
