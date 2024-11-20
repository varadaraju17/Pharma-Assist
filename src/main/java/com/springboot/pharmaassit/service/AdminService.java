package com.springboot.pharmaassit.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.pharmaassit.entity.Admin;
import com.springboot.pharmaassit.mapper.AdminMapper;
import com.springboot.pharmaassit.repository.AdminRepository;
import com.springboot.pharmaassit.requestdtos.AdminRequest;
import com.springboot.pharmaassit.responsedtos.AdminResponse;
@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;

	
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		Admin admin= adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminRepository.save(admin);
		return adminMapper.mapToAdminResponse(admin); 
	}
	
}
