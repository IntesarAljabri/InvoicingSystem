package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class ShopManage implements Serializable {
	private ArrayList<Item> items;
	private String saveItem = "items.ser";
    static Scanner scan= new Scanner(System.in);
	ShopManage() {
		/**/
	}

	public void save() {
		try {
			File file = new File("Invoice.txt");

			if (file.createNewFile()) {
				System.out.println("File is Created");
				System.out.println("File name : " + file.getName());

				FileWriter File = new FileWriter("Invoice.txt");
				ArrayList<Item> readObject = (ArrayList<Item>) ((ObjectInput) File).readObject();
				
				File.write("|-----------------------------------------------------------|");
				File.write("|                    INVOICE DETAILS                        |");
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
				items = readObject;
				File.close();
				File.close();
			}
		} catch (Exception e) {
			System.out.println("Invalied Input");

		}
	}

	public void addItem(String name, double price , double unitPrice) {
		items.add(new Item(name, price, unitPrice));
		saveItems();
		System.out.println("Item added successfully.");
	}

	public void deleteItem(int product) {
		if (product < 0 || product >= items.size()) {
			System.out.println("Invalid index.");
			return;
		}

		items.remove(product);
		saveItems();
		System.out.println("Item deleted successfully.");
	}

	public void changeItemPrice(int product, double newPrice) {
		if (product < 0 || product >= items.size()) {
			System.out.println("Invalid index.");
			return;
		}

		items.get(product).setunitPrice(newPrice);
		saveItems();
		System.out.println("Item price changed successfully.");
	}

	public void reportAllItems() {
		System.out.println("Shop Items:");
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.println(i + ". " + item.getName() + " - $" + item.getunitPrice());
		}
	}

	public void saveItems() {
		try {
			FileOutputStream fileOut = new FileOutputStream(saveItem);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(items);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}


	public void setShopName(String name) {
		// TODO Auto-generated method stub

	}

	public void setInvoiceHeader(String header) {
		// TODO Auto-generated method stub

	}

	public void addInvoice(Object invoic) {
		// TODO Auto-generated method stub

	}
}
