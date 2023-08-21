package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Farmer;
import com.candella.entity.Land;
import com.candella.service.FarmerServiceImpl;
import com.candella.service.LandServiceImpl;

public class LandUtility {

	public static void main(String[] args) {
	

				landDetails();
			}

			private static void landDetails() {
				// TODO Auto-generated method stub

				char selectChoice;
				do {
					Scanner scanner = new Scanner(System.in);
					System.out.println("************WELCOME TO LAND LEASIA*******");

					System.out.println("1.Add land\n2.Update land\n3.Display All land\n4.Get land");
					System.out.println("Enter your choice:");

					int choice = scanner.nextInt();
					if (choice == 1) {
						addLand();

					} else if (choice == 2) {
						updateLand();
					} else if (choice == 3) {
						viewAllLand();
					} else if (choice == 4) {
						getLand();
					}
					System.out.println("do you want continue");
					selectChoice = scanner.next().charAt(0);
				} while (selectChoice == 'y' || selectChoice == 'Y');

			}

			private static void addLand() {

				LandServiceImpl landServiceImpl = new LandServiceImpl();

				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the land id:");
				int land_id = scanner.nextInt();
				System.out.println("Enter the land address:");
				String land_address = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter the location:");
				String location = scanner.nextLine();
				
				System.out.println("Enter the land area:");
				String land_area = scanner.nextLine();
				scanner.nextLine();
				System.out.println("cultivation suitable for :");

				String csf = scanner.nextLine();

				System.out.println("Enter the soil type:");
				String soil_type = scanner.nextLine();
				scanner.nextLine();
			Land land  = new Land(land_id,land_address,location, land_area, csf, soil_type);
				landServiceImpl.addLand(land);

				System.out.println("added succesfully");

			}

			private static void updateLand() {
				LandServiceImpl landServiceImpl = new LandServiceImpl();
				Scanner scanner = new Scanner(System.in);
				System.out.println("******Here You can Update****");
				LandUtility landUtility=new LandUtility();
				landUtility.viewAllLand();
				System.out.println("Enter the land id:");
				int land_id = scanner.nextInt();
				System.out.println("enter the column to be updated:");
				String column_name = scanner.nextLine();
				scanner.nextLine();

				landServiceImpl.updateLand(land_id, column_name);
				System.out.println("Updated Succesffuly>>...........");

			}

			static void viewAllLand() {
			    LandServiceImpl landServiceImpl = new LandServiceImpl();
			    List<Land> landList = landServiceImpl.viewAllLand();

			    System.out.println("********* Here you can display all Land **********");
			    System.out.println(
			            "-----------------------------------------------------------------------------------------------------------------------");
			    System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s",
			            "ID", "Address", "Location", "Land Area", "Cultivation Suitable For", "Soil Type"));
			    System.out.println(
			            "-----------------------------------------------------------------------------------------------------------------------");
			    
			    for (Land land : landList) {
			        System.out.println(String.format("%-10s | %-20s | %-20s | %-15s | %-40s | %-30s",
			                land.getLand_id(), land.getLand_address(), land.getLocation(), land.getLand_area(),
			                land.getCultivation_suitable_for(), land.getSoil_type()));
			    }

			    System.out.println(
			            "-----------------------------------------------------------------------------------------------------------------------");
			}

			private static Land getLand() {

				LandServiceImpl landServiceImpl = new LandServiceImpl();
				Scanner scanner = new Scanner(System.in);
				viewAllLand();
				System.out.println("Enter the land id");
				int land_id = scanner.nextInt();
				Land land = landServiceImpl.getLand(land_id);
				

				if (land != null) {
					System.out.println("land id:" + land.getLand_id());
					System.out.println("land address:" + land.getLand_address());
					System.out.println("location:" + land.getLocation());

					System.out.println("land area:" + land.getLand_area());
					System.out.println("cultivation suitable for:" + land.getCultivation_suitable_for());
					System.out.println("soil:" + land.getSoil_type());
					
				} 
				else
					System.out.println("not found");

				return land;

			}
		
public static void adminMenu()
{

	char selectChoice;
	do {
		Scanner scanner = new Scanner(System.in);
		System.out.println("************WELCOME TO LAND LEASIA*******");

		System.out.println("1.Buyer\n2.Farmer\n3.Lessor");
		System.out.println("Enter your choice:");

		int choice = scanner.nextInt();
		if (choice == 1) {
			BuyerUtility.buyerDetails();

		} else if (choice == 2) {
			FarmerUtility.farmerDetails();
		} else if (choice == 3) {
			LessorUtility.lessorMenu();
		} else if (choice == 4) {
			break;
		}
		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
	} while (selectChoice == 'y' || selectChoice == 'Y');

}

}
		
	


