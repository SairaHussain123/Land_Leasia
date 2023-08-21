package com.candella.service;

import java.util.List;

import com.candella.entity.Agreement;

public interface AgreementService {
	
	public void addAgreement(Agreement agreement);
	List<Agreement>viewAllAgreement();
	public Agreement getAgreement(int agreementId);
	}
