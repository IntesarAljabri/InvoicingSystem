package src;
import java.util.*;

public class Main {
	
	static ArrayList<String> menu1 =new ArrayList<String>();
	static Scanner scan = new Scanner(System.in);
    static Stack<String> stack = new Stack<String>();
    static Product newItem1 = new Product();
    
    
    
    static boolean program = true;
    static int first_selection;
    
    static Menu callMenu =new Menu();
	public static Object newItem;
    
	public static void main(String[] args) {
	
		callMenu.Menu1();
		
	      while(program){
	       System.out.println();
	       System.out.println("select action  :");
	       Menu firstMenu = new Menu();
	       firstMenu.show(menu1);
	       first_selection=scan.nextInt();
	       first_selection--;
		
		
	   	try {
	       if(menu1.get(first_selection).equals("shop setting"))
	       {
	    	   ShopeSetting detail = new ShopeSetting();
	           detail.ShopeSetting();
	       }
	          else if(menu1.get(first_selection).equals("Manage Shop"))
	          {
	              ManageShop newmanage = new ManageShop();
	              newmanage.addManage();
	          }
	          else if(menu1.get(first_selection).equals("Create New Invoicing"))
	          {
	              Create newInvoic = new Create();
	          }
	          else if(menu1.get(first_selection).equals("Report : Statistic"))
	          {
	              reportStatistic newreport= new reportStatistic();
	              newreport.addreport();
	          }
	          else if(menu1.get(first_selection).equals("Report"))
	          {
	              Report showList = new Report();
	              showList.list();
	          }
	          else if(menu1.get(first_selection).equals("Search"))
	          {
	        	  SearchInvoic invoic = new SearchInvoic();
	        	  invoic.search();
	              
	          }
	          else if (menu1.get(first_selection).equals("Program Statitistic"))
	          {
	              ProgStatistice Statistic = new ProgStatistice();
	              Statistic.statistic();
	          }
	          else if(menu1.get(first_selection).equals("exit"))
	          { 
	        	  boolean repeat=true;
	        	  
	        	  while(repeat){
	                  System.out.println(" ");
	                  System.out.print("Are You Sure You Want To Exit ? Y - N ");
	                  String select=scan.next();
	                  if(select.equals("N") || select.equals("n")){
	                      repeat = false;
	                      break;
	                  }
	                  else if(select.equals("y")||select.equals("Y")){
	                	  program=false;
	                      break;
	                  }
	                  else{
	                      System.out.println("Invalid letter  ");
	                  }
	              }
	          }
	   	}
	   	
	   	
             catch (Exception ex) {
                 System.out.println("Wrong Number ");
          
            }
	      }
	
	}
}


	  
		

