package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageShop {
	public Object addManage;
	static ArrayList<String> menu3 =new ArrayList<String>();
	 Scanner scan = new Scanner(System.in);
	 static int thired_selection;
	 static Menu callMenu = new Menu();
	 
	 
	public void addManage() {
		
		boolean setupWhile = true;
		 callMenu.Menu3();
       
		 while(setupWhile){
          // Menu.getSchoolMenu(); 
           System.out.println("Select Action:      ");
           
           Menu thirdMenu = new Menu();
           thirdMenu.show(menu3);
           thired_selection = scan.nextInt();
           System.out.println(" ");
           
           switch(thired_selection){
		
		
		
		
		
	}
}
	}
}
