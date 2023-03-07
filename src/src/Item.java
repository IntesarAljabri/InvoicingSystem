package src;

import java.io.*;
import java.util.*;

class Item implements Serializable {

	static int itemId;
	static String item_Name;
	static double unitPrice;
	static double quantity;
	double qtyprice;

	public Item(String name, double unitPrice) {
		// TODO Auto-generated constructor stub
	}

	public Item(Object item_Name2, int quantity2, Object unitPrice2, Object qtyprice2) {
		// TODO Auto-generated constructor stub
	}

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

}
