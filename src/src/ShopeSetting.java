package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopeSetting {

	 static ArrayList<String> menu2 =new ArrayList<String>();
	 Scanner scan = new Scanner(System.in);
	 static int second_selection;
	 static Menu callMenu =new Menu();

 public void ShopeSetting() {
		
	
		 boolean setupWhile = true;
		 callMenu.Menu2();
        
		 while(setupWhile){
           // Menu.getSchoolMenu(); 
            System.out.println("Select Action:      ");
            
            Menu secondMenu = new Menu();
            secondMenu.show(menu2);
            second_selection = scan.nextInt();
            System.out.println(" ");
            
            switch(second_selection){
		 
            
            
            case 1:
                System.out.print("Load Data : ");
                String newName = scan.next();
                Main.newItem1.item_Name=newName;
                System.out.println(" ");
                break;
	     }
      }
    }
}
