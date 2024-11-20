package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Transaction;
import com.springboot.pharmaassit.requestdtos.TransactionRequest;
import com.springboot.pharmaassit.responsedtos.TransactionResponse;


@Component
public class TransactionMapper {

	public  Transaction mapToTransaction(TransactionRequest request, Transaction transaction) {
		transaction.setQuantity(request.getQuantity());
		transaction.setTransactionType(request.getTransactionType());
		transaction.setDateTime(request.getDateTime());
		return transaction;
	}
	public TransactionResponse mapToTransactionResponse(Transaction transaction) {
		TransactionResponse response = new TransactionResponse();
		response.setQuantity(transaction.getQuantity());
		response.setTransactionType(transaction.getTransactionType());
		response.setDateTime(transaction.getDateTime());
		return response;
	}
}
