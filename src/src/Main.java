package src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {

	private static final String Invoice = null;
	private static final String Itme = null;
	static Stack<String> stack = new Stack<String>();
	private static Object Invoic;
	static String op;
	static String op1;
	static Scanner scan = new Scanner(System.in);
	static ShopManage manage = new ShopManage();
	private static Invoicing[] invoice;

	public static void main(String[] args) {
		Invoicing newInvoic = new Invoicing();

		
		

		boolean running = true;
		boolean repeat = true;
		boolean program = true;

		while (running) {
			// Main menu
			System.out.println("|--------------------------------|");
			System.out.println("|[1]. Shop Setting               |");
			System.out.println("|[2]. Manage Shop                |");
			System.out.println("|[3]. Create New Invoicing       |");
			System.out.println("|[4]. Report Stastitic           |");
			System.out.println("|[5]. Report                     |");
			System.out.println("|[6]. search                     |");
			System.out.println("|[7]. Program Statistic          |");
			System.out.println("|[8]. Exit\n                     |");
			System.out.println("|--------------------------------|");
			System.out.println("   Choose an Option :            ");
			System.out.println("|--------------------------------|");
			String op = scan.next();

			switch (op) {

			case "1":
				// manager.printShopSettings();
				// Sub menu of shop setting
				boolean setupWhile = true;
				while (setupWhile) {
					System.out.println("|----------------------------------------|");
					System.out.println("|             Shop Settings              |");
					System.out.println("|----------------------------------------|");
					System.out.println("|[1]. Load Data (Items and invoices)     |");
					System.out.println("|[2]. Set Shop Name                      |");
					System.out.println("|[3]. Set Invoice(Tel"+"Fax/Email/Website|");
					System.out.println("|[4]. Go Back \n                         |");
					System.out.println("|----------------------------------------|");
					System.out.println("   Choose an Option :                     ");
					System.out.println("|----------------------------------------|");
					String op1 = scan.next();

					// String choice1= scan.next();
					switch (op1) {
					case "1":
						// Load data
						loadData();
						break;
					case "2":
						// Set shop name
						System.out.println("Enter shop name:");
						String shopName = scan.next();
						saveSettings();
						System.out.println("Shop name set to: " + shopName);

						// repeat1=false;
						break;

					case "3":
						// Set invoice header
						System.out.println("Enter tel number:");
						int telNumber = scan.nextInt();
						System.out.println("Enter fax number:");
						int faxNumber = scan.nextInt();
						System.out.println("Enter email:");
						String email = scan.next();
						System.out.println("Enter website:");
						String website = scan.next();
						saveSettings();
						System.out.println("|---------------------------------|");
						System.out.println("|Invoice header set to:           |");
						System.out.println("|Tel:                             |" + telNumber);
						System.out.println("|Fax:                             |" + faxNumber);
						System.out.println("|Email:                           |" + email);
						System.out.println("|Website:                         |" + website);
						System.out.println("|---------------------------------|");
						break;
					case "4":
						// Go back
						setupWhile = false;
						break;

					default:
						System.out.println("Invalid choice. Please try again.");
					}
				}
				break;
			case "2":
				// Manage Shop sub menu
				// String choice2 = scan.next();
				System.out.println("|---------------------------------|");
				System.out.println("|         Manage Shop :           |");
				System.out.println("|---------------------------------|");
				System.out.println("|[1]. addItem                     |");
				System.out.println("|[2]. deleteItem                  |");
				System.out.println("|[3]. changeItemPrice             |");
				System.out.println("|[4]. reportAllItems              |");
				System.out.println("|[5]. Go Back \n                  |");
				System.out.println("|---------------------------------|");
				System.out.println("    Choose an option :             ");
				System.out.println("|---------------------------------|");
				String op2 = scan.next();

				while (repeat) {
					switch (op2) {
					case "1":
						// Add Item
						System.out.println("Enter name of item:");
						String name = scan.next();
						System.out.println("Enter price of item:");
						double price = scan.nextDouble();
						double unitPrice = 0;
						manage.addItem(name, price,unitPrice);
						manage.save();
						break;

					case "2":
						// Delete Item
						System.out.println("Enter product of item to delete:");
						int product = scan.nextInt();
						manage.deleteItem(product);
						manage.save();
						break;

					case "3":
						// Change Item price
						System.out.println("Enter product of item to change price:");
						product = scan.nextInt();
						System.out.println("Enter new price:");
						double newPrice = scan.nextDouble();
						manage.changeItemPrice(product, newPrice);
						manage.save();
						break;

					case "4":
						// Report All Items
						System.out.println("Shop Inventory Report");
						System.out.println("---------------------");

						Item[] items = null;
						for (Item item : items) {
							System.out.println("|--------------------------|");
							System.out.println("|         ITEM REPORT      |");
							System.out.println("|--------------------------|");
							System.out.println("|item_Name:                |" + item.getName());
							System.out.println("|Unit Price:               |" + item.getunitPrice());
							System.out.println("|Quantity:                 |" + item.getquantity());
							System.out.println("|Quantity Price:           |" + item.getqtyprice());
							System.out.println("|--------------------------|");

						}
						manage.save();

						break;

					case "5":
						// Go Back
						repeat = false;
						break;
					}
				}
				break;
			case "3":
				// Create New Invoicing
				Invoicing.loadInvoices();
				List<Item> items = getAvailableItems(); // get list of available items from some method
				while (true) {
					System.out.println("Select an item to add (enter product or -1 to finish):");
					for (int i = 0; i < items.size(); i++) {
						System.out.println(i + ". " + items.get(i).getName() + " - " + items.get(i).getunitPrice());
					}
					int product = scan.nextInt();
					if (product == -1) {
						break;
					} else if (product >= 0 && product < items.size()) {
						Invoicing.addItem(items.get(product));
					} else {
						System.out.println("Invalid product.");
					}
				}

				// calculate total price and add invoice to manager
				Invoicing.calculateTotalPrice();
				manage.addInvoice(Invoic);
				break;

			case "4":
				// Report Statistic
				ArrayList<String> invoiceList = new ArrayList<String>();
				// Invoicing.add(new Invoicing(1, 25.77));
				// Invoicing.add(new Invoicing(2, 50.25));
				// Invoicing.add(new Invoicing(3, 75.00));
				// Invoicing.add(new Invoicing(4, 200.00));

				// Calculate statistics
				int numItems = 0;
				int numInvoices = Invoicing.size();
				double totalSales = 0.0;
				for (Invoicing invoice : invoice) {
					numItems += invoice.getNumberOfItems();
					totalSales += invoice.getTotal();
				}

				// Print results
				System.out.println("|----------------------------------|");
				System.out.println("|          INVOICE REPORT          |");
				System.out.println("|----------------------------------|");
				System.out.println("|Number of items sold :            |" + numItems);
				System.out.println("|Number of invoices:               |" + numInvoices);
				System.out.println("|Total sales: $                    |" + totalSales);
				System.out.println("|----------------------------------|");
				break;

			case "5":
				// Report
				for (int i = 0; i < Invoicing.invoiceList.size(); i++) {
					System.out.println("|---------------------------------|");
					System.out.println("|        FULL REPORT              |");
					System.out.println("|---------------------------------|");
					System.out.println("|Invoice NO.:                     |" + Invoicing.invNO);
					System.out.println("|Invoice Date :                   |"+ Invoicing.date);
					System.out.println("|Customer Name:                   |" + Invoicing.customerName);
					System.out.println("|Customer Phone:                  |" + Invoicing.phone);
					System.out.println("|Number of Item                   |" + Invoicing.numberOfItems);
					System.out.println("|Balance:                         |" + Invoicing.balance);
					System.out.println("|---------------------------------|");
				}
				break;
			case "6":
				// search Invoice By ID
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

				break;

			case "7":
				// Program Statistic

				int selection1 = 0;
				int selection2 = 0;
				int selection3 = 0;
				int selection4 = 0;
				int selection5 = 0;
				int selection6 = 0;

				for (int i = 0; i < Main.stack.size(); i++) {
					if (Main.stack.get(i).equals("1")) {
						selection1++;
					} else if (Main.stack.get(i).equals("2")) {
						selection2++;
					} else if (Main.stack.get(i).equals("3")) {
						selection3++;
					} else if (Main.stack.get(i).equals("4")) {
						selection4++;
					} else if (Main.stack.get(i).equals("5")) {
						selection5++;
					} else if (Main.stack.get(i).equals("5")) {
						selection6++;
					}
				}
				System.out.println("----------------------------------");
				System.out.println("|Shop Setting =                   |" + selection1);
				System.out.println("|Manage Shop        =             |" + selection2);
				System.out.println("|Create New Invoice =             |" + selection3);
				System.out.println("|Report Statistic   =             |" + selection4);
				System.out.println("|Report           =               |" + selection5);
				System.out.println("|Search By ID     =               |" + selection6);
				System.out.println("----------------------------------");
				break;

			case "8":
				// Exit
				System.out.println("Are you sure you want to exit? If yes, program ends? y/n");
				String select = scan.next();
				if (select.equals("y") || select.equals("Y")) {
					System.out.println("Goodbye..Thank you!!");
					running = false;
				}
			}
		}
	}

	private static void saveSettings() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Invoice));
			out.writeObject(out);
			out.close();
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	private static List<Item> getAvailableItems() {
		if(Item.List == 1 )
			return extracted();
		else {
		System.out.println("Enter items ID :" + Item.itemId);
		int id = scan.nextInt();
		System.out.println("Enter items name :" + Item.item_Name);
		String name = scan.nextLine();
		System.out.println("Enter items Quantity :" + Item.quantity);
		double quantity = scan.nextDouble();
		System.out.println("Enter item Price : " + Item.unitPrice);
		double price = scan.nextDouble();
		// ArrayList<String> invoiceList = loadInvoicing(Invoice);

		// Do something with the loaded items and invoices.
		System.out.println("Data loaded successfully.");
		//return item;
	}
		List<Item> item = null;
		return item;
}
	// implementation details not provided in the requirements

	private static List<Item> extracted() {
		List<Item> item = null;
		return item;
	}

	private static  ArrayList<Item> loadData() {
		System.out.println("Enter items ID :" + Item.itemId);
		int id = scan.nextInt();
		System.out.println("Enter items name :" + Item.item_Name);
		String name = scan.nextLine();
		System.out.println("Enter items Quantity :" + Item.quantity);
		double quantity = scan.nextDouble();
		System.out.println("Enter item Price : " + Item.unitPrice);
		double price = scan.nextDouble();
		// ArrayList<String> invoiceList = loadInvoicing(Invoice);

		// Do something with the loaded items and invoices.
		System.out.println("Data loaded successfully.");
		//return item;
		return null;
	}

}

