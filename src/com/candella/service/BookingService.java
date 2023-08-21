package com.candella.service;

import java.util.List;

import com.candella.entity.Booking;

import com.candella.entity.LeaseLand;

public interface BookingService {
	

	void addBooking(Booking booking);
	
	public List<Booking> viewAllBooking();
public Booking getBooking(int Booking_id);


}
