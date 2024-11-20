package com.springboot.pharmaassit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.pharmaassit.entity.Transaction;
import com.springboot.pharmaassit.enums.TransactionType;
import com.springboot.pharmaassit.responsedtos.TransactionResponse;
import com.springboot.pharmaassit.service.TransactionService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ResponseStructure;
import com.springboot.pharmaassit.utility.AppResponseBuilder;

import jakarta.transaction.Transactional;

@Controller
public class TransactionController {
	@Autowired
	private  AppResponseBuilder appResponseBuilder;
	@Autowired
	private  TransactionService transactionService;


	@Transactional
	@PostMapping("/transactions/{pharmacyId}/{medicineId}/{quantity}/{transactionType}")
	public ResponseEntity<ResponseStructure<TransactionResponse>> createTransaction(@RequestParam String pharmacyId,
			@RequestParam String medicineId,
			@RequestParam int quantity,
			@RequestParam TransactionType transactionType) {

		TransactionResponse response=  transactionService.createTransaction(pharmacyId, medicineId, quantity, transactionType);
		return appResponseBuilder.success(HttpStatus.ACCEPTED,"Transaction Created Succcessfully ", response);
	}
	 @DeleteMapping("/clear")
	    public ResponseEntity<List<Transaction>> clearAllTransactions() {
	        List<Transaction> clearedTransactions = transactionService.getAllTransactionsAndClear();
	        return ResponseEntity.ok(clearedTransactions);
	    }
	 
}
