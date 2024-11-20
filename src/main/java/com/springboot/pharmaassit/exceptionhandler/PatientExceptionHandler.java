package com.springboot.pharmaassit.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmaassit.exception.PatientNotFoundByIdException;
import com.springboot.pharmaassit.exception.PatientNotFoundByPharmacyIdException;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;



@RestControllerAdvice
public class PatientExceptionHandler {
	@Autowired
	private AppResponseBuilder  appResponseBuilder;
	
@ExceptionHandler(PatientNotFoundByPharmacyIdException.class)
public ResponseEntity<ErrorStructure<String>> handlePatientNotFoundByPharmacyIdException(PatientNotFoundByPharmacyIdException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Patient Not found by PharmacyId");
}
@ExceptionHandler(PatientNotFoundByIdException.class)
public ResponseEntity<ErrorStructure<String>> handlePatientNotFoundByIdException(PatientNotFoundByIdException ex){
	return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Patient Not Found By Id");
}
}
