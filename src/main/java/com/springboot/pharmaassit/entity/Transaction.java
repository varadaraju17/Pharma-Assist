package com.springboot.pharmaassit.entity;

import java.time.LocalDate;

import com.springboot.pharmaassit.config.GenerateCustomId;
import com.springboot.pharmaassit.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
@Id
@GenerateCustomId
private String transactionId;
private int quantity;
@Enumerated(EnumType.STRING)
private TransactionType transactionType;
private LocalDate dateTime;

@ManyToOne
private Pharmacy pharmacy;
@ManyToOne
private Medicine medicine;

@ManyToOne
private Bill bill;


public Bill getBill() {
	return bill;
}
public void setBill(Bill bill) {
	this.bill = bill;
}
public Pharmacy getPharmacy() {
	return pharmacy;
}
public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}
public Medicine getMedicine() {
	return medicine;
}
public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
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
