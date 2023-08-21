package com.candella.dao;

import java.util.List;

import com.candella.entity.Booking;
import com.candella.entity.LeaseLand;

public interface Booking_Dao {
	public void addBooking(Booking booking);
	
	


	public List<Booking> viewAllBooking();

public Booking getBooking(int bookingId);


	
}
