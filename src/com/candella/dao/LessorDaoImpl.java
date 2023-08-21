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

import com.candella.entity.Lessor;

public class LessorDaoImpl implements LessorDao {
Lessor lessor=null;

	public void addLessor(Lessor lessor) {
		List<Lessor> lessorList = new <Lessor>ArrayList();

		try {

			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into Lessor( lessor_id, l_first_name,  l_last_name, contact_number, address, location)values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, lessor.getLessor_id());
			statement.setString(2, lessor.getL_first_name());
			statement.setString(3, lessor.getL_last_name());
			statement.setLong(4, lessor.getContact_number());
			statement.setString(5, lessor.getAddress());
			statement.setString(6, lessor.getLocation());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return;
		// TODO Auto-generated method stub

	}

	public void updateLessor(String l_id, String column_name) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String tableName = "Lessor";

			System.out.println("the new value is :");
			String newValue = scanner.nextLine();

			String condition = "lessor_id=" + l_id;

			String updateQuery = "UPDATE " + tableName + " SET " + column_name + " = ? WHERE " + condition;

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, newValue);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Lessor> viewAllLessor() {
		List<Lessor> lessorList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String query = "SELECT*from Lessor";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery(query);

			while (resultSet.next()) {
				int l_id = resultSet.getInt("lessor_id");
				String f_name = resultSet.getString("l_first_name");
				String l_name = resultSet.getString("l_last_name");
				long c_number = resultSet.getLong("contact_number");
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");

				Lessor lessor = new Lessor(l_id, f_name, l_name, c_number, address, location);
				lessorList.add(lessor);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return lessorList;
	}

	@Override
	public  Lessor getLessor(String lessor_id) {
		
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			System.out.println(lessor_id);

			String query = "SELECT * FROM Lessor WHERE lessor_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, lessor_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) 
			{
				int l_id = resultSet.getInt("lessor_id");
				String f_name = resultSet.getString("l_first_name");
				String l_name = resultSet.getString("l_last_name");
				long c_number = resultSet.getLong("contact_number");
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");

				lessor = new Lessor(l_id, f_name, l_name, c_number, address, location);
			

			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return lessor;
		

	}

	

	

}
