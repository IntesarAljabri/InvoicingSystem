package src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {


	static Stack<String> stack = new Stack<String>();
	private static Object Invoic;
	static String op;
	static String op1;
	static Scanner scan = new Scanner(System.in);
	static ShopManage manage = new ShopManage();
	private static Invoicing[] invoice;
	Shop newShop = new Shop();

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
					System.out.println("            Choose an Option :            ");
					System.out.println("|----------------------------------------|");
					String op1 = scan.next();

					// String choice1= scan.next();
					switch (op1) {
					case "1":
						// Load data
						Shop.itemList.add(loadData());
                       
						break;
					case "2":
						// Set shop name
						System.out.println("Enter shop name:");
						String shopName = scan.next();
						System.out.println("Shop name set to: " + shopName);
						ShopManage.save();
						// repeat1=false;
						break;

					case "3":
						// Set invoice header
						Invoicing.SetHeader();
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
						double unitPrice = 0.0;
						manage.addItem(name, price,unitPrice);
						manage.save();
						break;

					case "2":
						// Delete Item
						 Item.deleteItem();
						break;

					case "3":
						// Change Item price
						Item.Change();
						break;

					case "4":
						// Report All Items
						Item.GetReport();
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
				Item.GetReport();

				// calculate total price and add invoice to manager
				Invoicing.calculateTotalPrice();
				manage.addInvoice(Invoic);
				break;

			case "4":
				// Report Statistic
				Main.ReportStatistic();
				break;

			case "5":
				// Report
				Main.Report();
				break;
			case "6":
				// search Invoice By ID
				Invoicing.Search();
				break;

			case "7":
				// Program Statistic
				Main.ProgStatistic();
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

	
	
	
	//Save Shop Setting
	private static void saveSettings() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Invoice.txt"));
			out.writeObject(out);
			out.close();
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}
     //Check invoice then create new
	private static int getAvailableItems() {
		if(Shop.itemList.size() == 1 )
			return Shop.itemList.size();
		else {
		System.out.println("Enter items ID :" );
		int id = scan.nextInt();
		System.out.println("Enter items name :");
		String name = scan.next();
		System.out.println("Enter items Quantity :");
		double quantity = scan.nextDouble();
		System.out.println("Enter item Price : " );
		double price = scan.nextDouble();
		// ArrayList<String> invoiceList = loadInvoicing(Invoice);

		// Do something with the loaded items and invoices.
		System.out.println("Data loaded successfully.");
		//return item;
	}
		return getAvailableItems();
		
}

	

	
   //Load data for Shop Setting
	private static Item loadData() {
		Item newItem = new Item();
		
		System.out.println("Enter items ID :");
		int id = scan.nextInt();
		System.out.println("Enter items name :" );
		String name = scan.nextLine();
		System.out.println("Enter items Quantity :" );
		double quantity = scan.nextDouble();
		System.out.println("Enter item Price : ");
		double price = scan.nextDouble();
		
		
		newItem.setitemId(id);
		newItem.setName(name);
		newItem.setqtyprice(price);
		newItem.setquantity(quantity);
		ShopeSetting.saveSettings();
		// Do something with the loaded items and invoices.
		System.out.println("Data loaded successfully.");
		return newItem;
	}
	
	
    //Case 4 Report Statistic
	static Item ReportStatistic() {
		
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
		System.out.println("|Number of items sold :            |" + Item.numberOfItems);
		System.out.println("|Number of invoices:               |" + Shop.invoiceList.size());
		System.out.println("|Total sales: $                    |" + totalSales);
		System.out.println("|----------------------------------|");
		return ReportStatistic();
		
	}
	
	//Report case5
	static Main Report() {
		
		
		for (int i = 0; i < Shop.invoiceList.size(); i++) {
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
		return Report() ;
	}
	
	
	//case 7 Program statistic
	static Main ProgStatistic() {
		
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
		return ProgStatistic();
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
