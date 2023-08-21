package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Booking;
import com.candella.entity.Buyer;
import com.candella.entity.LeaseLand;
import com.candella.service.BookingServiceImpl;


public class BookingUtility 
{

	public static void main(String[] args) {

bookingDetails();
	}

	private static void bookingDetails() {
		// TODO Auto-generated method stub

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add Booking\n2.Display All bookings\n3.Get booking");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addBooking();

			} else if (choice == 2) {
				viewAllBooking();
			} else if (choice == 3) {
				getBooking();
			} 
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	


	private static void getBooking() {
	    BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    viewAllBooking();
	    System.out.println("Enter the Booking id:");
	    int bookingId = scanner.nextInt();
	    scanner.nextLine(); // Consume newline
	    Booking booking = bookingServiceImpl.getBooking(bookingId);

	    if (booking != null) {
	        System.out.println("Booking id: " + booking.getBookingId());
	        System.out.println("Lease land id: " + booking.getLeaseLand().getLease_land_id());
	        System.out.println("Buyer id: " + booking.getBuyer().getBuyer_id());
	        System.out.println("Status: " + booking.getBookingStatus());
	        System.out.println("Booking date: " + booking.getBookingDate());
	    } else {
	        System.out.println("Booking not found.");
	    }
	}

	private static void addBooking() {
	    BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
	    LeaseLand leaseLand = new LeaseLand();
	    Buyer buyer = new Buyer();
	    viewAllBooking();
	    Scanner scanner = new Scanner(System.in);
	  
	    System.out.println("Enter the booking id:");
	    int bookingId = scanner.nextInt();
	    System.out.println("Enter the lease land id:");
	    int leaseLandId = scanner.nextInt();
	    leaseLand.setLease_land_id(leaseLandId);

	    scanner.nextLine(); // Consume newline
	    System.out.println("Enter the buyer id:");
	    String buyerId = scanner.nextLine();
	    buyer.setBuyer_id(buyerId);

	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    System.out.println("Enter the booking status:");
	    String status = scanner.nextLine();
	    System.out.println("Enter the booking date (yyyy-MM-dd):");
	    String bDate = scanner.nextLine();
	    LocalDate bookingDate = LocalDate.parse(bDate, format);

	    Booking booking = new Booking(bookingId, leaseLand, buyer, status, bookingDate);
	    bookingServiceImpl.addBooking(booking);

	    System.out.println("Booking added successfully.");
	}

	public static void viewAllBooking() {
	    BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
	    List<Booking> bookingList = bookingServiceImpl.viewAllBooking();

	    if (bookingList.isEmpty()) {
	        System.out.println("No bookings available.");
	    } else {
	        System.out.println("********* Here you can display all bookings ********");
	        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
	        System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|", "Booking id", "Lease land id", "Buyer id",
	                "Status", "Booking date"));
	        System.out.println("----------------------------------------------------------------------------------------------------------------------");
	        for (Booking booking : bookingList) {
	            System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|", booking.getBookingId(),
	                    booking.getLeaseLand().getLease_land_id(), booking.getBuyer().getBuyer_id(),
	                    booking.getBookingStatus(), booking.getBookingDate()));
	        }
	        System.out.println("------------------------------------------------------------------------------------------------------------------------");
	    }
	}



	}


