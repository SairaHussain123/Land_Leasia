package com.candella.entity;

public class Farmer {

	private String farmer_id;
	private String first_name;
	private String last_name;
	private long contact_number;
	private String address;
	private String location;
private String	 specializedIn;
	public String getFarmer_id() {
		return farmer_id;
	}
	public void setFarmer_id(String farmer_id) {
		this.farmer_id = farmer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecializedIn() {
		return specializedIn;
	}
	public void setSpecializedIn(String specializedIn) {
		this.specializedIn = specializedIn;
	}
	
public Farmer(String farmer_id, String first_name, String last_name, long contact_number, String address,
		String location, String specializedIn) {
	super();
	this.farmer_id = farmer_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.contact_number = contact_number;
	this.address = address;
	this.location = location;
	this.specializedIn = specializedIn;
}
}