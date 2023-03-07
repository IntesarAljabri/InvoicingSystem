package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopeSetting {
	String shopName;
	String telNumber;
	String faxNumber;
	String email;
	String website;

	private final String Invoice = "shopsettings.ser";
    static Scanner scan = new Scanner (System.in);	
    // Load items and invoices from files
        int id;
		String name;
		double quantity;
		double price;
		ArrayList<Item> item;
	// implementation details not provided in the requirements
	ArrayList<Item> loadData(String saveItem) {

		System.out.println("Enter items ID :" + Item.itemId);
		id = scan.nextInt();
		System.out.println("Enter items name :" + Item.item_Name);
		name = scan.nextLine();
		System.out.println("Enter items Quantity :" + Item.quantity);
		quantity = scan.nextDouble();
		System.out.println("Enter item Price : " + Item.unitPrice);
		price = scan.nextDouble();
		// ArrayList<String> invoiceList = loadInvoicing(Invoice);

		// Do something with the loaded items and invoices.
		System.out.println("Data loaded successfully.");
		return item;
	}

	// To save Serialized the shop data
	void saveSettings() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Invoice));
			out.writeObject(this);
			out.close();
		} 
		catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	void loadSettings() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(Invoice));
			ShopeSetting settings = (ShopeSetting) in.readObject();
			shopName = settings.shopName;
			telNumber = settings.telNumber;
			faxNumber = settings.faxNumber;
			email = settings.email;
			website = settings.website;
			in.close();
		} 
		catch (IOException | ClassNotFoundException e) {
			// Ignore if file not found or if class not found
			System.out.println("Error loading data: " + e.getMessage());
		}
	}

}
