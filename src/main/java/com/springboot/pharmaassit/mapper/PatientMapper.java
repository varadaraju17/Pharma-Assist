package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Patient;
import com.springboot.pharmaassit.requestdtos.PatientRequest;
import com.springboot.pharmaassit.responsedtos.PatientResponse;

@Component
public class PatientMapper {

	public Patient mapToPatient(PatientRequest patientRequest, Patient patient) {
		patient.setPatientName(patientRequest.getPatientName());
		patient.setNumber(patientRequest.getNumber());
		patient.setEmail(patientRequest.getEmail());
		patient.setDateOfBirth(patientRequest.getDateOfBirth());
		patient.setGender(patientRequest.getGender());
		return patient;
	}
	public PatientResponse mapToPatientResponse(Patient patient) {
		PatientResponse response = new PatientResponse();
		response.setPatientName(patient.getPatientName());
		response.setEmail(patient.getEmail());
		response.setNumber(patient.getNumber());
		response.setDateOfBirth(patient.getDateOfBirth());
		response.setGender(patient.getGender());
		return response;
	}
}
