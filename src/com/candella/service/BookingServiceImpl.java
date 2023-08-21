package com.candella.service;

import java.util.List;

import com.candella.dao.BookingDaoImpl;
import com.candella.entity.Booking;


public class BookingServiceImpl implements BookingService {
BookingDaoImpl bookingDaoImpl=new BookingDaoImpl();
	public void addBooking(Booking booking) {

		bookingDaoImpl.addBooking(booking);
		return;
		
	}

	public List<Booking> viewAllBooking() {
		// TODO Auto-generated method stub
		return bookingDaoImpl.viewAllBooking(); 
		
	}

	public Booking getBooking(int bookingId) {
		// TODO Auto-generated method stub
		 return bookingDaoImpl.getBooking(bookingId);
			
		
	}


	








}


	
	


