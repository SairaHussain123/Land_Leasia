package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Agreement;
import com.candella.entity.Payment;
import com.candella.service.AgreementServiceImpl;
import com.candella.service.PaymentServiceImpl;

public class PaymentUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		paymentDetails();
		}

		private static void paymentDetails() {
		

			char selectChoice;
			do {
				Scanner scanner = new Scanner(System.in);
				System.out.println("************WELCOME TO LAND LEASIA*******");

				System.out.println("1.Add payment\n2.Display All payment\n3.Get payment");
				System.out.println("Enter your choice:");

				int choice = scanner.nextInt();
				if (choice == 1) {
					addPayment();

				} else if (choice == 2) {
					viewAllPayment();
				} else if (choice == 3) {
					
					getPayment();	
					} 
				System.out.println("do you want continue");
				selectChoice = scanner.next().charAt(0);
			} while (selectChoice == 'y' || selectChoice == 'Y');

		}

		private static Payment getPayment() {
			// TODO Auto-generated method stub
			

					PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter the payment id");
					int paymentid = scanner.nextInt();
					Payment payment = paymentServiceImpl.getPayment(paymentid);
					

					if (payment != null) {
						System.out.println("payment id:" +payment.getPaymentId());
						System.out.println("agreement id:" + payment.getAgreement().getAgreementId());
						System.out.println("amount paid:" + payment.getAmountPaid());
						System.out.println("payment method:" + payment.getPaymentMethod());
						System.out.println("payment references:" +payment.getPaymentReference());
						System.out.println("remaining payment:"+payment.getRemainingPayment());
						System.out.println("payment date:"+payment.getPaymentDate());
						
					

					} else
						System.out.println("not found");

					return payment;

				}
				
		
	
			
		

		private static void viewAllPayment() {
		    PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		    List<Payment> paymentList = paymentServiceImpl.viewAllPayment();

		    System.out.println("*********Here you can display all payments********");
		    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		    System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-20s|%-20s|%-15s|",
		            "payment id", "agreement ID", "amount paid", "payment method",
		            "payment reference", "remaining payment", "payment date"));
		    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

		    for (Payment payment : paymentList) {
		        System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-20s|%-20s|%-15s|",
		                payment.getPaymentId(),payment.getAgreement().getAgreementId(),
		                payment.getAmountPaid(), payment.getPaymentMethod(),
		                payment.getPaymentReference(), payment.getRemainingPayment(),
		                payment.getPaymentDate()));
		    }

		    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		}

			
			
		

		private static void addPayment() {
			AgreementUtility agreementUtility=new AgreementUtility();
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		    Agreement agreement = new Agreement();

		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter the payment id:");
		    int paymentId = scanner.nextInt();
agreementUtility.viewAllAgreement();
		    System.out.println("Enter the agreement id:");
		    int agreementId = scanner.nextInt();
		    agreement.setAgreementId(agreementId);

		    scanner.nextLine(); // Consume newline

		    System.out.println("Enter the amount paid:");
		    Long paidAmount = scanner.nextLong();
		    scanner.nextLine(); // Consume newline

		    System.out.println("Enter the payment method:");
		    String paymentMethod = scanner.nextLine();

		    System.out.println("Enter the payment reference:");
		    String paymentReference = scanner.nextLine();

		    System.out.println("Enter remaining payment:");
		    Long remainingPayment = scanner.nextLong();
		    scanner.nextLine(); // Consume newline

		    System.out.println("Enter the payment date (yyyy-MM-dd):");
		    String paymentDate = scanner.nextLine();
		    LocalDate pDate = LocalDate.parse(paymentDate, format);

		    Payment payment = new Payment(paymentId, agreement, paidAmount, paymentMethod, paymentReference, remainingPayment, pDate);
		    paymentServiceImpl.addPayment(payment);

		    System.out.println("Added successfully");
		}


		}


	
