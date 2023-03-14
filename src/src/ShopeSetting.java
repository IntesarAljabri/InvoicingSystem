package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopeSetting {
	String shopName;
	String telNumber;
	String faxNumber;
	String email;
	String website;
		
		
		
	private final static String Invoice = "Invoice.txt";
	static Scanner scan = new Scanner(System.in);
	private static Object newItem;
	// Load items and invoices from files
	int id;
	String name;
	static double quantity;
	double price;
	//ArrayList<Item> item;
	
	
	 //Load data for Shop Setting
		static Item loadData(int itemId) throws ClassNotFoundException {
			Item newItem = new Item();
			  boolean validInput = false;
		        while (!validInput) {
		            try {
		                System.out.print("Enter item ID (must be an integer): ");
		               int Id = scan.nextInt();
		                validInput = true;
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input! Please enter a valid integer.");
		                scan.nextLine(); // clear the scanner buffer
		            }
		        }

		        scan.nextLine(); // clear the scanner buffer

		        System.out.print("Enter item name: ");
		        String name = scan.nextLine();

		        double price = 0;
		        validInput = false;
		        while (!validInput) {
		            try {
		                System.out.print("Enter item price (must be a number): $");
		                price = scan.nextDouble();
		                validInput = true;
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input! Please enter a valid number.");
		                scan.nextLine(); // clear the scanner buffer
		            }
		        }
		        System.out.print("Enter item Quantity: ");
		        double quantity = scan.nextDouble();
		        try {
		            FileWriter writer = new FileWriter("items.txt", true);
		            writer.write(itemId + " - " + name + " - $" + price +  " _ " + quantity +"\n");
		            writer.close();


		        } catch (IOException e) {
		            System.out.println("An error occurred while saving the item: " + e.getMessage());
		        }
		        
		        
		   /*     
			System.out.println("Enter items ID :");
			int id = scan.nextInt();
			System.out.println("Enter items name :" );
			String name = scan.next();
			System.out.println("Enter items Quantity :" );
			double quantity = scan.nextDouble();
			System.out.println("Enter item Price : ");
			double price = scan.nextDouble();
			*/
			
			newItem.setitemId(itemId);
			newItem.setName(name);
			newItem.setqtyprice(price);
			newItem.setquantity(quantity);
			ShopeSetting.saveSettings();
			// Do something with the loaded items and invoices.
			System.out.println("Data loaded successfully.");
			return newItem;
		}
		
	// To save the shop data
	static void saveSettings() throws ClassNotFoundException {
		try {
				File file = new File("Item.txt");

				if (file.createNewFile()) {
					System.out.println("File is Created");
					System.out.println("File name : " + file.getName());

					FileWriter File = new FileWriter("Item.txt");
					java.io.File readObject = (java.io.File) ((ObjectInput) File).readObject();
			
					File.write("|-----------------------------------------------------------|");
					File.write("|                     ITEM DETAILS                          |");
					File.write("|-----------------------------------------------------------|");
					File.write("|Item ID :                  " + Item.itemId + "             |");
					File.write("|Item name :                " + Item.item_Name + "          |");
					File.write("|Item unitPrice :           " + Item.unitPrice + "          |");
					File.write("|Item quantity :            " + Item.quantity + "           |");
					File.write("|-----------------------------------------------------------|");
			
					file = readObject;
					File.close();
					File.close();
		            System.out.println("Item added successfully!");
		         
				}
			
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	/*void loadSettings() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(Invoice));
			ShopeSetting settings = (ShopeSetting) in.readObject();
			shopName = settings.shopName;
			telNumber = settings.telNumber;
			faxNumber = settings.faxNumber;
			email = settings.email;
			website = settings.website;
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// Ignore if file not found or if class not found
			System.out.println("Error loading data: " + e.getMessage());
		}
	}*/

}
