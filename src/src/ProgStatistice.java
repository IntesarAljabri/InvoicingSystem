package src;
public class ProgStatistice {

	public void statistic() {
	        int selection1 = 0;
	        int selection2 = 0;
	        int selection3 = 0;
	        int selection4 = 0;
	        int selection5 = 0;
	        int selection6 = 0;
	        
	        
	            for(int i=0; i<Main.stack.size(); i++){
	                if (Main.stack.get(i).equals("1")) {
	                    selection1++;
	                }
	                else if(Main.stack.get(i).equals("2")){
	                   selection2++; 
	                }
	                else if(Main.stack.get(i).equals("3")) {
	                    selection3++;
	                }
	                else if(Main.stack.get(i).equals("4")){
	                   selection4++; 
	                }
	                else if(Main.stack.get(i).equals("5")){
	                   selection5++; 
	                }
	                else if(Main.stack.get(i).equals("5")){
		                   selection6++; 
		                }
		                
	            }
	            
	            System.out.println("Shop Setting =        "+selection1);
	            System.out.println("Manage shop =          "+selection2);
	            System.out.println("Create new Invoic  =   "+selection3);
	            System.out.println("Report Statistic  =    "+selection4);
	            System.out.println("Report     =           "+selection5);
	            System.out.println("Search Invoic id     = "+selection6);
	    }
	    
		
	}


