package com.candella.entity;

import java.time.LocalDate;

public class Agreement {
	
	private int agreementId;
	public Agreement(int agreementId, Booking booking, LocalDate startDate, LocalDate endDate, int leaseAmount,
			String paymentFrequency, String leaseStatus, String tandC) {
		super();
		this.agreementId = agreementId;
		this.booking = booking;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaseAmount = leaseAmount;
		this.paymentFrequency = paymentFrequency;
		this.leaseStatus = leaseStatus;
		this.TandC = tandC;
	}
	public Agreement() {
		// TODO Auto-generated constructor stub
		
	}
	private Booking booking;
	private LocalDate startDate;
	private LocalDate endDate;
	private int leaseAmount;
	private String paymentFrequency;
	private String leaseStatus;
	private String TandC;

	
	public int getAgreementId() {
		return agreementId;
	}
	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getLeaseAmount() {
		return leaseAmount;
	}
	public void setLeaseAmount(int leaseAmount) {
		this.leaseAmount = leaseAmount;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public String getLeaseStatus() {
		return leaseStatus;
	}
	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}
	public String getTandC() {
		return TandC;
	}
	public void setTandC(String tandC) {
		TandC = tandC;
	}
	
}
