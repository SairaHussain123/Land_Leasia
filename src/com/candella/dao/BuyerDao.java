package com.candella.dao;

import java.util.List;

import com.candella.entity.Booking;
import com.candella.entity.Buyer;

public interface BuyerDao {

	public void addBuyer(Buyer buyer);

	public List<Buyer> viewAllBuyer();
	void updateBuyer(String b_id, String column_name);


	Buyer getBuyer(String buyer_id);
	Booking displayStatus(String booking);
}
