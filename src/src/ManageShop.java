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
	private static ArrayList<Item> items;
	//private String saveItem = "items.ser";
    static Scanner scan= new Scanner(System.in);
	
	

	public static void save() {
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
				File.write("|-----------------------------------------------------------|");
				file = readObject;
				File.close();
				File.close();
			}
		} 
		
		catch (Exception e) {
			System.out.println("Invalied Input");

		}
	}

	public static void addItem(String name, double price){
	    Item newItem = new Item();
	    //items.add(name);
	    //items.add(price);
	    saveItems();
	    System.out.println("Item added successfully.");
	}

	public void deleteItem(int item) {
		if (item < 0 || item >= items.size()) {
			System.out.println("Invalid Item.");
			return;
		}

		items.remove(items);
		saveItems();
		System.out.println("Item deleted successfully.");
	}

	public void changeItemPrice(double item, double newPrice) {
		if (item < 0 || item >= Shop.itemList.size()) {
			System.out.println("Invalid Item.");
			return;
		}

		items.get((int) item).setunitPrice(newPrice);
		saveItems();
		System.out.println("Item price changed successfully.");
	}

	public void reportAllItems() {
		System.out.println("Shop Items:");
		for (int i = 0; i < Shop.itemList.size(); i++) {
			Item item = items.get(i);
			System.out.println(i + ". " + item.getName() + " - $" + item.getunitPrice());
		}
	}

	public static void saveItems() {
		try {
            FileWriter writer = new FileWriter("items.txt", true);
            writer.write(items + "\n");
            writer.close();
            System.out.println("Item saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the item: " + e.getMessage());
        }
    }
		/*try {
			FileOutputStream fileOut = new FileOutputStream("Item.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.defaultWriteObject();
			out.close();
			fileOut.close();
		} 
		
		catch (IOException i) {
			i.printStackTrace();
		}*/
	



}
	
