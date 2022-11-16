import java.util.Scanner;
public class LastBiscuit {
	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);  
	    //number of biscuits in barrel 1
	    final int x = 6;
	    int biscBarrel1 = x;
	    final int y = 8;
	    int biscBarrel2 = y;
	    //number of biscuits in barrel 2
	    int skipCount1 = 0;
	    int skipCount2 = 0;
	    int turnCounter = 0;
	    int numOfBisc = 0;
	    int playerTurn = 0;
	    
	    
	
	    while (biscBarrel1 != 0 || biscBarrel2 != 0) {
		    boolean barrelCheck = false;
		    boolean biscCheck = false;
		    //myObj = new Scanner(System.in);  
	        turnCounter++;
	        
	        //increments the turn counter
	        
            if (turnCounter % 2 == 0) {
            	playerTurn = 2;
            } else {
            	playerTurn = 1;
            }
            
//finds mod of turn to determine if turn one or two
		    String start = ("Biscuits Left - Barrel 1: " + biscBarrel1 + "\n" 
		    + "Biscuits Left - Barrel 2: " + biscBarrel2 + "\n" + "Player Turn: " 
		    + playerTurn + "\n" + "Choose a barrel: barrel1 (one), "
		    + "barrel2 (two), or both (both), or skip turn (skip)? ");
		    System.out.print(start);
			String barrelChoice = myObj.next();
		    while (!barrelCheck) {
		      if (!barrelChoice.equalsIgnoreCase("one")
		    	&& !barrelChoice.equalsIgnoreCase("two")
		    	&& !barrelChoice.equalsIgnoreCase("both")  
		    	&& !barrelChoice.equalsIgnoreCase("skip")) {
		    	   System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), "
		    	   		+ "or both (both), or skip turn (skip)? ");
				   barrelChoice = myObj.next();
		       } else {
		    	barrelCheck = true;
		    	}	    		
		    }
		    
	       if (barrelChoice.equalsIgnoreCase("skip")) {
		    	if ((playerTurn == 1 && skipCount1 > 0) 
		    			|| (playerTurn == 2 && skipCount2 > 0)) {
		    		System.out.println("sorry youve used your skip");
		    		turnCounter=turnCounter-1;
		    		
//checks if the players have already used a skip if they have they get rejected
		    		
		    	} else if (playerTurn == 1) {
		    		skipCount1=1;
		    	} else if (playerTurn == 2) {
		    	   skipCount2=1;
		    	   }
		    } else {
			  System.out.print("How many biscuits "
			  		+ "are you taking? ");	
//checks if the number inputed is and integer if not continuous loop applied
				while (!biscCheck) {
					while (!myObj.hasNextInt()) {
					    	System.out.print("Please input an integer: ");
					    	myObj.next();
					}
					    biscCheck = true;
					    numOfBisc = myObj.nextInt();
				}
//checks if the number of biscuits  selected is 
//available in the barrels or if a positive integer
			if (barrelChoice.equals("both") && (numOfBisc > biscBarrel1
					||numOfBisc > biscBarrel2)) {
		    	System.out.println("Sorry, that's not a legal number of "
		    			+ "biscuits for that/those barrel(s)");
				barrelChoice = myObj.nextLine();
		    }else if (((barrelChoice.equals("one")  && numOfBisc > biscBarrel1) 
		    		|| (numOfBisc<1))) {
		    	System.out.println("Sorry, that's not a legal number of "
		    			+ "biscuits for that/those barrel(s)");
		    	barrelChoice = myObj.nextLine(); 
		    }else if ((barrelChoice.equals("two")  && numOfBisc > biscBarrel2)){
		    	System.out.println("Sorry, that's not a legal number of "
		    			+ "biscuits for that/those barrel(s)");
				barrelChoice = myObj.nextLine(); 
			   
		   }
		
//calculates how many biscuits are removed from the barrels
					
		    if (barrelChoice.equalsIgnoreCase("one")) { 
		    	biscBarrel1 = biscBarrel1 - numOfBisc;
		    } else if (barrelChoice.equalsIgnoreCase("two")) {
		    	biscBarrel2 = biscBarrel2 - numOfBisc;
		    } else if (barrelChoice.equalsIgnoreCase("both")) {
		    	biscBarrel1 = biscBarrel1 - numOfBisc;
		    	biscBarrel2 = biscBarrel2 - numOfBisc;
		    }
	    }
	   
	}
	    System.out.println("Biscuits Left - Barrel 1: 0" + "\n" + "Biscuits"
	    		+ " Left - Barrel 2: 0" + "\n" + "Winner is player " + playerTurn);
	    


	}
}

