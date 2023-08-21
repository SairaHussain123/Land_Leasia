package com.candella.dao;

import com.candella.entity.Agreement;
import com.candella.entity.Payment;

public interface PaymentDao {
	public void addPayment(Payment payment);

	

	Payment getPayment(int paymentId);

}
