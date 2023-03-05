 package src;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoicing implements Serializable {
	static ArrayList<String> invoiceList =new ArrayList<String>();
	    int invNO;

	    String costumerName;
	    int phone;
	    String date;
	    int numberOfItems;
	    double totalAmount;
	    double paidAmount;
	    double balance ;

	}