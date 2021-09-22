package com.survivor.entity;


public class Robot {

	private String model;
	private String serialNumber;
	private String manufacturedDate;
	private String category;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Robot(String model, String serialNumber, String manufacturedDate, String category) {
		super();
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturedDate = manufacturedDate;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Robot [model=" + model + ", serialNumber=" + serialNumber + ", manufacturedDate=" + manufacturedDate
				+ ", category=" + category + "]";
	}
	public Robot() {
		super();
	}
	
}
