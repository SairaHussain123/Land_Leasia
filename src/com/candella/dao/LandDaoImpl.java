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

public class LandDaoImpl implements LandDao {

	public void addLand(Land land) {
		List<Land> landList = new <Land>ArrayList();

		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into Land(land_id,land_address,location,land_area,cultivation_suitable_for,soil_type)values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,land.getLand_id());
			statement.setString(2,land.getLand_address());
			statement.setString(3,land.getLocation());
			statement.setString(4,land.getLand_area());
			statement.setString(5,land.getCultivation_suitable_for());
			statement.setString(6,land.getSoil_type());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}

	public void updateLand(int land_id, String column_name) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String tableName = "Land";

			System.out.println("the new value is :");
			String newValue = scanner.nextLine();

			String condition = "land_id=" +land_id;

			String updateQuery = "UPDATE" + tableName + " SET " + column_name + " = ? WHERE " + condition;

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, newValue);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Land> viewAllLand() {
		List<Land> landList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String query = "SELECT*from Land";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery(query);

			while (resultSet.next()) {
				int land_id = resultSet.getInt("land_id");
				String address = resultSet.getString("land_address");
				String location = resultSet.getString("location");
				String land_area = resultSet.getString("land_area");
				String csf = resultSet.getString("cultivation_suitable_for");
				String soil_type = resultSet.getString("soil_type");

				Land land  = new Land(land_id,address,location,land_area,csf,soil_type);
				landList.add(land);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return landList;
	}

	@Override
	public  Land getLand(int land_id) {
		Land land = null;
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			System.out.println(land_id);

			String query = "SELECT * FROM Land WHERE land_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,land_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) 
			{
				int land_id1 = resultSet.getInt("land_id");
				String land_address = resultSet.getString("land_address");
				String location = resultSet.getString("location");
				String land_area = resultSet.getString("land_area");
				String cultivation_suitable_for = resultSet.getString("cultivation_suitable_for");
				String soil_type = resultSet.getString("soil_type");

				land = new Land(land_id1,land_address, location,land_area,cultivation_suitable_for,soil_type);
			

			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return land;
		

	}

	
}
