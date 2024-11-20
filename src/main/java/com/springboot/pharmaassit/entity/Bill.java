package com.springboot.pharmaassit.entity;

import java.time.LocalDate;
import java.util.List;

import com.springboot.pharmaassit.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bill {
	@Id
	@GenerateCustomId
	private String billId;
	private double totalAmount;
	private double gstInPercentage;
	private double totalPayableAmount;
	private LocalDate dateTime;
	
	@ManyToOne
	private Patient patient;
	@OneToMany
	private List<Transaction> transaction;
	
	
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
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
