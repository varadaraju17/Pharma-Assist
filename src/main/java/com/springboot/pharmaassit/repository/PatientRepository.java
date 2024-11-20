package com.springboot.pharmaassit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pharmaassit.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {



	

	

	

}
