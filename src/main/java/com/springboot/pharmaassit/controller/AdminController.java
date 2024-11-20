package com.springboot.pharmaassit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.pharmaassit.requestdtos.AdminRequest;
import com.springboot.pharmaassit.responsedtos.AdminResponse;
import com.springboot.pharmaassit.service.AdminService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ErrorStructure;
import com.springboot.pharmaassit.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
public class AdminController {
	private final AdminService adminService;
	private  final AppResponseBuilder appResponseBuilder;
	
	
	public AdminController(AdminService adminService, AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}

	@Operation(description = "The end point used to save the admin into the database",responses = {
			@ApiResponse(responseCode = "202" ,description = "admin created"),
			@ApiResponse(responseCode = "404",description = "admin information was not saved in data base",
			content = {@Content(schema = @Schema(implementation =ErrorStructure.class))
			})
	})
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdimin(@RequestBody AdminRequest adminRequest){
		AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
				return appResponseBuilder.success(HttpStatus.CREATED, "admin created Succesfully!!", adminResponse);
	}	
	@Operation(description = "The end point used find the admin based on the unique id ",
			responses = {
					@ApiResponse(responseCode = "302",description = "admin found "),
					@ApiResponse(responseCode = "404",description = "user not found by Id",
					content = {@Content(schema = @Schema(implementation = ErrorStructure.class))
					})
	})
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(@PathVariable String adminId){
		AdminResponse response = adminService.findAdminById(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND, "user found Succesfully", response);
	}

	@Operation(description = "The end used to find the all admins",responses = {
			@ApiResponse(responseCode = "202",description = "all admins found"),
			@ApiResponse(responseCode = "404",description = "user not found by id",
			content = {@Content(schema = @Schema(implementation = ErrorStructure.class))
			})})
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmin(){
		List<AdminResponse> response = adminService.findAllAdmin();
		return appResponseBuilder.success(HttpStatus.FOUND,"all admins found succesfully!!", response);
	}
	@Operation(description = "The end used to update the admin by id",
			responses = { 
					@ApiResponse(responseCode = "202",description = "admin found"),
					@ApiResponse(responseCode = "404",description = "user not found by id",
					content = {@Content(schema = @Schema(implementation = ErrorStructure.class))
			})})
	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminById(@RequestBody AdminRequest adminRequest, @PathVariable String adminId){
		AdminResponse adminResponse = adminService.updateAdminById(adminRequest, adminId);
		return appResponseBuilder.success(HttpStatus.OK, "admin updated by id succesfuly", adminResponse);
	}
}
