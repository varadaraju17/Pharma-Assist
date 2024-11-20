package com.springboot.pharmaassit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.lowagie.text.DocumentException;
import com.springboot.pharmaassit.responsedtos.BillResponse;
import com.springboot.pharmaassit.service.BillService;
import com.springboot.pharmaassit.utility.AppResponseBuilder;
import com.springboot.pharmaassit.utility.ResponseStructure;


@Controller
public class BillController {

    @Autowired
    private BillService billService;
    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("bills/{patientId}")
    public ResponseEntity<ResponseStructure<BillResponse>> createBill(@PathVariable String patientId) {
        BillResponse response = billService.createBill(patientId);
        return appResponseBuilder.success(HttpStatus.CREATED,"Bill is Created", response);
    }

    @GetMapping("bills/{billId}/pdf")
    public ResponseEntity<byte[]> generateBillPdf(@PathVariable String billId) throws DocumentException  {
        byte[] pdf = billService.generateBillPdf(billId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("bill.pdf").build()); // Use build() here

        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}