package com.candella.service;

import java.rmi.dgc.Lease;
import java.util.List;


import com.candella.entity.LeaseLand;



public interface LeaseLandService {
	public void addLeaseLand(LeaseLand leaseLand);
	
	public List<LeaseLand> viewAllLeaseLand();
public LeaseLand getLeaseLand(String l_l_id);

}
