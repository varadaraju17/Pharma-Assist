package com.springboot.pharmaassit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pharmaassit.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{
	List<Transaction> findByPharmacyPharmacyId(String pharmacyId);
}
