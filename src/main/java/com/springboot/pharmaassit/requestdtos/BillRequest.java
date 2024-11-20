package com.springboot.pharmaassit.requestdtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BillRequest {
	@NotNull(message = "totalAmount cannot be null")
	@NotBlank(message = " totalAmount cannot be blank")
	private double totalAmount;
	
	@NotNull(message = " gstInPercentage cannot be null")
	@NotBlank(message = " gstInPercentage cannot be blank")
	
	private double gstInPercentage;
	
	@NotNull(message = " totalPayableAmount cannot be null")
	@NotBlank(message = " totalPayableAmount cannot be blank")
	
	private double totalPayableAmount;
	
	@NotNull(message = "dateTime cannot be null")
	@NotBlank(message = " dateTime  cannot be blank")
	private LocalDate dateTime;
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getGstInPercentage() {
		return gstInPercentage;
	}
	public void setGstInPercentage(double gstInPercentage) {
		this.gstInPercentage = gstInPercentage;
	}
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	
}
