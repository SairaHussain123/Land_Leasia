package com.candella.service;

import java.util.List;

import com.candella.dao.FarmerDaoImpl;
import com.candella.entity.Farmer;

public class FarmerServiceImpl implements FarmerService {
FarmerDaoImpl farmerDaoImpl=new FarmerDaoImpl();

@Override
public void addFarmer(Farmer farmer) {
	// TODO Auto-generated method stub
	farmerDaoImpl.addFarmer(farmer);
	return;
}

public void updateFarmer(String f_id,String column_name) 
{
farmerDaoImpl.updateFarmer(f_id,column_name);
return;
	
}

@Override
public List <Farmer> viewAllFarmer() 
{

	
	return farmerDaoImpl.viewAllFarmer(); 
}

@Override
public Farmer getFarmer(String farmer_id) {
	 return farmerDaoImpl.getFarmer(farmer_id);
	
	
}





}
