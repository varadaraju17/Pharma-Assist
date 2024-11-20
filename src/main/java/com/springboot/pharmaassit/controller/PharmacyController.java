package com.springboot.pharmaassit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pharmaassit.requestdtos.PharmacyRequest;
import com.springboot.pharmaassit.responsedtos.PharmacyResponse;
import com.springboot.pharmaassit.service.PharmacyService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;
import com.springboot.pharmaassit.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@Controller
public class PharmacyController {
private final PharmacyService pharmacyService;
private  final AppResponseBuilder appResponseBuilder;

public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder appResponseBuilder) {
	super();
	this.pharmacyService = pharmacyService;
	this.appResponseBuilder = appResponseBuilder;
}
@Operation(description = "The end point used to save the pharmacy into the database",responses = {
		@ApiResponse(responseCode = "202" ,description = "pharmacy created"),
		@ApiResponse(responseCode = "404",description = "pharmacy information was not saved in data base",
		content = {@Content(schema = @Schema(implementation =ErrorStructure.class))
		})
})
@PostMapping("/admins/{adminId}/pharmacy")
public ResponseEntity<ResponseStructure<PharmacyResponse>> addPharmacy(@RequestBody PharmacyRequest pharmacyRequest,@PathVariable String adminId){
	PharmacyResponse response = pharmacyService.addPharmacy(pharmacyRequest, adminId);
	return appResponseBuilder.success(HttpStatus.CREATED,"pharmacy created succesfully", response);
}

}
