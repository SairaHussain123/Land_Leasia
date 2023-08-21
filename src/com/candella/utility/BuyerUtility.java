package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.dao.BookingDaoImpl;
import com.candella.entity.Booking;
import com.candella.entity.Buyer;
import com.candella.entity.Land;
import com.candella.service.BuyerServiceImpl;

public class BuyerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		buyerDetails();
		buyerMenu();
	}

	

	static void buyerDetails() {
		// TODO Auto-generated method stub

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add Buyer\n2.Update buyer\n3.Display All buyers\n4.Get buyer");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addBuyer();

			} else if (choice == 2) {
				updateBuyer();
			} else if (choice == 3) {
				viewAllBuyer();
			} else if (choice == 4) {
				getBuyer();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	private static Buyer getBuyer() {
		// TODO Auto-generated method stub
		BuyerServiceImpl buyerServiceImpl = new BuyerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		viewAllBuyer();
		System.out.println("Enter the buyer id");
		String b_id = scanner.nextLine();
		Buyer buyer= buyerServiceImpl.getBuyer(b_id);
		

		if (buyer!= null) {
			System.out.println("buyer id:" + buyer.getBuyer_id());
			System.out.println("first name:" + buyer.getBuyer_first_name());
			System.out.println("last name:" + buyer.getBuyer_last_name());

			
			System.out.println("contact number:" + buyer.getContact_number());
			System.out.println("mail id:"+buyer.getMail_id());
			System.out.println("address:" + buyer.getAddress());
			System.out.println("location:" + buyer.getLocation());

		} else
			System.out.println("not found");

		return buyer;

	}


	


	

	private static void addBuyer() {
		// TODO Auto-generated method stub

		BuyerServiceImpl buyerServiceImpl = new BuyerServiceImpl();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the buyer id:");
		String b_id = scanner.nextLine();
		System.out.println("Enter the first name:");
		String f_name = scanner.nextLine();
		System.out.println("Enter the last name:");
		String l_name = scanner.nextLine();
		System.out.println("Enter the contact number:");
		long c_number = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the mail id:");
		String m_id = scanner.nextLine();
		System.out.println("Enter the address:");

		String address = scanner.nextLine();

		System.out.println("Enter your location:");
		String location = scanner.nextLine();
		scanner.nextLine();
		Buyer buyer = new Buyer(b_id, f_name, l_name, c_number, m_id, address, location);
		buyerServiceImpl.addBuyer(buyer);
		

		System.out.println("added succesfully");

	}
	private static void updateBuyer() {
	    BuyerServiceImpl buyerServiceImpl = new BuyerServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("****** Here You can Update ******");
	    BuyerUtility buyerUtility = new BuyerUtility();
	    buyerUtility.viewAllBuyer();
	    
	    System.out.println("Enter the buyer id:");
	    String b_id = scanner.nextLine();
	    System.out.println("Enter the column to be updated:");
	    String column_name = scanner.nextLine();
	    
	    buyerServiceImpl.updateBuyer(b_id, column_name);
	    System.out.println("Updated Successfully >>>...........");
	    scanner.close(); // Don't forget to close the scanner
	}

	private static void viewAllBuyer() {
	    BuyerServiceImpl buyerServiceImpl = new BuyerServiceImpl();
	    List<Buyer> buyerList = buyerServiceImpl.viewAllBuyer();

	    System.out.println("********* Here you can display all buyers ********");
	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	    System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s",
	            "ID", "First Name", "Last Name", "Contact Number", "Mail id", "Address", "Location"));
	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	    
	    for (Buyer buyer : buyerList) {
	        System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s",
	                buyer.getBuyer_id(), buyer.getBuyer_first_name(), buyer.getBuyer_last_name(),
	                buyer.getContact_number(), buyer.getMail_id(), buyer.getAddress(), buyer.getLocation()));
	    }

	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	}
	static void buyerMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Buyer Menu");
           
            System.out.println("1. Search Lands");
            System.out.println("2. Update Profile");
            System.out.println("3. status");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

          
                if(choice== 1)
                    searchLands();
                    
                if(choice==2)
                	updateProfile();
                if(choice==3)
                	displayStatus();
                if(choice==4)
                    System.out.println("Exiting...");
                    return;
                
        }
    }

	


	private static void displayStatus() {
	
		   
		        BookingDaoImpl bookingDaoImpl = new BookingDaoImpl();

		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter the booking ID: ");
		        int desiredBookingId = scanner.nextInt();

		        Booking bookingStatus = bookingDaoImpl.getBooking((desiredBookingId));

		        if (bookingStatus != null) {
		            System.out.println("Booking ID: " + bookingStatus.getBookingId() +
		                               ", Status: " + bookingStatus.getBookingStatus());
		        } else {
		            System.out.println("Booking status not found for the given ID.");
		        }
		    }
		




	private static void searchLands() {
		

		    
		

		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter the desired location: ");
		        String desiredLocation = scanner.nextLine();

		        List<Land> matchingLands = Land.searchLands(desiredLocation);

		        if (!matchingLands.isEmpty()) {
		            System.out.println("Matching lands found:");
		            for (Land land : matchingLands) {
		                System.out.println("Location: " + land.getLocation() +
		                                   ",Address: " + land.getLand_address() +  
		                                   ", suitable for: $" + land.getCultivation_suitable_for());
		            }
		        } else {
		            System.out.println("No matching lands found in the desired location.");
		        }
		    
		}

		
	



	private static void updateProfile() {
		BuyerServiceImpl buyerServiceImpl = new BuyerServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("****** Here You can Update ******");

	    System.out.print("Enter Buyer ID: ");
	    String buyerId = scanner.nextLine();

	  
	    Buyer buyer = buyerServiceImpl.getbuyer(buyerId);
	    
	    if (buyer == null) {
	        System.out.println("Buyer not found with the provided ID.");
	        scanner.close();
	        return;
	    }

	    System.out.println("Buyer Details:");
	    System.out.println("Buyer ID: " + buyer.getBuyer_id());
	    System.out.println("Buyer First Name: " + buyer.getBuyer_first_name());
	    System.out.println("Buyer Last Name: " + buyer.getBuyer_last_name());
	    System.out.println("Contact Number: " + buyer.getContact_number());
	    System.out.println("Mail ID: " + buyer.getMail_id());
	    System.out.println("Address: " + buyer.getAddress());
	    System.out.println("Location: " + buyer.getLocation());

	    System.out.println("Enter the detail to be updated:");
	    System.out.println("1. Buyer First Name");
	    System.out.println("2. Buyer Last Name");
	    System.out.println("3. Contact Number");
	    System.out.println("4. Mail ID");
	    System.out.println("5. Address");
	    System.out.println("6. Location");
	    
	    System.out.print("Select an option: ");
	    int option = scanner.nextInt();
	    scanner.nextLine(); // Consume newline character

	    String column_name = "";
	    
	    switch (option) {
	        case 1:
	            column_name = "buyer_first_name";
	            System.out.print("Enter new Buyer First Name: ");
	           String newValue = scanner.nextLine();
	            buyer.setBuyer_first_name(newValue);
	            break;
	        case 2:
	            column_name = "buyer_last_name";
	            System.out.print("Enter new Buyer Last Name: ");
	           String newValue1 = scanner.nextLine();
	            buyer.setBuyer_last_name(newValue1);
	            break;
	        case 3:
	            column_name = "contact_number";
	            System.out.print("Enter new Contact Number: ");
	            Long newValue2 = scanner.nextLong();
	            buyer.setContact_number( newValue2);
	            break;
	        case 4:
	            column_name = "mail_id";
	            System.out.print("Enter new Mail ID: ");
	            String newValue3 = scanner.nextLine();
	            buyer.setMail_id(newValue3);
	            break;
	        case 5:
	            column_name = "address";
	            System.out.print("Enter new Address: ");
	            String newValue4 = scanner.nextLine();
	            buyer.setAddress(newValue4);
	            break;
	        case 6:
	            column_name = "location";
	            System.out.print("Enter new Location: ");
	            String newValue5 = scanner.nextLine();
	            buyer.setLocation(newValue5);
	            break;
	        default:
	            System.out.println("Invalid option.");
	            scanner.close();
	            return;
	    }

	    buyerServiceImpl.updateProfile(buyer);

	    System.out.println("Updated Successfully >>>...........");
	    scanner.close();
	}


		
	






		
	}






