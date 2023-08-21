package com.candella.service;

import java.util.List;

import com.candella.dao.LandDaoImpl;
import com.candella.entity.Land;

public class LandServiceImpl implements LandService {
	LandDaoImpl landDaoImpl=new LandDaoImpl();



	
	public void updateLand(int land_id, String column_name) {
		landDaoImpl.updateLand(land_id,column_name);
		return;
		
	}

	public List<Land> viewAllLand() {
		
		return landDaoImpl.viewAllLand();
	}

	public Land getLand(int land_id) {
		
		 return landDaoImpl.getLand(land_id);
	}

	@Override
	public void addLand(Land land) {
		// TODO Auto-generated method stub
		 landDaoImpl.addLand(land);
	}

	
}


