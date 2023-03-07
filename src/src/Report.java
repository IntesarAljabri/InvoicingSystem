package src;

public class Report {

	public void list() {

		for (int i = 0; i < Invoicing.invoiceList.size(); i++) {
			System.out.println("Invoice NO.: " + Invoicing.invNO);
			System.out.println("Customer Name: " + Invoicing.costumerName);
			System.out.println("Customer Pone: " + Invoicing.phone);
			System.out.println("Invoice Date: " + Invoicing.date);
			System.out.println("Balance: " + Invoicing.balance);

		}

	}
}