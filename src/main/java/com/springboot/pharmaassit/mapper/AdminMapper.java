package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Admin;
import com.springboot.pharmaassit.requestdtos.AdminRequest;
import com.springboot.pharmaassit.responsedtos.AdminResponse;

@Component
public class AdminMapper {
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		admin.setPhoneNumber(adminRequest.getPhoneNumber());
		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {
	AdminResponse adminResponse = new AdminResponse();

		adminResponse.setEmail(admin.getEmail());
		adminResponse.setPhoneNumber(admin.getPhoneNumber());
		return adminResponse;
	}
}