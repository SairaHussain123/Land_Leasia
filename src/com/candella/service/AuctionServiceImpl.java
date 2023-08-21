package com.candella.service;

import java.util.List;
import java.util.Map;

import com.candella.dao.AuctionDaoImpl;
import com.candella.entity.Auction;


public class AuctionServiceImpl implements AuctionService {


	AuctionDaoImpl auctionDaoImpl=new AuctionDaoImpl();

	public List<Auction> viewAllAuction() {
		// TODO Auto-generated method stub
		return auctionDaoImpl.viewAllAuction();
		 
	}

	public void addAuction(Auction auction) {
		// TODO Auto-generated method stub
		auctionDaoImpl.addAuction(auction);
		
	}

	@Override
	public Auction getAuction(String auctionId) {
		// TODO Auto-generated method stub
		auctionDaoImpl.getAuction(auctionId);;
		return null;
	}

	  
	    public List<Auction> viewAuctionsAndBookings() {
	    	return auctionDaoImpl.viewAuctionsAndBookings();
	    }
	}



	
	


