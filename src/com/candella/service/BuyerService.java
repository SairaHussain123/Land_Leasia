package com.candella.service;

import java.util.List;

import com.candella.entity.Buyer;

public interface BuyerService {
	

	void addBuyer(Buyer buyer);

public List<Buyer> viewAllBuyer();

void updateBuyer(String b_id, String column_name);

 public Buyer getbuyer(String buyer_id);

Buyer getBuyer(String buyer_id);

}
