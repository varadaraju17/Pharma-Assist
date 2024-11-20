package com.springboot.pharmaassit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.springboot.pharmaassit.entity.Bill;
import com.springboot.pharmaassit.entity.Patient;
import com.springboot.pharmaassit.entity.Transaction;
import com.springboot.pharmaassit.exception.NoTransactionsFoundException;
import com.springboot.pharmaassit.exception.PatientNotFoundByIdException;
import com.springboot.pharmaassit.mapper.BillMapper;
import com.springboot.pharmaassit.repository.BillRepository;
import com.springboot.pharmaassit.repository.PatientRepository;
import com.springboot.pharmaassit.repository.TransactionRepository;
import com.springboot.pharmaassit.responsedtos.BillResponse;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BillMapper mapper;

    public BillResponse createBill(String patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundByIdException("Patient not found with ID: " + patientId));

        List<Transaction> transactions = transactionRepository.findAll();
        if (transactions.isEmpty()) {
            throw new NoTransactionsFoundException("No transactions to create a bill");
        }

        double totalAmount = transactions.stream().mapToDouble(t -> t.getQuantity() * t.getMedicine().getPrice()).sum();
        double gst = 0.18 * totalAmount;
        double totalPayableAmount = totalAmount + gst;

        Bill bill = new Bill();
        bill.setPatient(patient);
        bill.setTransaction(transactions);
        bill.setTotalAmount(totalAmount);
        bill.setGstInPercentage(18);
        bill.setTotalPayableAmount(totalPayableAmount);
        bill.setDateTime(LocalDate.now());

        return mapper.mapToBillResponse(bill);
    }

}