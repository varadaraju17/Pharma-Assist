package com.springboot.pharmaassit.entity;

import java.time.LocalDate;

import com.springboot.pharmaassit.config.GenerateCustomId;
import com.springboot.pharmaassit.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
@Id
@GenerateCustomId
private String patientId;
private String patientName;
private String number;
private String email;
@Enumerated(EnumType.STRING)
private Gender gender;
private LocalDate dateOfBirth;

@ManyToOne
private Pharmacy pharmacy;

public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
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
public Pharmacy getPharmacy() {
	return pharmacy;
}
public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}


}
