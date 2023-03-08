package src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopeSetting {
	String shopName;
	String telNumber;
	String faxNumber;
	String email;
	String website;

	private final static String Invoice = "Invoice.txt";
	static Scanner scan = new Scanner(System.in);
	// Load items and invoices from files
	int id;
	String name;
	double quantity;
	double price;
	ArrayList<Item> item;

	// To save Serialized the shop data
	private static void saveSettings() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Invoice));
			out.writeObject(out);
			out.close();
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
