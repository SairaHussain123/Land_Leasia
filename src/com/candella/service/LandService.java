package com.candella.service;

import java.util.List;


import com.candella.entity.Land;



public interface LandService {
	public void addLand(Land land);
	public void updateLand(int land_id,String column_name);
	
	public List<Land> viewAllLand();
public Land getLand(int land_id);

}
