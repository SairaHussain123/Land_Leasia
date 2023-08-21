package com.candella.entity;

import java.util.List;

public class LeaseLand {
private int lease_land_id;
private Lessor lessor;

private Land land;

private String status;
private long rent_amount;


public LeaseLand(int lease_land_id, Lessor lessor, Land land, String status, int rent_amount) {
	super();
	this.lease_land_id = lease_land_id;
	this.lessor = lessor;
	this.land = land;
	this.status = status;
	this.rent_amount = rent_amount;
}
public LeaseLand() {
	// TODO Auto-generated constructor stub
	
}
public LeaseLand(String status2, long rentAmount) {
	this.status=status2;
	this.rent_amount=rentAmount;
}
public int getLease_land_id() {
	return lease_land_id;
}
public void setLease_land_id(int lease_land_id) {
	this.lease_land_id = lease_land_id;
}
public Lessor getLessor() {
	return lessor;
}
public void setLessor(Lessor lessor) {
	this.lessor = lessor;
}
public Land getLand() {
	return land;
}
public void setLand(Land land) {
	this.land = land;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public long getRent_amount() {
	return rent_amount;
}
public void setRent_amount(long newRent) {
	this.rent_amount = newRent;
}
public static List<Land> searchLands(String desiredLocation) {
	// TODO Auto-generated method stub
	return null;
}



}
