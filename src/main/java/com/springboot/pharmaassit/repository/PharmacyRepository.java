package com.springboot.pharmaassit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pharmaassit.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
