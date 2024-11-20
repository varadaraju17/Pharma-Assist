package com.springboot.pharmaassit.requestdtos;

import java.time.LocalDate;

import com.springboot.pharmaassit.enums.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MedicineRequest {
	
	@NotBlank(message = "name cannot be blank")
	@NotNull(message = "name cannot be null")
	@Pattern(regexp = "^[A-Za-z0-9\\- ]{2,50}$\r\n"
			, message = "Invalid medicine name. Please use only letters, numbers, spaces, or hyphens, and ensure the length is between 2 to 50 characters.")
	private String medicineName;
	
	@NotBlank(message = "category cannot be blank")
	@NotNull(message = "category cannot be null ")
	@Pattern(regexp = "^[A-Za-z0-9\\- ]{2,50}$\r\n"
	, message = "Invalid medicine name. Please use only letters, numbers, spaces, or hyphens, and ensure the length is between 2 to 50 characters.")
	private String category;
	
	@NotNull(message = "ingridients cannot be null")
	
	@Pattern(regexp ="^[A-Za-z0-9\\- ]+$\r\n"
			,message = "Invalid ingredient name. Please check the input." )
	private String ingridients;

	@NotBlank(message = "dosage cannot be blank")
	@NotNull(message = "dosage cannot be null")
	
	private int dosageInMg;
	
	@NotBlank(message = "form cannot be blank")
	@NotNull(message = "form cannot be null")
	
	private Form form;
	@NotBlank(message = "manufacturer cannot be blank")
	@NotNull(message = "manufacturer cannot be null")
	private String manufacturer;
	
	@NotBlank(message = "stockquantity cannot be blank")
	@NotNull(message = "stockquantity cannot be null")
	private int stockQuantity;
	
	@NotBlank(message = "expiry date cannot be blank")
	@NotNull(message = "expirydate cannot be null")
	private LocalDate expiryDate;
	
	@NotBlank(message = "price cannot be blank")
	@NotNull(message = "price cannot be null")
	private double price;
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIngridients() {
		return ingridients;
	}
	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}
	public int getDosageInMg() {
		return dosageInMg;
	}
	public void setDosageInMg(int dosageInMg) {
		this.dosageInMg = dosageInMg;
	}
	
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
