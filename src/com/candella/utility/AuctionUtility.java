package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.candella.entity.Auction;
import com.candella.entity.Booking;
import com.candella.service.AuctionServiceImpl;


public class AuctionUtility {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final AuctionServiceImpl auctionServiceImpl = new AuctionServiceImpl();
    private static final BookingUtility bookingUtility = new BookingUtility();

    public static void main(String[] args) {
        auctionDetails();
    }

    private static void auctionDetails() {
        char selectChoice;
        do {
            System.out.println("************WELCOME TO LAND LEASIA*******");
            System.out.println("1. Add Auction\n2. Display All Auctions\n3. Get Auction\n4. Highest bid amount");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAuction();
                    break;
                case 2:
                    viewAllAuction();
                    break;
                case 3:
                    getAuction();
                    break;
                case 4:
                    viewAuctionsAndBookings();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("Do you want to continue? (y/n)");
            selectChoice = scanner.next().charAt(0);
        } while (selectChoice == 'y' || selectChoice == 'Y');
    }

    private static void getAuction() {
        viewAllAuction();
        System.out.println("Enter the auction id:");
        String auctionId = scanner.next();
        scanner.nextLine(); // Consume newline
        Auction auction = auctionServiceImpl.getAuction(auctionId);

        if (auction != null) {
            System.out.println("Auction ID: " + auction.getAuctionId());
            System.out.println("Booking ID: " + auction.getBooking().getBookingId());
            System.out.println("Auction Date: " + auction.getAuctionDate());
            System.out.println("Bid Amount: " + auction.getBidAmount());
        } else {
            System.out.println("Auction not found.");
        }
    }

    private static void addAuction() {
        Booking booking = new Booking();
        bookingUtility.viewAllBooking();

        System.out.println("Enter the auction ID:");
        String auctionId = scanner.next();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Enter the booking ID:");
        int bookingId = scanner.nextInt();
        booking.setBookingId(bookingId);

        scanner.nextLine(); // Consume newline
        System.out.println("Enter the date of auction (yyyy-MM-dd):");
        LocalDate auctionDate = LocalDate.parse(scanner.nextLine(), dateFormat);
        System.out.println("Enter the bid amount:");
        Long bidAmount = scanner.nextLong();

        scanner.nextLine(); // Consume newline
        Auction auction = new Auction(auctionId, booking, auctionDate, bidAmount);
        auctionServiceImpl.addAuction(auction);

        System.out.println("Auction added successfully.");
    }

    private static void viewAllAuction() {
        List<Auction> auctionList = auctionServiceImpl.viewAllAuction();

        if (auctionList.isEmpty()) {
            System.out.println("No auctions available.");
        } else {
            System.out.println("********* Here you can display all auctions ********");
            System.out.println("----------------------------------------------------------");
            System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|", "Auction ID", "Booking ID", "Auction Date", "Bid Amount"));
            System.out.println("----------------------------------------------------------");

            int auctionIdWidth = 10;
            int bookingIdWidth = 20;
            int dateWidth = 20;
            int bidAmountWidth = 15;

            for (Auction auction : auctionList) {
                System.out.println(String.format("%-" + auctionIdWidth + "s|%-"
                        + bookingIdWidth + "s|%-"
                        + dateWidth + "s|%-"
                        + bidAmountWidth + "s|",
                        auction.getAuctionId(),
                        auction.getBooking().getBookingId(),
                        auction.getAuctionDate(),
                        auction.getBidAmount()));
            }
        }
    }

    private static void viewAuctionsAndBookings() {
        List<Auction> auctionList = auctionServiceImpl.viewAuctionsAndBookings();

        Map<Integer, Long> highestBidAmountPerLeaseLand = new HashMap<>();
        Map<Integer, Integer> bookingIdPerLeaseLand = new HashMap<>();

        for (Auction auction : auctionList) {
            int leaseLandId = auction.getBooking().getLeaseLand().getLease_land_id();
            int bookingId = auction.getBooking().getBookingId();
            Long bidAmount = auction.getBidAmount();

            if (highestBidAmountPerLeaseLand.containsKey(leaseLandId)) {
                Long currentHighestBid = highestBidAmountPerLeaseLand.get(leaseLandId);
                if (bidAmount > currentHighestBid) {
                    highestBidAmountPerLeaseLand.put(leaseLandId, bidAmount);
                    bookingIdPerLeaseLand.put(leaseLandId, bookingId);
                }
            } else {
                highestBidAmountPerLeaseLand.put(leaseLandId, bidAmount);
                bookingIdPerLeaseLand.put(leaseLandId, bookingId);
            }
        }

        // Display the highest bid amount and corresponding booking ID per lease land
        System.out.println("Highest bid amount and corresponding booking ID per lease land:");
        for (Map.Entry<Integer, Long> entry : highestBidAmountPerLeaseLand.entrySet()) {
            int leaseLandId = entry.getKey();
            Long highestBidAmount = entry.getValue();
            int bookingId = bookingIdPerLeaseLand.get(leaseLandId);

            System.out.println("Lease Land ID: " + leaseLandId + ", Highest Bid Amount: " + highestBidAmount + ", Booking ID: " + bookingId);
        }
    }

    }

    


    

            

            


        
    

   

