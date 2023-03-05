package src;
public class Product implements Main {
     
	int itemId;
	String item_Name;
	float unitPrice;
	int quantity;
	int qtyprice;
	
	public String getName() {
    	return item_Name;
    	
    }
    
    public void setName(String ItemName) {
    	this.item_Name=ItemName;
    	
    }
	
}
