package com.candella.service;

import java.rmi.dgc.Lease;
import java.util.List;

import com.candella.dao.Lease_Land_Dao;
import com.candella.dao.Lease_Land_DaoImpl;
import com.candella.entity.LeaseLand;

public class LeaseLandServiceImpl implements LeaseLandService {
	Lease_Land_DaoImpl lease_Land_DaoImpl=new Lease_Land_DaoImpl();
	public void addLeaseLand(LeaseLand leaseLand) {
		// TODO Auto-generated method stub
		lease_Land_DaoImpl.addLeaseLand(leaseLand);
	}

	

	public List<LeaseLand> viewAllLeaseLand() {
		// TODO Auto-generated method stub
		return lease_Land_DaoImpl.viewAllLeaseLand();
	}

	public LeaseLand getLeaseLand(String l_l_id) {
		// TODO Auto-generated method stub
		return lease_Land_DaoImpl.getLeaseLand(l_l_id);
	}






	

}
