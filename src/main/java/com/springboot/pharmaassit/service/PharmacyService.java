package com.springboot.pharmaassit.service;

import org.springframework.stereotype.Service;

import com.springboot.pharmaassit.entity.Pharmacy;
import com.springboot.pharmaassit.exception.AdminNotFoundByIdException;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByAdminIdException;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByIdException;
import com.springboot.pharmaassit.mapper.PharmacyMapper;
import com.springboot.pharmaassit.repository.AdminRepository;
import com.springboot.pharmaassit.repository.PharmacyRepository;
import com.springboot.pharmaassit.requestdtos.PharmacyRequest;
import com.springboot.pharmaassit.responsedtos.PharmacyResponse;




@Service
public class PharmacyService {
	
	private final PharmacyRepository pharmacyRepository;
	private final AdminRepository adminRepository;
	private final PharmacyMapper mapper;

	public PharmacyService(PharmacyRepository pharmacyRepository,
			AdminRepository adminRepository, PharmacyMapper mapper) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.adminRepository = adminRepository;
		this.mapper = mapper;
	}

	
	public PharmacyResponse addPharmacy( PharmacyRequest pharmacyRequest, String adminId) {
		return adminRepository.findById(adminId).map((admin) -> {
			Pharmacy pharmacy = mapper.mapToPharmacy(pharmacyRequest, new Pharmacy());
			pharmacy= pharmacyRepository.save(pharmacy);
			admin.setPharmacy(pharmacy);
			adminRepository.save(admin);
			return mapper.mapToPharmacyResponse(pharmacy);
		}).orElseThrow(()-> new AdminNotFoundByIdException("Admin NOt Found By ID"));

	}
	public PharmacyResponse findPharmacyByAdminId(String adminId) {
		return adminRepository.findById(adminId).map((admin) ->
		{
			Pharmacy pharmacy =admin.getPharmacy();
			return mapper.mapToPharmacyResponse(pharmacy);
		}).orElseThrow(() -> new PharmacyNotFoundByAdminIdException("pharmacy not found by admin Id"));
	}
	public PharmacyResponse updatePharmacy(PharmacyRequest pharmacyRequest, String pharmacyId) {
		return pharmacyRepository.findById(pharmacyId).map((exPharmacy) -> {
			mapper.mapToPharmacy(pharmacyRequest, exPharmacy);
			return pharmacyRepository.save(exPharmacy);
		}).map(mapper :: mapToPharmacyResponse)
				.orElseThrow(()-> new PharmacyNotFoundByIdException("Pharmacy not found by pharmacy ID") );
	}
	

}




