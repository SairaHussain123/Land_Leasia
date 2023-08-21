package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.candella.dbconnectionpool.DbConnectionPool;
import com.candella.entity.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean registerUser() {
		Login login =null;
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	        String sql = "INSERT INTO users (username, password, user_type) VALUES (?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);

	        preparedStatement.setString(1, login.getUserName());
	        preparedStatement.setString(2, login.getPassword());
	        preparedStatement.setString(3, login.getUserType());

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	

	

	    public String getUserType(String username, String password) {
	       

	        String userType = null;
			try(Connection connection = DbConnectionPool.getDataSource().getConnection()){
{
	            String sql = "SELECT user_type FROM login WHERE username = ? AND password = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                preparedStatement.setString(1, username);
	                preparedStatement.setString(2, password);
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    if (resultSet.next()) {
	                       userType = resultSet.getString("user_type");
	                    }
	                }
	            }
	        }} catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return userType;
	    
	

	
	}}
		





