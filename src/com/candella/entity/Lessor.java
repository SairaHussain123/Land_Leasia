package com.candella.entity;

public class Lessor {

	private int lessor_id;
	private String l_first_name;
	private String l_last_name;
	private long contact_number;
	private String address;
	private String location;
	private LeaseLand leaseLand;
	public Lessor(LeaseLand leaseLand) {
		super();
		this.leaseLand = leaseLand;
	}
	public LeaseLand getLeaseLand() {
		return leaseLand;
	}
	public void setLeaseLand(LeaseLand leaseLand) {
		this.leaseLand = leaseLand;
	}
	public Lessor(int lessor_id, String l_first_name, String l_last_name, long contact_number, String address,
			String location) {
		super();
		this.lessor_id = lessor_id;
		this.l_first_name = l_first_name;
		this.l_last_name = l_last_name;
		this.contact_number = contact_number;
		this.address = address;
		this.location = location;
	}
	public Lessor() {
		// TODO Auto-generated constructor stub
		
	}
	public int getLessor_id() {
		return lessor_id;
	}
	public void setLessor_id(int lessor_id) {
		this.lessor_id = lessor_id;
	}
	public String getL_first_name() {
		return l_first_name;
	}
	public void setL_first_name(String l_first_name) {
		this.l_first_name = l_first_name;
	}
	public String getL_last_name() {
		return l_last_name;
	}
	public void setL_last_name(String l_last_name) {
		this.l_last_name = l_last_name;
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
	
	
	
	
}
