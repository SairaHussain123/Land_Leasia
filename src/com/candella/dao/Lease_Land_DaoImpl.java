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
import com.candella.entity.Land;
import com.candella.entity.LeaseLand;
import com.candella.entity.Lessor;

public class Lease_Land_DaoImpl implements Lease_Land_Dao {
	List<LeaseLand> leaseLandList = new <LeaseLand>ArrayList();
	
	@Override
	public void addLeaseLand(LeaseLand leaseLand) {
		// TODO Auto-generated method stub
		List<LeaseLand> leaseLandList = new <LeaseLand>ArrayList();

		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into Lease_Land(lease_land_id,lessor_id,land_id,status,rent_amount)values(?,?,?,?,?)";
		    PreparedStatement statement = connection.prepareStatement(sqlQuery);
		    Lessor lessor_id=new Lessor();
			
			Land land_id=new Land();
			
			statement.setInt(1,leaseLand.getLease_land_id());
			statement.setInt(2,leaseLand.getLessor().getLessor_id());
			statement.setInt(3,leaseLand.getLand().getLand_id());
			statement.setString(4,leaseLand.getStatus());
			statement.setLong(5,leaseLand.getRent_amount());
	

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}

	

	
	
		
	

	@Override
	public List<LeaseLand> viewAllLeaseLand() {
		
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String query = "SELECT*from lease_land";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery(query);

			while (resultSet.next()) {
				Lessor lessor_id=new Lessor();
				
				Land land_id=new Land();
				
				int l_l_id = resultSet.getInt("lease_land_id");
				lessor_id.setLessor_id(resultSet.getInt("lessor_id"));
				land_id.setLand_id(resultSet.getInt("land_id"));
				
				String status = resultSet.getString("status");
				int rent_amount = resultSet.getInt("rent_amount");
				
				LeaseLand leaseLand = new LeaseLand(l_l_id,lessor_id,land_id,status,rent_amount);
				leaseLandList.add(leaseLand);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return leaseLandList;
	}
	
	

	@Override
	public LeaseLand getLeaseLand(String l_l_id) {
		// TODO Auto-generated method stubFarmer farmer = null;
		// TODO Auto-generated method stub
		LeaseLand leaseLand = null;
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			System.out.println(l_l_id);

			String query = "SELECT * FROM lease_land WHERE lease_land_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,l_l_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) 
			{
				 Lessor lessor_id=new Lessor();
					
					Land land_id=new Land();
					
				int l_l_id1 = resultSet.getInt("lease_land_id");
				lessor_id.setLessor_id(resultSet.getInt("lessor_id"));
				land_id.setLand_id(resultSet.getInt("land_id"));
				String status = resultSet.getString("status");
				int rent_amount = resultSet.getInt("rent_amount");
				

				leaseLand = new LeaseLand(l_l_id1,lessor_id, land_id,status,rent_amount);
			

			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return leaseLand;
		

	

		
	}

}