/*
 * public class Main {
 * 
 * static ArrayList<String> menu1 =new ArrayList<String>(); static Scanner scan
 * = new Scanner(System.in); static Stack<String> stack = new Stack<String>();
 * static ArrayList<String> menu2 =new ArrayList<String>(); static
 * ArrayList<String> menu3 =new ArrayList<String>(); static int
 * second_selection; static Menu callMenu =new Menu();
 * 
 * public static void main(String[] args) {
 * 
 * callMenu.Menu1();
 * 
 * boolean program=true; while(program){ System.out.println();
 * System.out.println("select action  :"); Menu firstMenu = new Menu();
 * firstMenu.show(menu1); int first_selection = scan.nextInt();
 * first_selection--;
 * 
 * try {
 * 
 * if(menu1.get(first_selection).equals("ShopeSetting")) { ShopeSetting detail =
 * new ShopeSetting(); detail.ShopeSetting(); } else
 * if(menu1.get(first_selection).equals("Manage Shop")) { ManageShop newmanage =
 * new ManageShop(); ManageShop.addManage(); } else
 * if(menu1.get(first_selection).equals("Create New Invoicing")) { Create
 * newInvoic = new Create(); } else
 * if(menu1.get(first_selection).equals("Report : Statistic")) { reportStatistic
 * newreport= new reportStatistic(); newreport.addreport(); } else
 * if(menu1.get(first_selection).equals("Report")) { Report showList = new
 * Report(); showList.list(); } else
 * if(menu1.get(first_selection).equals("Search")) { SearchInvoic invoic = new
 * SearchInvoic(); invoic.search();
 * 
 * } else if (menu1.get(first_selection).equals("Program Statitistic")) {
 * ProgStatistice Statistic = new ProgStatistice(); Statistic.statistic(); }
 * else if(menu1.get(first_selection).equals("exit")) {
 * System.out.println("Are you sure you want to exit? If yes, program ends? y/n"
 * ); String select = scan.next(); if(select.equals("y") || select.equals("Y")){
 * System.out.println("Goodbye..Thank you!!"); program = false; }else{ program =
 * true; } } }
 * 
 * 
 * 
 * catch (Exception ex) { System.out.println("Wrong Number ");
 * 
 * }
 * 
 * } } }
 */
