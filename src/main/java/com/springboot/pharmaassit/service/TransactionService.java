package com.springboot.pharmaassit.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.pharmaassit.entity.Medicine;
import com.springboot.pharmaassit.entity.Pharmacy;
import com.springboot.pharmaassit.entity.Transaction;
import com.springboot.pharmaassit.enums.TransactionType;
import com.springboot.pharmaassit.exception.MedicineOutOfStockException;
import com.springboot.pharmaassit.exception.NoMedicinesFoundException;
import com.springboot.pharmaassit.exception.NoTransactionsFoundException;
import com.springboot.pharmaassit.exception.PharmacyNotFoundByIdException;
import com.springboot.pharmaassit.mapper.TransactionMapper;
import com.springboot.pharmaassit.repository.MedicineRepository;
import com.springboot.pharmaassit.repository.PharmacyRepository;
import com.springboot.pharmaassit.repository.TransactionRepository;
import com.springboot.pharmaassit.responsedtos.TransactionResponse;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;
	private final MedicineRepository medicineRepository;
	private final PharmacyRepository pharmacyRepository;
	private final TransactionMapper transactionMapper;

	public TransactionService(TransactionRepository transactionRepository, MedicineRepository medicineRepository,
			PharmacyRepository pharmacyRepository, TransactionMapper transactionMapper) {
		this.transactionRepository = transactionRepository;
		this.medicineRepository = medicineRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.transactionMapper = transactionMapper;
	}

	@Transactional
	public TransactionResponse createTransaction(String pharmacyId, String medicineId, int quantity, TransactionType transactionType) {
		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(() -> new PharmacyNotFoundByIdException("Pharmacy not found with ID: " + pharmacyId));

		Medicine medicine = medicineRepository.findById(medicineId)
				.orElseThrow(() -> new NoMedicinesFoundException("Medicine not found with ID: " + medicineId));

		if (transactionType == TransactionType.SALE && medicine.getStockQuantity() < quantity) {
			throw new MedicineOutOfStockException("Insufficient stock for medicine: " + medicine.getMedicineName());
		}

		if (transactionType == TransactionType.SALE) {
			medicine.setStockQuantity(medicine.getStockQuantity() - quantity);
		} else if (transactionType == TransactionType.PURCHASE) {
			medicine.setStockQuantity(medicine.getStockQuantity() + quantity);
		}

		medicineRepository.save(medicine);

		Transaction transaction = new Transaction();
		transaction.setTransactionType(transactionType);
		transaction.setMedicine(medicine);
		transaction.setQuantity(quantity);
		transaction.setDateTime(LocalDate.now());
		transaction.setPharmacy(pharmacy);
		transactionRepository.save(transaction);

		return transactionMapper.mapToTransactionResponse(transaction);
	}
	@Transactional
	public List<Transaction> getAllTransactionsAndClear() {
		List<Transaction> transactions = transactionRepository.findAll();
		if (transactions.isEmpty()) {
			throw new NoTransactionsFoundException("No transactions available");
		}
		transactionRepository.deleteAll();
		return transactions;
	}
	
}