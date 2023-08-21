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
import com.candella.entity.Payment;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void addPayment(Payment payment) {
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sqlQuery = "INSERT INTO payment (payment_id, agreement_id, amount_paid, payment_method, payment_references, remaining_payment, payment_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, payment.getPaymentId());
			statement.setInt(2, payment.getAgreement().getAgreementId());
			statement.setLong(3, payment.getAmountPaid());
			statement.setString(4, payment.getPaymentMethod());
			statement.setString(5, payment.getPaymentReference());
			statement.setLong(6, payment.getRemainingPayment());
			Date paymntdate = Date.valueOf(payment.getPaymentDate());
			statement.setDate(7, paymntdate);

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return;
	}

	public List<Payment> viewAllPayment() {
		List<Payment> paymentList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (Connection connection = DbConnectionPool.getDataSource().getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int paymentId = resultSet.getInt("payment_id");
				Agreement agreement = new Agreement();

				agreement.setAgreementId(resultSet.getInt("agreement_id"));

				Long amountPaid = resultSet.getLong("amount_paid");
				String paymentMethod = resultSet.getString("payment_method");
				String paymentReference = resultSet.getString("payment_references");
				Long remainingPayment = resultSet.getLong("remaining_payment");
				LocalDate paymentDate = LocalDate.parse(resultSet.getString("payment_date"), format);

				Payment payment = new Payment(paymentId,agreement,amountPaid,paymentMethod,paymentReference,remainingPayment,
						paymentDate);
				paymentList.add(payment);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return paymentList;
	}

	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		Agreement agreement = new Agreement();
		Payment payment = new Payment();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();

			String query = "SELECT * FROM payment WHERE payment_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, paymentId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				
				int paymntId = resultSet.getInt("payment_id");
				agreement.setAgreementId(resultSet.getInt("agreement_id"));
				
				
				Long amountPaid = resultSet.getLong("amount_paid");
				String paymentMethod = resultSet.getString("payment_method");
				String paymentReference = resultSet.getString("payment_references");
				Long remainingPayment = resultSet.getLong("remaining_payment");
				LocalDate paymentDate = LocalDate.parse(resultSet.getString("payment_date"), format);

				payment = new Payment(paymntId,agreement,amountPaid,paymentMethod,paymentReference,remainingPayment,
						paymentDate);
			}

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return payment;
	}

}
