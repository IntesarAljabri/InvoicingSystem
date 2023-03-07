package src;

import java.util.Scanner;

public class SearchInvoic {

	Scanner scan = new Scanner(System.in);

	public void search() {

		System.out.println("Enter Invoice NUMBER to search");

		int invoNO = scan.nextInt();

		if (invoNO == Invoicing.invNO) {
			System.out.println("Invoice NO.: " + Invoicing.invNO);
			System.out.println("Customer Name: " + Invoicing.costumerName);
			System.out.println("Customer Pone: " + Invoicing.phone);
			System.out.println("Invoice Date: " + Invoicing.date);
			System.out.println("Balance: " + Invoicing.balance);
			// System.out.println("Item Name: " + Invoicing.item_Nameme);
			// System.out.println("Item ID: " + Invoicing.itemId);
			// System.out.println("Item Price: " + Invoicing.unitPrice);
			// System.out.println("Item Quantity: " + Invoicing.quantity);
			// System.out.println("Item Quantity Amount: " + Invoicing.qtyAmount);

		}
	}
}
