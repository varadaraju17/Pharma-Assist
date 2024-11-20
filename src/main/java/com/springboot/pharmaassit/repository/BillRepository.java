package com.springboot.pharmaassit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pharmaassit.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

}
