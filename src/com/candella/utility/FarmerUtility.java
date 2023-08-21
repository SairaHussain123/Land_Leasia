package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Farmer;
import com.candella.service.FarmerServiceImpl;

public class FarmerUtility {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		farmerDetails();
		
	}

	static void farmerDetails() {
		// TODO Auto-generated method stub

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add Farmer\n2.Update farmer\n3.Display All Farmers\n4.Get Farmer\n5.ViewAllFarmerBySpecilization");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addFarmer();

			} else if (choice == 2) {
				updateFarmer();
			} else if (choice == 3) {
				viewAllFarmer();
			} else if (choice == 4) {
				getFarmer();
			}
			else if(choice==5) {
				viewAllFarmerBySpecialization();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	private static void viewAllFarmerBySpecialization() {
	    FarmerServiceImpl farmerServiceImpl = new FarmerServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter the specialization to view farmers:");
	    String specialization = scanner.nextLine();
	    
	    List<Farmer> farmerList = farmerServiceImpl.viewAllFarmer();

	    boolean found = false; // Flag to track if any matching farmer is found
	    
	    for (Farmer farmer : farmerList) {
	        if (farmer.getSpecializedIn().equalsIgnoreCase(specialization)) {
	            System.out.printf("Farmer ID: %s%n", farmer.getFarmer_id());
	            System.out.printf("First Name: %s%n", farmer.getFirst_name());
	            System.out.printf("Last Name: %s%n", farmer.getLast_name());
	            System.out.printf("Contact Number: %d%n", farmer.getContact_number());
	            System.out.printf("Address: %s%n", farmer.getAddress());
	            System.out.printf("Location: %s%n", farmer.getLocation());
	            System.out.printf("Specialization: %s%n", farmer.getSpecializedIn());
	            System.out.println("--------------------------------------------");
	            found = true; // Set the flag to true if at least one matching farmer is found
	        }
	    }
	    
	    if (!found) {
	        System.out.println("No farmers found with the specialization: " + specialization);
	    }
	}


	


	   

	private static void addFarmer() {
	    FarmerServiceImpl farmerServiceImpl = new FarmerServiceImpl();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter the farmer id:");
	    String f_id = scanner.nextLine();
	    System.out.println("Enter the first name:");
	    String f_name = scanner.nextLine();
	    System.out.println("Enter the last name:");
	    String l_name = scanner.nextLine();
	    System.out.println("Enter the contact number:");
	    long c_number = scanner.nextLong();
	    scanner.nextLine(); // Consume newline
	    System.out.println("Enter the address:");
	    String address = scanner.nextLine();
	    System.out.println("Enter your location:");
	    String location = scanner.nextLine();
	    System.out.println("Enter specialization:");
	    String specializedIn = scanner.nextLine(); // New input
	    
	    Farmer farmer = new Farmer(f_id, f_name, l_name, c_number, address, location,specializedIn);
	    farmer.setSpecializedIn(specializedIn); // Set the specialization
	    farmerServiceImpl.addFarmer(farmer);

	    System.out.println("Added successfully");
	}


	private static void updateFarmer() {
		FarmerServiceImpl farmerServiceImpl = new FarmerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Here You can Update****");
		System.out.println("Enter the farmer id:");
		String f_id = scanner.nextLine();
		System.out.println("enter the column to be updated:");
		String column_name = scanner.nextLine();

		farmerServiceImpl.updateFarmer(f_id, column_name);
		System.out.println("Updated Succesffuly>>...........");

	}

	private static void viewAllFarmer() {
	    FarmerServiceImpl farmerServiceImpl = new FarmerServiceImpl();
	    List<Farmer> farmerList = farmerServiceImpl.viewAllFarmer();

	    System.out.println("********* Here you can display all farmers ********");
	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	    System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s | %-30s",
	            "ID", "First Name", "Last Name", "Contact Number", "Address", "Location", "Specialized In"));
	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	    
	    for (Farmer farmer : farmerList) {
	        System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s | %-30s",
	                farmer.getFarmer_id(), farmer.getFirst_name(), farmer.getLast_name(),
	                farmer.getContact_number(), farmer.getAddress(), farmer.getLocation(), farmer.getSpecializedIn()));
	    }

	    System.out.println(
	            "-----------------------------------------------------------------------------------------------------------------------");
	}


	private static Farmer getFarmer() {

		FarmerServiceImpl farmerServiceImpl = new FarmerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the farmer id");
		String f_id = scanner.nextLine();
		Farmer farmer = farmerServiceImpl.getFarmer(f_id);
		

		if (farmer != null) {
			System.out.println("farmer id:" + farmer.getFarmer_id());
			System.out.println("first name:" + farmer.getFirst_name());
			System.out.println("last name:" + farmer.getLast_name());
			System.out.println("contact number:" + farmer.getContact_number());
			System.out.println("address:" + farmer.getAddress());
			System.out.println("location:" + farmer.getLocation());
System.out.println("specialized in:"+farmer.getSpecializedIn());
		} else
			System.out.println("not found");

		return farmer;

	}
	
	
}

