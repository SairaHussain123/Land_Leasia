package com.candella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.LeaseLand;
import com.candella.entity.Lessor;
import com.candella.service.LessorServiceImpl;

public class LessorUtility {

	public static void main(String[] args) {

		lessorDetails();
	}

	private static void lessorDetails() {
		// TODO Auto-generated method stub

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add Lessor\n2.Update lessor\n3.Display All lessors\n4.Get lessor");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addLessor();

			} else if (choice == 2) {
				updateLessor();
			} else if (choice == 3) {
				viewAllLessor();
			} else if (choice == 4) {
				getLessor();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	

	private static void addLessor() {

		LessorServiceImpl lessorServiceImpl = new LessorServiceImpl();

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println("Enter the lessor id:");
		int l_id = scanner.nextInt();
		System.out.println("Enter the first name:");
		String f_name = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter the last name:");
		String l_name = scanner.nextLine();
		System.out.println("Enter the contact number:");
		long c_number = scanner.nextLong();
		System.out.println("Enter the address:");
		scanner.nextLine();
		String address = scanner.nextLine();

		System.out.println("Enter your location:");
		String location = scanner.nextLine();
		scanner.nextLine();
		Lessor lessor = new Lessor(l_id, f_name, l_name, c_number, address, location);
		lessorServiceImpl.addLessor(lessor);

		System.out.println("added succesfully");

	}

	private static void updateLessor() {
		LessorServiceImpl lessorServiceImpl = new LessorServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Here You can Update****");
		System.out.println("Enter the Lessor id:");
		String l_id = scanner.nextLine();
		System.out.println("enter the column to be updated:");
		String column_name = scanner.nextLine();

		lessorServiceImpl.updateLessor(l_id, column_name);
		System.out.println("Updated Succesffuly>>...........");

	}

	static void viewAllLessor() {
		LessorServiceImpl lessorServiceImpl = new LessorServiceImpl();
		List<Lessor> lessorList = lessorServiceImpl.viewAllLessor();

		System.out.println("*********Here you can display all lessors********");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|%-30s", "ID", "First Name", "Last Name",
				"Contact Number", "Address", "Location"));
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------");
		for (Lessor lessor : lessorList) {
			System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|%-30s", lessor.getLessor_id(),
					lessor.getL_first_name(), lessor.getL_last_name(), lessor.getContact_number(), lessor.getAddress(),
					lessor.getLocation()));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------");

	}

	private static Lessor getLessor() {

		LessorServiceImpl lessorServiceImpl = new LessorServiceImpl();
		Scanner scanner = new Scanner(System.in);
		viewAllLessor();
		System.out.println("Enter the lessor id");
		String l_id = scanner.nextLine();
		Lessor lessor = lessorServiceImpl.getLessor(l_id);
		

		if (lessor != null) {
			System.out.println("lessor id:" + lessor.getLessor_id());
			System.out.println("first name:" + lessor.getL_first_name());
			System.out.println("last name:" + lessor.getL_last_name());
			System.out.println("contact number:" + lessor.getContact_number());
			System.out.println("address:" + lessor.getAddress());
			System.out.println("location:" + lessor.getLocation());

		} else
			System.out.println("not found");

		return lessor;

	}
	
	    

	static void lessorMenu() {
	    Scanner scanner = new Scanner(System.in);
	    List<LeaseLand> leases = new ArrayList<>();

	    while (true) {
	        System.out.println("Land Lease Utility - Lessor Menu");
	        System.out.println("1. View Lease Details");
	        System.out.println("2. Update Rent");
	        System.out.println("3. Add Land");
	        System.out.println("4. Exit");

	        int choice = getUserChoice();
	        processChoice(choice, leases);
	    }
	}

	private static int getUserChoice() {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter your choice: ");
	    return scanner.nextInt();
	}

	private static void processChoice(int choice, List<LeaseLand> leases) {
	    switch (choice) {
	        case 1:
	            viewLeaseDetails(leases);
	            break;
	        case 2:
	            updateRent(leases);
	            break;
	        case 3:
	            addLand(leases);
	            break;
	        case 4:
	            exit();
	            break;
	        default:
	            System.out.println("Invalid choice. Please select a valid option.");
	    }
	}

	private static void exit() {
	    System.out.println("Exiting the Land Lease Utility. Goodbye!");
	    System.exit(0);
	}

	private static void viewLeaseDetails(List<LeaseLand> leases) {
	    System.out.println("Lease Details:");
	    for (int i = 0; i < leases.size(); i++) {
	        System.out.println((i + 1) + ". Status: " + leases.get(i).getStatus());
	        System.out.println("   Rent Amount: " + leases.get(i).getRent_amount());
	    }
	}

	private static void updateRent(List<LeaseLand> leases) {
		
		
	    int leaseIndex = selectLease(leases);
	    if (leaseIndex >= 0) {
	    	Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter new rent amount: ");
	        long newRent = scanner.nextLong();
	        leases.get(leaseIndex).setRent_amount(newRent);
	        System.out.println("Rent updated successfully!");
	    }
	}

	private static int selectLease(List<LeaseLand> leases) {
	    if (leases.isEmpty()) {
	        System.out.println("No leases available.");
	        return -1;
	    }

	    System.out.println("Select a lease:");
	    for (int i = 0; i < leases.size(); i++) {
	        System.out.println((i + 1) + ". Lease Status: " + leases.get(i).getStatus());
	        System.out.println("   Rent Amount: " + leases.get(i).getRent_amount());
	    }

	    int selection = getUserChoice();
	    if (selection >= 1 && selection <= leases.size()) {
	        return selection - 1;
	    } else {
	        System.out.println("Invalid selection.");
	        return -1;
	    }
	}

	private static void addLand(List<LeaseLand> leases) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter lease status: ");
	    String status = scanner.next();
	    System.out.print("Enter rent amount: ");
	    long rentAmount = scanner.nextLong();

	    LeaseLand leaseLand = new LeaseLand(status, rentAmount);
	    leases.add(leaseLand);
	    System.out.println("Land lease added successfully!");
	}}
