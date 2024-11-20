package com.springboot.pharmaassit.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {

	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
	,message = "Passsword must contains atleast one UpperCase and one LowerCaseand One Special Character and Length Should be Minimum of 8 Characters")
	private String email;
	
	@NotNull(message = "phone number cannot be null")	
	@NotBlank(message="phone number cannot be blank")
	@Pattern(regexp = "^[6-9][0-9]{9}$\r\n"
	,message = "phone number contains 10 digits")
	private String phoneNumber;
	
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$\r\n"
	,message = "Password must be 8-20 characters long, containing at least one uppercase letter, one lowercase letter, one digit, and one special character from @$!%*?&.")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
