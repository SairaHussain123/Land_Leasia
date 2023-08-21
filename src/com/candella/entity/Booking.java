package com.candella.entity;

import java.time.LocalDate;

public class Booking {
private int bookingId;
private LeaseLand leaseLand;
private Buyer buyer;
private String bookingStatus ;
private LocalDate bookingDate;

public Booking(int bookingId, String bookingStatus) {
	super();
	this.bookingId = bookingId;
	this.bookingStatus = bookingStatus;
}
public Booking(int bookingId, LeaseLand leaseLand, Buyer buyer, String bookingStatus, LocalDate bookingDate) {
	super();
	this.bookingId = bookingId;
	this.leaseLand = leaseLand;
	this.buyer = buyer;
	this.bookingStatus = bookingStatus;
	this.bookingDate = bookingDate;
}
public Booking() {
	// TODO Auto-generated constructor stub
	
}
public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public LeaseLand getLeaseLand() {
	return leaseLand;
}
public void setLeaseLand(LeaseLand leaseLand) {
	this.leaseLand = leaseLand;
}
public Buyer getBuyer() {
	return buyer;
}
public void setBuyer(Buyer buyer) {
	this.buyer = buyer;
}
public String getBookingStatus() {
	return bookingStatus;
}
public void setBookingStatus(String bookingStatus) {
	this.bookingStatus = bookingStatus;
}
public LocalDate getBookingDate() {
	return bookingDate;
}
public void setBookingDate(LocalDate bookingDate) {
	this.bookingDate = bookingDate;
}

}
