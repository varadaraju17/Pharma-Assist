package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Pharmacy;
import com.springboot.pharmaassit.requestdtos.PharmacyRequest;
import com.springboot.pharmaassit.responsedtos.PharmacyResponse;

@Component
public class PharmacyMapper {
	public Pharmacy mapToPharmacy(PharmacyRequest pharmacyRequest, Pharmacy pharmacy) {
		pharmacy.setPharmacyName(pharmacyRequest.getPharmacyName());
		pharmacy.setLicenseNo(pharmacyRequest.getLicenseNo());
		pharmacy.setGstNo(pharmacyRequest.getGstNo());
		return pharmacy;
	}
	public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy) {
		PharmacyResponse pharmacyResponse = new PharmacyResponse();
		pharmacyResponse.setPharmacyName(pharmacy.getPharmacyName());
		pharmacyResponse.setLicenseNo(pharmacy.getLicenseNo());
		pharmacyResponse.setGstNo(pharmacy.getGstNo());
		return pharmacyResponse;
	}
	
}
