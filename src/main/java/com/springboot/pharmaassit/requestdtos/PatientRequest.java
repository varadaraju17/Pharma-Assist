package com.springboot.pharmaassit.requestdtos;

import java.time.LocalDate;

import com.springboot.pharmaassit.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientRequest {
	@NotNull(message = "name cannot be null")
	@NotBlank(message ="name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]{3,20}$"
	,message = "user name contains only alphabets")
	private String patientName;
	
	@NotNull(message = "phone number cannot be null")	
	@NotBlank(message="phone number cannot be blank")
	@Pattern(regexp = "^[6-9][0-9]{9}$\r\n"
	,message = "phone number contains 10 digits")
	private String number;

	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
	,message = "Passsword must contains atleast one UpperCase and one LowerCaseand One Special Character and Length Should be Minimum of 8 Characters")
	private String email;
	
	@NotNull(message = "gender cannot be null")
	@NotBlank(message = "gender cannot be blank")
	
	private Gender gender;
	@NotNull(message = "dateOfBirth cannot be null")
	@NotBlank(message = "dateOfBirth cannot be blank")
	@Pattern(regexp = "^([0-9]{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$\r\n"
			, message = "Invalid format: Date of Birth must be in yyyy-MM-dd format.")
	private LocalDate dateOfBirth;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
