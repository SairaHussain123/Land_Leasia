package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DbConnectionPool;
import com.candella.entity.Booking;
import com.candella.entity.Buyer;
import com.candella.entity.Land;

public class BuyerDaoImpl implements BuyerDao {
	@Override
	public void addBuyer(Buyer buyer) {
		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into Buyer( buyer_id, buyer_first_name,  buyer_last_name, contact_number,mail_id, address, location)values(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1,buyer.getBuyer_id());
			statement.setString(2, buyer.getBuyer_first_name());
			statement.setString(3, buyer.getBuyer_last_name());
			statement.setLong(4, buyer.getContact_number());
			statement.setString(5, buyer.getMail_id());
			statement.setString(6, buyer.getAddress());
			statement.setString(7, buyer.getLocation());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}


	

	@Override
	public List<Buyer> viewAllBuyer() {
	{
			List<Buyer> buyerList = new ArrayList<>();
			try {
				Connection connection = null;
				DataSource ds = DbConnectionPool.getDataSource();
				connection = ds.getConnection();

				String query = "SELECT*from Buyer";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					String b_id = resultSet.getString("buyer_id");
					String f_name = resultSet.getString("buyer_first_name");
					String l_name = resultSet.getString("buyer_last_name");
					long c_number = resultSet.getLong("contact_number");
					String mail_id=resultSet.getString("mail_id");
					String address = resultSet.getString("address");
					String location = resultSet.getString("location");

					Buyer buyer = new Buyer(b_id, f_name, l_name, c_number,mail_id, address, location);
					buyerList.add(buyer);

				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
			return buyerList;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBuyer(String b_id,String column_name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Buyer buyer=null;
				try {
					Scanner scanner = new Scanner(System.in);
					Connection connection = null;
					DataSource ds = DbConnectionPool.getDataSource();
					connection = ds.getConnection();
					String tableName = "Buyer";

					System.out.println("the new value is :");
					String newValue = scanner.nextLine();

					String condition = "buyer_id=" + b_id;

					String updateQuery = "UPDATE " + tableName + " SET " + column_name + " = ? WHERE " + condition;

					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
					preparedStatement.setString(1, newValue);

					int rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected + " row(s) updated.");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		
	}




	@Override
	public Buyer getBuyer(String buyer_id) {
		Buyer buyer=null;
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			System.out.println(buyer_id);

			String query = "SELECT * FROM Buyer WHERE buyer_id= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, buyer_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) 
			{
				String b_id = resultSet.getString("buyer_id");
				String f_name = resultSet.getString("buyer_first_name");
				String l_name = resultSet.getString("buyer_last_name");
				long c_number = resultSet.getLong("contact_number");
				String mail_id=resultSet.getString("mail_id");
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");

				buyer = new Buyer(b_id, f_name, l_name, c_number,mail_id, address, location);
			

			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	
		return buyer;
		

	}


	

	

	    

	    
	public boolean updateProfile(Buyer buyer) {
	    String sql = "UPDATE buyers SET buyer_first_name = ?, buyer_last_name = ?, contact_number = ?, " +
	                 "mail_id = ?, address = ?, location = ? WHERE buyer_id = ?";
	    
	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, buyer.getBuyer_first_name());
	        preparedStatement.setString(2, buyer.getBuyer_last_name());
	        preparedStatement.setLong(3, buyer.getContact_number());
	        preparedStatement.setString(4, buyer.getMail_id());
	        preparedStatement.setString(5, buyer.getAddress());
	        preparedStatement.setString(6, buyer.getLocation());
	        preparedStatement.setString(7, buyer.getBuyer_id());

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }}
	    
	   
	List<Land> searchLands(String desiredLocation) {
	    List<Land> matchingLands = new ArrayList<>();

	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String sql = "SELECT location, land_address, cultivation_suitable_for FROM lands WHERE location = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, desiredLocation);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    String location = resultSet.getString("location");
	                    String landAddress = resultSet.getString("land_address");
	                    String cultivationSuitableFor = resultSet.getString("cultivation_suitable_for");
	                    Land land = new Land(location, landAddress, cultivationSuitableFor);
	                    matchingLands.add(land);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return matchingLands;
	}




	@Override
	public Booking displayStatus(String bookingId) {
	
		   {
		        Booking bookingStatus = null;

		        try {
			        Connection connection = null;
			        DataSource ds = DbConnectionPool.getDataSource();
			        connection = ds.getConnection();
		            String sql = "SELECT booking_id, booking_status FROM booking WHERE booking_id = ?";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		                preparedStatement.setString(1, bookingId);
		                try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                    if (resultSet.next()) {
		                        int retrievedBookingId = resultSet.getInt("booking_id");
		                        String status = resultSet.getString("booking_status");
		                        bookingStatus = new Booking(retrievedBookingId, status);
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return bookingStatus;
		    }
		

	}}

	   

	      


	


	


	
	
	
	
	

