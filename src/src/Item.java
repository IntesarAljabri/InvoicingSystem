package src;

import java.io.*;
import java.util.*;

class Item implements Serializable {

	static Scanner scan = new Scanner(System.in);
	public static final int List = 0;
	private static final ShopManage manage = new ShopManage();
	
	static int itemId;
	static String item_Name;
	static double unitPrice;
	static double quantity;
	static double qtyprice;
	public static Object numberOfItems;
	private static Item[] items;

	// setter and getter
	public int getitemId() {
		return itemId;
	}

	public void setitemId(int itemId) {
		Item.itemId = itemId;
	}

	public String getName() {
		return item_Name;
	}

	public void setName(String ItemName) {
		Item.item_Name = ItemName;
	}

	public double getunitPrice() {
		return unitPrice;
	}

	public void setunitPrice(double unitPrice) {
		Item.unitPrice = unitPrice;

	}

	public void setquantity(double quantity) {
		Item.quantity = quantity;

	}

	public double getquantity() {
		return quantity;

	}

	public void setqtyprice(double qtyprice) {
		this.qtyprice = qtyprice;

	}

	public double getqtyprice() {
		return qtyprice;

	}

	static Item GetReport() {
		//System.out.println("Shop Inventory Report");
	
		Item newItem = new Item();
		for (Item item : items) {
			System.out.println("|-----------------------------------------|");
			System.out.println("|              ITEM REPORT                |");
			System.out.println("|-----------------------------------------|");
			System.out.println("|item_Name:" + item.getName() + "         |");
			System.out.println("|Unit Price:" + item.getunitPrice() +"    |");
			System.out.println("|Quantity:" + item.getquantity() + "      |");
			System.out.println("|Quantity Price:" + item.getqtyprice() + "|");
			System.out.println("|-----------------------------------------|");

		}
		ShopManage.save();
		return newItem;
	}
	
	static Item Change() {
		
		boolean repeat=true;
		System.out.println("Enter id of item to change price:");
		double item = scan.nextInt();
		System.out.println("Enter new price:");
		double newPrice = scan.nextDouble();
		manage.changeItemPrice(item, newPrice);
		while (true) {
			System.out.print("Do you want to add item to Change price ? (y/n):    ");
			String select = scan.next();
			if (select.equals("N") || select.equals("n")) {
				repeat = false;
				break;
			} else if (select.equals("y") || select.equals("Y")) {
				break;
			} else {
				System.out.println("Invalid letter  ");
			}
		}
		ShopManage.save();
		return Change();
		
	}
	
	
	static Item deleteItem() {
	boolean run=true;
	{
		System.out.println("Enter id of item to delete :" + Item.itemId);
		int item = scan.nextInt();
		if(Item.itemId == item) {
			
			System.out.println("item is deleted");
		}
		
		else {
			System.out.println("Not Found");
		}

		while(true) {
			System.out.print("Do you want to delete other item ? (y/n):    ");
			String select = scan.next();
			if (select.equals("N") || select.equals("n")) {
				run = false;
				break;
			} else if (select.equals("y") || select.equals("Y")) {
				break;
			} else {
				System.out.println("Invalid letter  ");
			}
		}
		//Item.deleteItem();
		ShopManage.save();
		return deleteItem();
		
	   }
	}
}
