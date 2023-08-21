package com.candella.service;

import java.util.List;
import java.util.Map;

import com.candella.entity.Auction;


public interface AuctionService {
void addAuction(Auction auction);
	
	public List<Auction> viewAllAuction();
public Auction getAuction(String auctionId);



}
