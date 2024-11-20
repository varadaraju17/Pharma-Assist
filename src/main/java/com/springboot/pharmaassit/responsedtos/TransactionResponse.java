package com.springboot.pharmaassit.responsedtos;

import java.time.LocalDate;

import com.springboot.pharmaassit.enums.TransactionType;

public class TransactionResponse {
	
	private int quantity;                                         
	private TransactionType transactionType;     
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
