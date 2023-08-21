package com.candella.entity;

import java.util.List;

public class Land {
	private int land_id;
	
	
	public Land(int land_id, String land_address, String location, String land_area, String cultivation_suitable_for,
			String soil_type) {
		super();
		this.land_id = land_id;
		this.land_address = land_address;
		this.location = location;
		this.land_area = land_area;
		this.cultivation_suitable_for = cultivation_suitable_for;
		this.soil_type = soil_type;
	}
	
	public Land() {
		// TODO Auto-generated constructor stub
		
	}

	public int getLand_id() {
		return land_id;
	}
	public void setLand_id(int land_id) {
		this.land_id = land_id;
	}
	public String getLand_address() {
		return land_address;
	}
	public void setLand_address(String land_address) {
		this.land_address = land_address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLand_area() {
		return land_area;
	}
	public void setLand_area(String land_area) {
		this.land_area = land_area;
	}
	public String getCultivation_suitable_for() {
		return cultivation_suitable_for;
	}
	public void setCultivation_suitable_for(String cultivation_suitable_for) {
		this.cultivation_suitable_for = cultivation_suitable_for;
	}
	public String getSoil_type() {
		return soil_type;
	}
	public void setSoil_type(String soil_type) {
		this.soil_type = soil_type;
	}
	private String land_address;
	private String location;
	private String land_area;
	private String cultivation_suitable_for;
	private String soil_type;


	public Land(String land_address, String location, String cultivation_suitable_for) {
		super();
		this.land_address = land_address;
		this.location = location;
		this.cultivation_suitable_for = cultivation_suitable_for;
	}

	public static List<Land> searchLands(String desiredLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
