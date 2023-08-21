package com.candella.service;

import java.util.List;

import com.candella.dao.AgreementDaoImpl;
import com.candella.entity.Agreement;

public class AgreementServiceImpl implements AgreementService {
AgreementDaoImpl agreementDaoImpl=new AgreementDaoImpl();
	public void addAgreement(Agreement agreement) {
		// TODO Auto-generated method stub
		agreementDaoImpl.addAgreement(agreement);	}
	@Override
	public List<Agreement> viewAllAgreement() {
		// TODO Auto-generated method stub
	return	agreementDaoImpl.viewAllAgreement();
		
	}
	public Agreement getAgreement(int agreementId) {
		// TODO Auto-generated method stub
		return agreementDaoImpl.getAgreement(agreementId);
	}

}
