package com.springboot.pharmaassit.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest {

	@NotNull(message = "name cannot be null")
	@NotBlank(message ="name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]{3,20}$"
	,message = " name contains only alphabets")
	private String pharmacyName;
	
	@NotNull(message = "gstno cannot br null")
	@NotBlank(message = "gstno cannot be blank")
	@Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$\r\n"
	,message = "gstno has to have a valid 15-character GSTIN format as per Indian standards")
	
	private String gstNo;
	@NotNull(message = "license no cannot br null")
	@NotBlank(message = "license no cannot be blank")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[0-9]{4}[0-9]{7}$ "
	,message = "license no has to match the standards")
	private String licenseNo;
	
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
}
