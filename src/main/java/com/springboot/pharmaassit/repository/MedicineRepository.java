package com.springboot.pharmaassit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pharmaassit.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

	public List<Medicine> findByMedicineNameLikeIgnoreCaseOrIngridientsLike(String medicineName,String ingridients);
}
