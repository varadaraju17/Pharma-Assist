package com.springboot.pharmaassit.requestdtos;

import java.time.LocalDate;

import com.springboot.pharmaassit.enums.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class TransactionRequest {
	@NotBlank(message = " quantity cannot be blank")
	@NotNull(message = " quantity cannot be null ")
	
	private int quantity;  
	@NotBlank(message = " transactionType cannot be blank")
	@NotNull(message = " transactionType cannot be null ")

	private TransactionType transactionType;
	@NotBlank(message = " dateTime cannot be blank")
	@NotNull(message = "dateTime cannot be null ")
	
	private LocalDate dateTime;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}   
	
	
}
