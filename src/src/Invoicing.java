package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Invoicing implements Serializable {

	private static final String Invoice = null; 
	static Scanner scan = new Scanner(System.in);
	
	// Invoicing Array
	  static ArrayList<String> invoiceList = new ArrayList<String>();
	  
	private String tel;
	private String fax;
	private static String email;
	private static String website;
	// private InvoiceHeader header;

	public String getTel() {
		return tel;
	}

	public String getFax() {
		return fax;
	}

	public String getEmail() {
		return email;
	}

	public String getWebsite() {
		return website;
	}

	// data of invoice
	static int invNO;
	static String customerName;
	static int phone;
	static Date date;
	static int numberOfItems;
	static double totalAmount;
	static double paidAmount;
	static double balance;

	


	// setter and getter of invoice data
	public void setcostumerName(String customerName) {
		Invoicing.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getInvoicePhone() {
		return phone;
	}

	public void setInvoicePhone(int invoiceNumber) {
		Invoicing.phone = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return date;
	}

	public void setInvoiceDate(Date invoiceDate) {
		Invoicing.date = invoiceDate;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		Invoicing.numberOfItems = numberOfItems;
	}

	public double getTotal() {
		return totalAmount;
	}

	public void setTotal(double total) {
		Invoicing.totalAmount = total;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		Invoicing.balance = balance;
	}

	public static void addItem(Item item) {
		// TODO Auto-generated method stub

	}

	public static double calculateTotalPrice() {
		int quantity=0;
		int unitPrice=0;
		double totalAmount = quantity * unitPrice;

		double  balance=totalAmount - paidAmount;
		return balance;

	}

	public static void loadInvoices() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Item.txt"));
			ShopeSetting settings = (ShopeSetting) in.readObject();
			String shopName = settings.shopName;
			String telNumber = settings.telNumber;
			String faxNumber = settings.faxNumber;
			email = settings.email;
			website = settings.website;
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// Ignore if file not found or if class not found
			System.out.println("Error loading data: " + e.getMessage());
		}

	}
	public void saveInvoice() {
		try {
			File file = new File("Item.txt");

			if (file.createNewFile()) {
				System.out.println("File is Created");
				System.out.println("File name : " + file.getName());

				FileWriter File = new FileWriter("Item.txt");
				java.io.File readObject = (java.io.File) ((ObjectInput) File).readObject();
				
				File.write("|-----------------------------------------------------------|");
				File.write("|                     INVOICE DETAILS                       |");
				File.write("|-----------------------------------------------------------|");
				File.write("|Item ID :                  " + Item.itemId + "             |");
				File.write("|Item name :                " + Item.item_Name + "          |");
				File.write("|Item unitPrice :           " + Item.unitPrice + "          |");
				File.write("|Item quantity :            " + Item.quantity + "           |");
				File.write("|Invoice ID :               " + Invoicing.invNO + "         |");
				File.write("|Invoice customerName :     " + Invoicing.customerName + "  |");
				File.write("|Invoice phone :            " + Invoicing.phone + "         |");
				File.write("|Invoice date :             " + Invoicing.date + "          |");
				File.write("|Invoice numberOfItems :    " + Invoicing.numberOfItems + " |");
				File.write("|Invoice totalAmount :      " + Invoicing.totalAmount + "   |");
				File.write("|Invoice paidAmount :       " + Invoicing.paidAmount + "    |");
				File.write("-------------------------------------------------------------");
				file = readObject;
				File.close();
				File.close();
			}
		} 
		
		catch (Exception e) {
			System.out.println("Invalied Input");

		}
	}

	// To Read items from file
	public class ItemReader {
		public static Item readItem(String line) {
			Item newItem = new Item();
			String[] parts = line.split(",");
			String item_Name = parts[0];

			int quantity = Integer.parseInt(parts[1]);
			double unitPrice = Double.parseDouble(parts[2]);
			double qtyprice = Double.parseDouble(parts[3]);

			return newItem;
			//return newItem(item_Name, quantity);
		}
		
		
		
		public  List<Item> readItemsFromFile(String Invoice) throws IOException {
			List<Item> item = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("Invoice.txt"))) {
				String line;
				while ((line = br.readLine()) != null) {
					Item items = readItem(line);
					//Item.add(items);
				}
			}
			return item;
		}
	}

	    static Invoicing SetHeader() {
		 Invoicing  newInvoice = new Invoicing();
		System.out.println("Enter tel number:");
		int telNumber = scan.nextInt();
		System.out.println("Enter fax number:");
		int faxNumber = scan.nextInt();
		System.out.println("Enter email:");
		String email = scan.next();
		System.out.println("Enter website:");
		String website = scan.next();
		System.out.println("|---------------------------------|");
		System.out.println("|Invoice header set to:           |");
		System.out.println("|Tel:|" + telNumber + "           |");
		System.out.println("|Fax: " + faxNumber + "           |");
		System.out.println("|Email:"+ email + "               |" );
		System.out.println("|Website:" + website +"           |");
		System.out.println("|---------------------------------|");
		return newInvoice;
		
		
	}
	    
	    
	  //Check invoice then create new
	    //static Invoicing getAvailableItems() {
	    	public static void newInvoice() {
	    		System.out.println("Invoice Number: " + invNO);
	    		System.out.println("Customer Name: " + customerName);
	    		System.out.println("Phone: " + phone);
	    		System.out.println("Date: " + date);
	    		System.out.println("Items: ");
	    		for (int i = 0; i < Shop.itemList.size(); i++) {
	    			System.out.println(Shop.itemList.get(i).getName() + " - " + Shop.itemList.get(i).getquantity() + " x " + Shop.itemList.get(i).getqtyprice());
	    		}
	    		System.out.println("Balance: $" + balance);
	    	}
	    	
		 

	    
			static Invoicing Search() {
				System.out.println("Enter Invoice NUMBER to search");
				int invoNO = scan.nextInt();
				// All data come from invoicing class
				if (invoNO == Invoicing.invNO) {

					System.out.println("|--------------------------------------------|");
					System.out.println("|INVOICE DETAILES NO:" + Invoicing.invNO + "   |");
					System.out.println("|--------------------------------------------|");
					System.out.println("|Invoice NO.:" + Invoicing.invNO + "           |");
					System.out.println("|Customer Name:" + Invoicing.customerName + "  |");
					System.out.println("|Customer Pone:" + Invoicing.phone + "         |");
					System.out.println("|Invoice Date:" + Invoicing.date + "           |");
					System.out.println("|Balance:" + Invoicing.balance + "              |");
					System.out.println("---------------------------------------------|");
					// System.out.println("Item Name: " + Invoicing.item_Nameme);
					// System.out.println("Item ID: " + Invoicing.itemId);
					// System.out.println("Item Price: " + Invoicing.unitPrice);
					// System.out.println("Item Quantity: " + Invoicing.quantity);
					// System.out.println("Item Quantity Amount: " + Invoicing.qtyAmount);
				} else {
					// If not found, display an error message
					System.out.println("Sorry, no invoice was found with that number.");
				}

				// Return the result (which may be null if no invoice was found)
				return null;
			}
	  	  
	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void add(Object invoic) {
		Invoicing.add(invoic);
	}

	private static void addInvoice(Object invoic) {
		Invoicing.addInvoice(invoic);		
		
	}

}