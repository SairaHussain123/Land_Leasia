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
import com.candella.entity.Agreement;
import com.candella.entity.Booking;



public class AgreementDaoImpl implements AgreementDao {

	public void addAgreement(Agreement agreement) {
		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			Booking booking = new Booking();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sqlQuery = "INSERT INTO Lease_Agreement (agreement_id, booking_id, start_date, end_date, lease_amount, payment_frequency, lease_status, `T&c`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, agreement.getAgreementId());
			statement.setInt(2, agreement.getBooking().getBookingId());
			Date sdate = Date.valueOf(agreement.getStartDate());
			statement.setDate(3, sdate);
			Date edate = Date.valueOf(agreement.getEndDate());
			statement.setDate(4, edate);
			statement.setInt(5, agreement.getLeaseAmount());
			statement.setString(6, agreement.getPaymentFrequency());
			statement.setString(7, agreement.getLeaseStatus());
			statement.setString(8, agreement.getTandC());
			;

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Agreement> viewAllAgreement() {
	    List<Agreement> agreementList = new ArrayList<>();
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Lease_Agreement");
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            Booking booking = new Booking();
	            int agreementId = resultSet.getInt("agreement_id");
	            booking.setBookingId(resultSet.getInt("booking_id"));
	            LocalDate startDate = LocalDate.parse(resultSet.getString("start_date"), format);
	            LocalDate endDate = LocalDate.parse(resultSet.getString("end_date"), format);
	            int leaseAmount = resultSet.getInt("lease_amount");
	            String paymentFrequency = resultSet.getString("payment_frequency");
	            String leaseStatus = resultSet.getString("lease_status");
	            String tandC = resultSet.getString("T&C");
	            Agreement agreement = new Agreement(agreementId, booking, startDate, endDate, leaseAmount, paymentFrequency, leaseStatus, tandC);
	            agreementList.add(agreement);
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return agreementList;
	}

		
		
		
		
	

	@Override
	public Agreement getAgreement(int agreementId) {
		// TODO Auto-generated method stub
		 Agreement agreement= null;
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String query = "SELECT * FROM Lease_Agreement WHERE agreement_id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, agreementId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	           
	        	Booking booking=new Booking();
	            int agreementid = resultSet.getInt("agreement_id");
	            booking.setBookingId(resultSet.getInt("booking_id"));
	            LocalDate startDate = LocalDate.parse(resultSet.getString("start_date"), format);
	            LocalDate endDate = LocalDate.parse(resultSet.getString("end_date"), format);

	           
	            int leaseAmount = resultSet.getInt("lease_amount");
	            String paymentFrequency = resultSet.getString("payment_frequency");
	            String leaseStatus = resultSet.getString("lease_status");
	            String TandC =resultSet.getString("T&C");
	            
	            agreement = new Agreement(agreementid,booking,startDate,endDate,leaseAmount,paymentFrequency,leaseStatus,TandC);
	        }

	       
	        preparedStatement.close();
	        connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return agreement;
	}
	
	}


