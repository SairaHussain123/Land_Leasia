package com.candella.dao;

import java.util.List;
import java.util.Map;

import com.candella.entity.Auction;


public interface AuctionDao {
public void addAuction(Auction auction);
	
	


	public List<Auction> viewAllAuction();

public Auction getAuction(String auctionId);


    





	List<Auction> viewAuctionsAndBookings();
}



