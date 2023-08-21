package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Farmer;
import com.candella.entity.Land;
import com.candella.entity.LeaseLand;
import com.candella.entity.Lessor;
import com.candella.service.FarmerServiceImpl;
import com.candella.service.LeaseLandServiceImpl;


public class LeaseLandUtility {

	public static void main(String[] args) {
		
		leaseLandDetails();
	}

	private static void leaseLandDetails() {
		// TODO Auto-generated method stub

		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("************WELCOME TO LAND LEASIA*******");

			System.out.println("1.Add lease land\n2.Update lease land\n3.Display All lease lands\n4.Get lease land");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			if (choice == 1) {
				addLeaseland();

			}
			 else if (choice == 2) {
				viewAllLeaseLand();
			} else if (choice == 3) {
				getLeaseLand();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	private static void addLeaseland() {

		LeaseLandServiceImpl leaseLandServiceImpl = new LeaseLandServiceImpl();
LessorUtility lessorUtility=new LessorUtility();
LandUtility landUtility=new LandUtility();
Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the lease land id:");
		int l_l_id = scanner.nextInt();
		lessorUtility.viewAllLessor();
		
		System.out.println("Enter the lessor id:");
		int l_id = scanner.nextInt();
		landUtility.viewAllLand();
		System.out.println("Enter the land id:");
		int land_id = scanner.nextInt();
		System.out.println("Enter the status:");
		String status = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter the rent amount:");
		
		int rent_amount = scanner.nextInt();

		
		scanner.nextLine();
		 Lessor lessor_id=new Lessor();
			
			Land land_id1=new Land();
			lessor_id.setLessor_id(l_id);
			land_id1.setLand_id(land_id);
		LeaseLand leaseLand = new LeaseLand(l_l_id,lessor_id,land_id1,status,rent_amount);
		leaseLandServiceImpl.addLeaseLand(leaseLand);

		System.out.println("added succesfully");

	}

	

	private static void viewAllLeaseLand() {
		LeaseLandServiceImpl leaseLandServiceImpl = new LeaseLandServiceImpl();
		List<LeaseLand> leaseLandList = leaseLandServiceImpl.viewAllLeaseLand();

		System.out.println("*********Here you can display all lease lands********");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|%-30s", "ID", "lessor id", "Land id",
				"status", "rent_amount"));
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------");
		for (LeaseLand leaseLand : leaseLandList) {
			System.out.println(String.format("%-10s|%-20s|%-20s|%-15s|%-40s|%-30s",leaseLand.getLease_land_id(),
					leaseLand.getLessor().getLessor_id(),leaseLand.getLand().getLand_id(), leaseLand.getStatus(),leaseLand.getRent_amount()));
			
				
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------");

	}

	private static LeaseLand getLeaseLand() {

		LeaseLandServiceImpl LeaseLandServiceImpl = new LeaseLandServiceImpl();
		Scanner scanner = new Scanner(System.in);
		viewAllLeaseLand();
		System.out.println("Enter the lease land id");
		String l_l_id = scanner.nextLine();
		LeaseLand leaseLand = LeaseLandServiceImpl.getLeaseLand(l_l_id);
		

		if (leaseLand != null) {
			System.out.println("lease land id:" + leaseLand.getLease_land_id());
			System.out.println("lessor id:" + leaseLand.getLessor().getLessor_id());
			System.out.println("land id:" + leaseLand.getLand().getLand_id());
			System.out.println("status:" + leaseLand.getStatus());
			System.out.println("rent amount:" +leaseLand.getRent_amount());


		} else
			System.out.println("not found");

		return leaseLand;

	}



	}


