package com.candella.dao;

import java.util.List;

import com.candella.entity.LeaseLand;

public interface Lease_Land_Dao {

	void addLeaseLand(LeaseLand leaseLand);


	List<LeaseLand> viewAllLeaseLand();

	LeaseLand getLeaseLand(String l_l_id);

	
}
