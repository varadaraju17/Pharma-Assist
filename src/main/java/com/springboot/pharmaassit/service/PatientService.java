package com.springboot.pharmaassit.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.springboot.pharmaassit.entity.Patient;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByIdException;
import com.springboot.pharmaassit.mapper.PatientMapper;
import com.springboot.pharmaassit.repository.PatientRepository;
import com.springboot.pharmaassit.repository.PharmacyRepository;
import com.springboot.pharmaassit.requestdtos.PatientRequest;
import com.springboot.pharmaassit.responsedtos.PatientResponse;


@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	private final PatientMapper mapper;
	private final PharmacyRepository pharmacyRepository;
	public PatientService(PatientRepository patientRepository, PatientMapper mapper,
			PharmacyRepository pharmacyRepository) {
		super();
		this.patientRepository = patientRepository;
		this.mapper = mapper;
		this.pharmacyRepository = pharmacyRepository;
	}
	
	public PatientResponse savePatient(PatientRequest patientRequest,String pharmacyId) {

		return pharmacyRepository.findById(pharmacyId).map((pharmacy)->{
			Patient patient =mapper.mapToPatient(patientRequest, new Patient());
			patient.setPharmacy(pharmacy);
			if(pharmacy.getPatients() == null )
				pharmacy.setPatients(new ArrayList<Patient>());
			pharmacy.getPatients().add(patient);
			patient = patientRepository.save(patient);
			return mapper.mapToPatientResponse(patient);
		}).orElseThrow(()-> new PharmacyNotFoundByIdException("Pharmacy Not Found By ID"+"found with id:"+pharmacyId));
		}


}


