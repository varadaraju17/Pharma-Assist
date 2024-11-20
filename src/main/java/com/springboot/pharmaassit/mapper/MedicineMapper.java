package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Medicine;
import com.springboot.pharmaassit.responsedtos.MedicineResponse;




@Component
public class MedicineMapper {

	public MedicineResponse mapToMedicineResponse(Medicine medicine) {
		MedicineResponse medicineResponse = new MedicineResponse();
		medicineResponse.setMedicineName(medicine.getMedicineName());
		medicineResponse.setCategory(medicine.getCategory());
		medicineResponse.setDosageInMg(medicine.getDosageInMg());
		medicineResponse.setForm(medicine.getForm());
		medicineResponse.setIngridients(medicine.getIngridients());
		medicineResponse.setManufacturer(medicine.getManufacturer());
		medicineResponse.setPrice(medicine.getPrice());
		medicineResponse.setExpiryDate(medicine.getExpiryDate());
		return medicineResponse ;
	}

}
