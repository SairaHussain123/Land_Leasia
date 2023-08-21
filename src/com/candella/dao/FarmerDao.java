package com.candella.dao;

import java.util.List;

import com.candella.entity.Farmer;

public interface FarmerDao {
	public void addFarmer(Farmer farmer);
	public void updateFarmer(String f_id,String column_name);


	public List<Farmer> viewAllFarmer();

public Farmer getFarmer(String farmer_id);
List<Farmer> viewFarmerBySpecialization(String specialization) ;
	
	
}
