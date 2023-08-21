package com.candella.service;

import java.util.List;

import com.candella.dao.PaymentDaoImpl;
import com.candella.entity.Payment;

public class PaymentServiceImpl implements PaymentService {
PaymentDaoImpl paymentDaoImpl=new PaymentDaoImpl();
	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentDaoImpl.addPayment(payment);
		
	}
	public Payment getPayment(int paymentid) {
		// TODO Auto-generated method stub
		
		return paymentDaoImpl.getPayment(paymentid);
	}
	public List<Payment> viewAllPayment() {
		
		return paymentDaoImpl.viewAllPayment();
	}

}
