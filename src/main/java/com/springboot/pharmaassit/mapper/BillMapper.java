package com.springboot.pharmaassit.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmaassit.entity.Bill;
import com.springboot.pharmaassit.requestdtos.BillRequest;
import com.springboot.pharmaassit.responsedtos.BillResponse;
@Component
public class BillMapper {
public Bill mapToBill(BillRequest billRequest, Bill bill) {
	bill.setTotalAmount(billRequest.getTotalAmount());
	bill.setGstInPercentage(billRequest.getGstInPercentage());
	bill.setTotalPayableAmount(billRequest.getTotalPayableAmount());
	return bill;
}
public BillResponse mapToBillResponse(Bill bill) {
	BillResponse response = new BillResponse();
	response.setTotalAmount(bill.getTotalAmount());
	response.setGstInPercentage(bill.getGstInPercentage());
	response.setTotalPayableAmount(bill.getTotalPayableAmount());
	return response;
}
}
