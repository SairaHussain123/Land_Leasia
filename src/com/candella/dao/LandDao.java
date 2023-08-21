package com.candella.dao;


import java.util.List;

import com.candella.entity.Land;

public interface LandDao {
public void addLand(Land land);
public void updateLand(int land_id,String column_name);
	 public Land getLand(int land_id);

	public List<Land> viewAllLand();

}
