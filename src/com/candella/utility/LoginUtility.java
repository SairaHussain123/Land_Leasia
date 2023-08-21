package com.candella.utility;

import java.util.HashMap;
import java.util.Scanner;

import com.candella.dao.LoginDaoImpl;

public class LoginUtility {

    static HashMap<String, String> registeredUsers = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
static LoginDaoImpl loginDaoImpl=new LoginDaoImpl();
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser(); 
                        
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    static void registerUser() {
        System.out.println("User Registration");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        System.out.print("Enter user type (Buyer/Lessor/Admin): ");
        String userType = scanner.nextLine();
        
        registeredUsers.put(username, password);
        registeredUsers.put(username + "_type", userType); 
        System.out.println("Registration successful!");
    }

    static boolean loginUser() {
        System.out.println("User Login");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
           String userType= loginDaoImpl.getUserType(username, password);
            System.out.println("Login successful!");
            displayUserMenu(userType);
            return true;
        } else {
            return false;
        }
    }

    static void displayUserMenu(String userType) {
        System.out.println("Welcome to the user menu! "+userType);
        
        
        switch (userType) {
            case "Buyer":
                BuyerUtility.buyerMenu();
                break;
            case "Lessor":
               LessorUtility.lessorMenu();
                break;
            case "Admin":
               LandUtility.adminMenu();
                break;
            default:
                System.out.println("Invalid user type.");
        }
    }

}
