package src;

import java.util.ArrayList;
public class Menu extends Main {
    public void show(String menuType) {
        switch (menuType) {
            case "main":
                showMainMenu();
                break;
            case "shop":
                showShopMenu();
                break;
            case "items":
                showItemsMenu();
                break;
            case "invoices":
                showInvoicesMenu();
                break;
            default:
                System.out.println("Invalid menu type.");
                break;
        }
    }

    private void showMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Shop Settings");
        System.out.println("2. Manage Shop Items");
        System.out.println("3. Create New Invoices");
        System.out.println("4. Report Statistic");
        System.out.println("5. Report  ");
        System.out.println("6. Search By ID    ");
        System.out.println("7. Program Statistic ");
        System.out.println("8. Exit Application");
    }

    private void showShopMenu() {
        System.out.println("Shop Settings:");
        System.out.println("1. Load Data (Items and invoices)");
        System.out.println("2. Set Shop Name (data should be saved)");
        System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)");
        System.out.println("4. Go Back");
    }

    private void showItemsMenu() {
        System.out.println("Manage Shop Items:");
        System.out.println("1. Add Items (Item should be saved/serialized)");
        System.out.println("2. Delete Items");
        System.out.println("3. Change Item Price");
        System.out.println("4. Report All Items");
        System.out.println("5. Go Back");
    }

    private void showInvoicesMenu() {
        System.out.println("Manage Invoices:");
        System.out.println("1. Create New Invoice");
        System.out.println("2. Search for an Invoice by Date / ID");
        System.out.println("3. Print an Invoice");
        System.out.println("4. View All Invoices");
        System.out.println("5. Go Back");
    }
    
    
}


/*public class Menu {
	void Menu1()
    {
        Main.menu1.add("Shop Setting");
        Main.menu1.add("Manage shpe Item");
        Main.menu1.add("Create new Inoicing");
        Main.menu1.add("Report:Statistic");
        Main.menu1.add("Report");
        Main.menu1.add("Search by id");
        Main.menu1.add("Program Statistic");
        Main.menu1.add("exit");
        
    }
    
    void Menu2()
    {
    	ShopeSetting.menu2.add("Load Data");
    	ShopeSetting.menu2.add("set Shope");
    	ShopeSetting.menu2.add("Set Invoicing header");
    	ShopeSetting.menu2.add("go back");
    }
    
    
    void Menu3()
    
    {
    	
	ManageShop.menu3.add("add item");
	ManageShop.menu3.add("delete items");
	ManageShop.menu3.add("set Invoic");	
	ManageShop.menu3.add("Report All Items");
	ManageShop.menu3.add("go back");
    	
    }
	
     void show(ArrayList<String> menu){
        
        for(int i=0;i<menu.size();i++){
            System.out.println("["+(i+1)+ "]" + menu.get(i));
             }
         }
    
}*/

	
	

