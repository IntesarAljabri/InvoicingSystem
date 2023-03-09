package src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Invoice.txt"));
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
			FileOutputStream fileOut = new FileOutputStream("Invoice" + invNO + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(fileOut);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in Invoice" + invNO + ".ser");
		} catch (IOException i) {
			i.printStackTrace();
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
		System.out.println("|Tel:                             |" + telNumber);
		System.out.println("|Fax:                             |" + faxNumber);
		System.out.println("|Email:                           |" + email);
		System.out.println("|Website:                         |" + website);
		System.out.println("|---------------------------------|");
		return newInvoice;
		
		
	}
	    static Invoicing getAvailableItems() {
	    Invoicing.loadInvoices();
		         // get list of available items
	    Invoicing newInvoice = new Invoicing();
		while (true) {
			System.out.println("Select an item to add (enter product or -1 to finish):");
			for (int i = 0; i < Shop.itemList.size(); i++) {
				System.out.println(i + ". " + Shop.itemList.get(i).getName() + " - " + Shop.itemList.get(i).getunitPrice());
			}
			int product = scan.nextInt();
			if (product == -1) {
				break;
			} else if (product >= 0 && product < Shop.itemList.size()) {
				Invoicing.addItem(Shop.itemList.get(product));
			} else {
				System.out.println("Invalid product.");
			}
		}
		return newInvoice;
		}
	static Invoicing Search() {
		
		
		System.out.println("Enter Invoice NUMBER to search");
		int invoNO = scan.nextInt();
		// All data come from invoicing class
		if (invoNO == Invoicing.invNO) {
			
			System.out.println("|-----------------------------------------|");
			System.out.println("|INVOICE DETAILES NO:"+ Invoicing.invNO+ "|");
			System.out.println("|-----------------------------------------|");
			System.out.println("|Invoice NO.:                             |" + Invoicing.invNO);
			System.out.println("|Customer Name:                           |" + Invoicing.customerName);
			System.out.println("|Customer Pone:                           |" + Invoicing.phone);
			System.out.println("|Invoice Date:                            |" + Invoicing.date);
			System.out.println("|Balance:                                 |" + Invoicing.balance);
			System.out.println("------------------------------------------|");
			// System.out.println("Item Name: " + Invoicing.item_Nameme);
			// System.out.println("Item ID: " + Invoicing.itemId);
			// System.out.println("Item Price: " + Invoicing.unitPrice);
			// System.out.println("Item Quantity: " + Invoicing.quantity);
			// System.out.println("Item Quantity Amount: " + Invoicing.qtyAmount);
		}
		return Search();
		
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