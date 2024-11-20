package com.springboot.pharmaassit.service;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.pharmaassit.entity.Medicine;
import com.springboot.pharmaassit.entity.Pharmacy;
import com.springboot.pharmaassit.enums.Form;
import com.springboot.pharmaassit.exception.NoMedicinesFoundException;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByIdException;
import com.springboot.pharmaassit.mapper.MedicineMapper;
import com.springboot.pharmaassit.repository.MedicineRepository;
import com.springboot.pharmaassit.repository.PharmacyRepository;
import com.springboot.pharmaassit.responsedtos.MedicineResponse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;



@Service
@Transactional
public class MedicineService {
	private final PharmacyRepository pharmacyRepository;
	private final MedicineRepository medicineRepository;
	private final MedicineMapper mapper;

	public MedicineService(PharmacyRepository pharmacyRepository, MedicineRepository medicineRepository,
			MedicineMapper mapper) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.medicineRepository = medicineRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public String uploadMedicines(MultipartFile file, String pharmacyId) {
		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(() -> new PharmacyNotFoundByIdException("Pharmacy Not Found"));

		try (XSSFWorkbook workBook = new XSSFWorkbook(file.getInputStream())) {
			for (Sheet sheet : workBook) {
				for (Row row : sheet) {
					if (row.getRowNum() != 0) {

						Medicine medicine = validatedMedicines(row);
						medicine.setPharmacy(pharmacy);
						saveMedicine(medicine);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Medicines added Suucessfully";
	}

	

	public Medicine validatedMedicines(Row row) {
		Medicine medicine = new Medicine();
		try {
			medicine.setMedicineName(row.getCell(0).getStringCellValue());
			medicine.setCategory(row.getCell(1).getStringCellValue());
			medicine.setDosageInMg((int) row.getCell(2).getNumericCellValue());
			medicine.setForm(Form.valueOf((row.getCell(3).getStringCellValue().toUpperCase())));
			medicine.setIngridients(row.getCell(4).getStringCellValue());
			medicine.setManufacturer(row.getCell(5).getStringCellValue());
			medicine.setPrice(row.getCell(6).getNumericCellValue());
			medicine.setExpiryDate(LocalDate.parse(row.getCell(7).getStringCellValue()));
			medicine.setStockQuantity(ThreadLocalRandom.current().nextInt(50, 101));

		} catch (NullPointerException | IllegalStateException | DateTimeParseException e) {
			throw new IllegalArgumentException("Invalid data in row " + row.getRowNum(), e);
		}

		return medicine;

	}

	public void saveMedicine(@Valid Medicine medicine) {
		medicineRepository.save(medicine);

	}
	public List<MedicineResponse> findByNameIgnoreCaseContainingOrIngredientsIgnoreCaseContaining(String medicineName, String ingridients) {
		List<Medicine> medicines = medicineRepository
				.findByMedicineNameLikeIgnoreCaseOrIngridientsLike(medicineName, ingridients);
		if (medicines.isEmpty()) {
			throw new NoMedicinesFoundException("Medicines Not Found");
		}
		return medicines.stream().map(mapper:: mapToMedicineResponse).toList();
	}	
	
	

}
