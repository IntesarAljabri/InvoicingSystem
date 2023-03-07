package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoicing implements Serializable {

	// Invoicing Array
	static ArrayList<String> invoiceList = new ArrayList<String>();

	private String tel;
	private String fax;
	private String email;
	private String website;
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
	static String costumerName;
	static int phone;
	static Date date;
	static int numberOfItems;
	static double totalAmount;
	static double paidAmount;
	static double balance;

	// Array of items
	private static List<Item> Item;

	public List<Item> getItem() {
		return Item;
	}

	public void setItems(List<Item> items) {
		this.Item = items;
	}

	// setter and getter of invoice data
	public void setcostumerName(String customerName) {
		Invoicing.costumerName = customerName;
	}

	public String getCustomerName() {
		return costumerName;
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

	public static void calculateTotalPrice() {
		// TODO Auto-generated method stub

	}

	public static void loadInvoices() {
		// TODO Auto-generated method stub

	}

	// To Read items from file
	public class ItemReader {
		public static Item readItem(String line) {
			String[] parts = line.split(",");
			String item_Name = parts[0];

			int quantity = Integer.parseInt(parts[1]);
			double unitPrice = Double.parseDouble(parts[2]);
			double qtyprice = Double.parseDouble(parts[3]);

			return new Item(item_Name, quantity, unitPrice, qtyprice);
		}

		public static List<Item> readItemsFromFile(String Invoice) throws IOException {
			List<Item> item = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(Invoice))) {
				String line;
				while ((line = br.readLine()) != null) {
					Item items = readItem(line);
					Item.add(items);
				}
			}
			return item;
		}
	}

	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}