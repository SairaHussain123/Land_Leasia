package com.candella.entity;

import java.time.LocalDate;

public class Payment {
private int paymentId;
private Agreement agreement;
private Long amountPaid;
private String paymentMethod;
private String paymentReference;
private Long remainingPayment;
private LocalDate paymentDate;

public Payment(int paymentId, Agreement agreement, Long amountPaid, String paymentMethod, String paymentReference,
		Long remainingPayment, LocalDate paymentDate) {
	super();
	this.paymentId = paymentId;
	this.agreement = agreement;
	this.amountPaid = amountPaid;
	this.paymentMethod = paymentMethod;
	this.paymentReference = paymentReference;
	this.remainingPayment = remainingPayment;
	this.paymentDate = paymentDate;
}
public Payment(int paymentId2, int agreementId, Long paidAmount, String paymentMethod2, String paymentReference2,
		Long remainingPayment2, LocalDate pDate) {
	// TODO Auto-generated constructor stub
}
public Payment() {
	// TODO Auto-generated constructor stub
}

public int getPaymentId() {
	return paymentId;
}
public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}
public Agreement getAgreement() {
	return agreement;
}
public void setAgreement(Agreement agreement) {
	this.agreement = agreement;
}
public Long getAmountPaid() {
	return amountPaid;
}
public void setAmountPaid(Long amountPaid) {
	this.amountPaid = amountPaid;
}
public String getPaymentMethod() {
	return paymentMethod;
}
public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}
public String getPaymentReference() {
	return paymentReference;
}
public void setPaymentReference(String paymentReference) {
	this.paymentReference = paymentReference;
}
public Long getRemainingPayment() {
	return remainingPayment;
}
public void setRemainingPayment(Long remainingPayment) {
	this.remainingPayment = remainingPayment;
}
public LocalDate getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(LocalDate paymentDate) {
	this.paymentDate = paymentDate;
}


}
