package com.springboot.pharmaassit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.pharmaassit.responsedtos.MedicineResponse;
import com.springboot.pharmaassit.service.MedicineService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;
import com.springboot.pharmaassit.utility.ResponseStructure;
import com.springboot.pharmaassit.utility.SimpleResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@Controller
public class MedicineController {

	private final AppResponseBuilder appResponseBuilder;
	private  final MedicineService medicineService;


	public MedicineController(AppResponseBuilder appResponseBuilder, MedicineService medicineService) {
		super();
		this.appResponseBuilder = appResponseBuilder;
		this.medicineService = medicineService;
	}
	@Operation(description = "The end point used to upload the medicine into the database from the excel filr",responses = {
			@ApiResponse(responseCode = "202" ,description = "medicine uploaded"),
			@ApiResponse(responseCode = "404",description = "medicine was not uploaded",
			content = {@Content(schema = @Schema(implementation =ErrorStructure.class))
			})
	})
	@PostMapping("/pharmacy/{pharmacyId}/upload")
	public ResponseEntity<SimpleResponseStructure> uploadMedcine(@RequestParam MultipartFile file,@PathVariable String pharmacyId){
	
		String messgae = medicineService.uploadMedicines(file,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED,"File Uploaded Succesfully");
	}
	@GetMapping("/medicines/")
	public ResponseEntity<ResponseStructure<List<MedicineResponse>>> findMedicineOrIngridientsByName(@PathVariable String medicineName,@PathVariable String ingridients){
		List<MedicineResponse> medicineResponses = medicineService.findByNameIgnoreCaseContainingOrIngredientsIgnoreCaseContaining(medicineName, ingridients);
		return appResponseBuilder.success(HttpStatus.FOUND, "Medicine Found Successfully", medicineResponses);
	}
	
	
}
