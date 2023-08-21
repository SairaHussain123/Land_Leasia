package com.candella.dao;

import java.util.List;

import com.candella.entity.Agreement;
import com.candella.entity.Booking;

public interface AgreementDao {
public void addAgreement(Agreement agreement);
	
	

	 List<Agreement> viewAllAgreement();

public Agreement getAgreement(int agreementId);



}
