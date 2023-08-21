package com.candella.service;

import java.util.List;

import com.candella.dao.BuyerDaoImpl;
import com.candella.entity.Buyer;

public class BuyerServiceImpl implements BuyerService {
	BuyerDaoImpl buyerDaoImpl = new BuyerDaoImpl();

	@Override
	public void addBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Buyer> viewAllBuyer() {
		// TODO Auto-generated method stub
		buyerDaoImpl.viewAllBuyer();
		return null;
	}

	@Override
	public void updateBuyer(String b_id, String column_name) {
		// TODO Auto-generated method stub
		buyerDaoImpl.updateBuyer(b_id, column_name);
	}

	

	@Override
	public Buyer getBuyer(String buyer_id) {
		// TODO Auto-generated method stub
		buyerDaoImpl.getBuyer(buyer_id);
		return null;
	}

	@Override
	public Buyer getbuyer(String buyer_id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void updateProfile(Buyer buyer) {
		// TODO Auto-generated method stub
		
	}

}
	