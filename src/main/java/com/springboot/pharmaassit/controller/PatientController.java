package com.springboot.pharmaassit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pharmaassit.requestdtos.PatientRequest;
import com.springboot.pharmaassit.responsedtos.PatientResponse;
import com.springboot.pharmaassit.service.PatientService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;
import com.springboot.pharmaassit.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@Controller
public class PatientController {

	private final PatientService patientService;
	private  final AppResponseBuilder appResponseBuilder;


	public PatientController(PatientService patientService, AppResponseBuilder appResponseBuilder) {
		super();
		this.patientService = patientService;
		this.appResponseBuilder = appResponseBuilder;
	}

	@Operation(description = "The end point used to save the patient into the database",responses = {
			@ApiResponse(responseCode = "202" ,description = "patient created"),
			@ApiResponse(responseCode = "404",description = "patient information was not saved in data base",
			content = {@Content(schema = @Schema(implementation =ErrorStructure.class))
			})
	})
	@PostMapping("/pharmacy/patients/{pharmacyId}")
	public ResponseEntity<ResponseStructure<PatientResponse>> savePatient(@RequestBody PatientRequest patientRequest, @PathVariable String pharmacyId){
		PatientResponse patientResponse= patientService.savePatient(patientRequest, pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED,"Patient Created Succesfully", patientResponse);
	}
	@Operation(description = "The end point used find the patient based on the pharmacy id ",
			responses = {
					@ApiResponse(responseCode = "302",description = "pharmacy found "),
					@ApiResponse(responseCode = "404",description = "pharmacy not found by Id",
					content = {@Content(schema = @Schema(implementation = ErrorStructure.class))
					})
	})
	@PostMapping("/patients")
	public ResponseEntity<ResponseStructure<PatientResponse>> updatePatient(@RequestBody PatientRequest patientRequest, @PathVariable String patientId){
		PatientResponse patientResponse= patientService.updatePatient(patientRequest, patientId);
		return appResponseBuilder.success(HttpStatus.OK, "Patient Updated Succesfully", patientResponse);
	}
}
