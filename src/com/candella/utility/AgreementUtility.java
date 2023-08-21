package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Agreement;
import com.candella.entity.Booking;
import com.candella.service.AgreementServiceImpl;


public class AgreementUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		agreementDetails();
	}

	private static void agreementDetails() {
	

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add Agreement\n2.Display All Agreement\n3.Get Agreement");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addAgreement();

			} else if (choice == 2) {
				viewAllAgreement();
			} else if (choice == 3) {
				
				getAgreement();	
				} 
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	

	

	private static Agreement getAgreement() {
	    AgreementServiceImpl agreementServiceImpl = new AgreementServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    viewAllAgreement();
	    System.out.println("Enter the agreement id:");
	    int agreementId = scanner.nextInt();
	    Agreement agreement = agreementServiceImpl.getAgreement(agreementId);

	    if (agreement != null) {
	        System.out.println("Agreement id: " + agreement.getAgreementId());
	        System.out.println("Booking id: " + agreement.getBooking().getBookingId());
	        System.out.println("Start date: " + agreement.getStartDate());
	        System.out.println("End date: " + agreement.getEndDate());
	        System.out.println("Lease amount: " + agreement.getLeaseAmount());
	        System.out.println("Payment frequency: " + agreement.getPaymentFrequency());
	        System.out.println("Lease status: " + agreement.getLeaseStatus());
	        System.out.println("T&C: " + agreement.getTandC());
	    } else {
	        System.out.println("Agreement not found.");
	    }

	    return agreement;
	}

	private static void addAgreement() {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    AgreementServiceImpl agreementServiceImpl = new AgreementServiceImpl();
	    Booking booking = new Booking();

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the Agreement id:");
	    int agreementId = scanner.nextInt();
	    System.out.println("Enter the booking id:");
	    int bookingId = scanner.nextInt();
	    booking.setBookingId(bookingId);

	    scanner.nextLine(); // Consume newline

	    System.out.println("Enter the start date (yyyy-MM-dd):");
	    LocalDate startDate = LocalDate.parse(scanner.nextLine(), format);
	    System.out.println("Enter the end date (yyyy-MM-dd):");
	    LocalDate endDate = LocalDate.parse(scanner.nextLine(), format);

	    System.out.println("Enter the lease amount:");
	    int leaseAmount = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline
	    System.out.println("Enter the payment frequency:");
	    String paymentFrequency = scanner.nextLine();
	    System.out.println("Enter the lease status:");
	    String leaseStatus = scanner.nextLine();
	    System.out.println("Enter the T&C:");
	    String tandC = scanner.nextLine();

	    Agreement agreement = new Agreement(agreementId, booking, startDate, endDate, leaseAmount, paymentFrequency, leaseStatus, tandC);
	    agreementServiceImpl.addAgreement(agreement);

	    System.out.println("Agreement added successfully.");
	}

	static void viewAllAgreement() {
	    AgreementServiceImpl agreementServiceImpl = new AgreementServiceImpl();
	    List<Agreement> agreementList = agreementServiceImpl.viewAllAgreement();

	    System.out.println("********* Here you can display all agreements ********");
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-15s|%-15s|%-15s|%-40s|",
	            "Agreement ID", "Booking ID", "Start Date", "End Date", "Lease Amount", "Payment Frequency", "Lease Status", "T&C"));
	    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

	    for (Agreement agreement : agreementList) {
	        System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-15s|%-15s|%-15s|%-40s|",
	                agreement.getAgreementId(), agreement.getBooking().getBookingId(), agreement.getStartDate(),
	                agreement.getEndDate(), agreement.getLeaseAmount(), agreement.getPaymentFrequency(),
	                agreement.getLeaseStatus(), agreement.getTandC()));
	    }

	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	}


	


