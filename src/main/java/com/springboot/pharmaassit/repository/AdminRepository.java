package com.springboot.pharmaassit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pharmaassit.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
	Optional<Admin> findByEmail(String username);
}
