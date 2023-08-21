package com.candella.entity;

import java.time.LocalDate;



public class Auction {

	private String auctionId;
	public Auction(String auctionId, Booking booking, LocalDate auctionDate, Long bidAmount) {
		super();
		this.auctionId = auctionId;
		this.booking = booking;
		this.auctionDate = auctionDate;
		this.bidAmount = bidAmount;
	}
	
	public Auction(Booking booking, Long bidAmount) {
		this.booking = booking;
		this.bidAmount = bidAmount;
	}

	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public LocalDate getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(LocalDate auctionDate) {
		this.auctionDate = auctionDate;
	}
	public Long getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Long bidAmount) {
		this.bidAmount = bidAmount;
	}
	private Booking booking;
	private LocalDate auctionDate;
	private Long bidAmount;

   
}
    
