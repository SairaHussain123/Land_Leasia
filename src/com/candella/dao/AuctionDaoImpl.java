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
import com.candella.entity.Auction;
import com.candella.entity.Booking;
import com.candella.entity.LeaseLand;

public class AuctionDaoImpl implements AuctionDao {

	@Override
	public void addAuction(Auction auction) {
		// TODO Auto-generated method stubpublic void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			Booking booking=new Booking();
			DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sqlQuery = "insert into Auction(auction_id,booking_id,date_of_auction,bid_amount)values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1,auction.getAuctionId());
			statement.setInt(2,auction.getBooking().getBookingId());
			Date date=Date.valueOf(auction.getAuctionDate());
			statement.setDate(3,date);
			
			statement.setLong(4,auction.getBidAmount());
			

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}


	

	@Override
	public List<Auction> viewAllAuction() {
		// TODO Auto-generated method stub
		 List<Auction> auctionList = new ArrayList<>();
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Auction");
		         ResultSet resultSet = preparedStatement.executeQuery()) {

		        while (resultSet.next()) {
		            Booking booking = new Booking();
		           

		            String auctionId = resultSet.getString("auction_id");
		            booking.setBookingId(resultSet.getInt("booking_id"));
		            LocalDate auctionDate = LocalDate.parse(resultSet.getString("date_of_auction"), format);
		            Long bidAmount=resultSet.getLong("bid_amount");
		           
		          
		           
		           
		            
		            

		            Auction auction = new Auction(auctionId,booking,auctionDate,bidAmount);
		            auctionList.add(auction);
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
		    return auctionList;
		

		
	}

	@Override
	public Auction getAuction(String auctionId) {
		// TODO Auto-generated method stub
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Auction WHERE auction_id = ?")) {

	        preparedStatement.setString(1, auctionId);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	               Booking booking=new Booking();

	                String auction_id = resultSet.getString("auction_id");
	                booking.setBookingId(resultSet.getInt("booking_id"));
	                LocalDate auctionDate = LocalDate.parse(resultSet.getString("date_of_auction"), format);
	                
	                long bidAmount = resultSet.getLong("bid_amount");
	               

	                return new Auction(auction_id,booking,auctionDate,bidAmount);
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return null; // Return null if no booking found
	
	}
	@Override

	public List<Auction> viewAuctionsAndBookings() {
	    List<Auction> auctionList = new ArrayList<>();

	    try {
	        Connection connection = DbConnectionPool.getDataSource().getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(
	            "SELECT auction.bid_amount, booking.booking_id, lease_land.lease_land_id " +
	            "FROM AUCTION " +
	            "JOIN booking ON auction.booking_id = booking.booking_id " +
	            "JOIN lease_land ON booking.lease_land_id = lease_land.lease_land_id");
	        
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            Long bidAmount = resultSet.getLong("bid_amount");

	            Booking booking = new Booking();
	            booking.setBookingId(resultSet.getInt("booking_id"));

	            LeaseLand leaseLand = new LeaseLand();
	            leaseLand.setLease_land_id(resultSet.getInt("lease_land_id"));
	            
	            booking.setLeaseLand(leaseLand);

	            Auction auction = new Auction(booking, bidAmount);
	            auctionList.add(auction);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error fetching auction and booking data: " + e.getMessage());
	        // Consider throwing or handling the exception more robustly
	    }
	    return auctionList;
	}


	}



