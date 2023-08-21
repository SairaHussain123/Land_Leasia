package com.candella.entity;

public class Buyer {
	private String buyer_id;
	public Buyer(String buyer_id, String buyer_first_name, String buyer_last_name, long contact_number, String mail_id,
			String address, String location) {
		super();
		this.buyer_id = buyer_id;
		this.buyer_first_name = buyer_first_name;
		this.buyer_last_name = buyer_last_name;
		this.contact_number = contact_number;
		this.mail_id = mail_id;
		this.address = address;
		this.location = location;
	}
	public Buyer() {
		// TODO Auto-generated constructor stub
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getBuyer_first_name() {
		return buyer_first_name;
	}
	public void setBuyer_first_name(String buyer_first_name) {
		this.buyer_first_name = buyer_first_name;
	}
	public String getBuyer_last_name() {
		return buyer_last_name;
	}
	public void setBuyer_last_name(String buyer_last_name) {
		this.buyer_last_name = buyer_last_name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
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
	private String buyer_first_name;
	private String buyer_last_name;
	private long contact_number;
	private String mail_id;
	private String address;
	private String location;
	


}
