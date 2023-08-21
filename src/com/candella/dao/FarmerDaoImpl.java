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
import com.candella.entity.Farmer;

public class FarmerDaoImpl implements FarmerDao {

	
	public void addFarmer(Farmer farmer) {
	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String sqlQuery = "INSERT INTO Farmer(farmer_id, first_name, last_name, contact_number, address, location, specialized_in) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(sqlQuery);
	        statement.setString(1, farmer.getFarmer_id());
	        statement.setString(2, farmer.getFirst_name());
	        statement.setString(3, farmer.getLast_name());
	        statement.setLong(4, farmer.getContact_number());
	        statement.setString(5, farmer.getAddress());
	        statement.setString(6, farmer.getLocation());
	        statement.setString(7, farmer.getSpecializedIn()); // Set the specializedIn value

	        statement.executeUpdate();

	        connection.close();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}


	public void updateFarmer(String f_id, String column_name) {
	    try {
	        Scanner scanner = new Scanner(System.in);
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();
	        String tableName = "Farmer";

	        System.out.println("the new value is:");
	        String newValue = scanner.nextLine();

	        String condition = "farmer_id=" + f_id;

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
	
	public List<Farmer> viewAllFarmer() {
	    List<Farmer> farmerList = new ArrayList<>();
	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String query = "SELECT * FROM Farmer";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);

	        ResultSet resultSet = preparedStatement.executeQuery(query);

	        while (resultSet.next()) {
	            String f_id = resultSet.getString("farmer_id");
	            String f_name = resultSet.getString("first_name");
	            String l_name = resultSet.getString("last_name");
	            long c_number = resultSet.getLong("contact_number");
	            String address = resultSet.getString("address");
	            String location = resultSet.getString("location");
	            String specializedIn = resultSet.getString("specialized_in"); // Get specializedIn value

	            Farmer farmer = new Farmer(f_id, f_name, l_name, c_number, address, location,specializedIn);
	            farmer.setSpecializedIn(specializedIn); // Set specializedIn value
	            farmerList.add(farmer);
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return farmerList;
	}


		
	@Override
	
	public Farmer getFarmer(String farmer_id) {
	    
	    try {
	        Connection connection = null;
	        DataSource ds = DbConnectionPool.getDataSource();
	        connection = ds.getConnection();
Farmer farmer=null;
	        String query = "SELECT * FROM Farmer WHERE farmer_id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, farmer_id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            String f_id1 = resultSet.getString("farmer_id");
	            String f_name = resultSet.getString("first_name");
	            String l_name = resultSet.getString("last_name");
	            long c_number = resultSet.getLong("contact_number");
	            String address = resultSet.getString("address");
	            String location = resultSet.getString("location");
	            String specializedIn = resultSet.getString("specialized_in"); // Get specializedIn value

	            farmer = new Farmer(f_id1, f_name, l_name, c_number, address, location,specializedIn);
	            farmer.setSpecializedIn(specializedIn); // Set specializedIn value
	        }
	        return farmer;
		

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		return null;
	    

	

	}


	@Override
	public List<Farmer> viewFarmerBySpecialization(String specialization) {
	    List<Farmer> farmersWithSpecialization = new ArrayList<>();
	    
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM farmer WHERE specialized_in = ?")) {
	        
	        preparedStatement.setString(1, specialization);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            String farmer_id = resultSet.getString("farmer_id");
	            String first_name = resultSet.getString("first_name");
	            String last_name = resultSet.getString("last_name");
	            long contact_number = resultSet.getLong("contact_number");
	            String address = resultSet.getString("address");
	            String location = resultSet.getString("location");
	            String specializedIn = resultSet.getString("specialized_in");
	            
	            Farmer farmer = new Farmer(farmer_id, first_name, last_name, contact_number, address, location,specializedIn);
	            farmer.setSpecializedIn(specializedIn);
	            farmersWithSpecialization.add(farmer);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return farmersWithSpecialization;
	}


	}
