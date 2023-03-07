package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class ShopManage implements Serializable {
	private ArrayList<Item> items;
	private String saveItem = "items.ser";

	ShopManage() {
		/**/
	}

	public void save() {
		try {
			File file = new File(saveItem);
			if (file.exists()) {
				FileInputStream fileOut = new FileInputStream(saveItem);
				ObjectInputStream Out = new ObjectInputStream(fileOut);
				ArrayList<Item> readObject = (ArrayList<Item>) Out.readObject();
				items = readObject;
				Out.close();
				fileOut.close();
			} else {
				items = new ArrayList<Item>();
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}

	public void addItem(String name, double price) {
		items.add(new Item(name, price));
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

	public void LoadShopData() {
		// TODO Auto-generated method stub

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
