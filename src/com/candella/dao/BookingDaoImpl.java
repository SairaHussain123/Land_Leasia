package com.candella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DbConnectionPool;
import com.candella.entity.Booking;
import com.candella.entity.Buyer;
import com.candella.entity.LeaseLand;
import com.candella.entity.Lessor;

public class BookingDaoImpl implements Booking_Dao {

	Booking booking=new Booking();;
		
	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			LeaseLand leaseLand=new LeaseLand();
			Buyer buyer =new Buyer();
			DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sqlQuery = "insert into Booking(booking_id,lease_land_id,buyer_id,booking_status,booking_date)values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,booking.getBookingId());
			statement.setInt(2,booking.getLeaseLand().getLease_land_id());
			statement.setString(3,booking.getBuyer().getBuyer_id());
			statement.setString(4, booking.getBookingStatus());
			Date date=Date.valueOf(booking.getBookingDate());
			statement.setDate(5,date);
			

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}


	public List<Booking> viewAllBooking() {
	    List<Booking> bookingList = new ArrayList<>();
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Booking");
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            Buyer buyer = new Buyer();
	            LeaseLand leaseLand = new LeaseLand();

	            int bookingId = resultSet.getInt("booking_id");
	            leaseLand.setLease_land_id(resultSet.getInt("lease_land_id"));
	            buyer.setBuyer_id(resultSet.getString("buyer_id"));
	            String status = resultSet.getString("booking_status");
	            LocalDate bDate = LocalDate.parse(resultSet.getString("booking_date"), format);

	            Booking booking = new Booking(bookingId, leaseLand, buyer, status, bDate);
	            bookingList.add(booking);
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return bookingList;
	}

	public Booking getBooking(int bookingId) {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Booking WHERE booking_id = ?")) {

	        preparedStatement.setInt(1, bookingId);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                Buyer buyer = new Buyer();
	                LeaseLand leaseLand = new LeaseLand();

	                int bookingIdd = resultSet.getInt("booking_id");
	                leaseLand.setLease_land_id(resultSet.getInt("lease_land_id"));
	                buyer.setBuyer_id(resultSet.getString("buyer_id"));
	                String status = resultSet.getString("booking_status");
	                LocalDate bDate = LocalDate.parse(resultSet.getString("booking_date"), format);

	                return new Booking(bookingIdd, leaseLand, buyer, status, bDate);
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return null ; // Return null if no booking found
	}

	}



		
	
	
	


