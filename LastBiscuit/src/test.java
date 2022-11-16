
import java.util.Scanner;
public class test {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  
    int biscBarrel1 =  6;
    int biscBarrel2 = 8;
    int skipCount1 = 0;
    int skipCount2 = 0;
    int turnCounter = 0;
    int numOfBisc = 0;
    int playerTurn=0;
    //boolean barrelCheck = false;
    //boolean biscCheck = false;
    while (biscBarrel1 != 0 || biscBarrel2 != 0) {
	    boolean barrelCheck = false;
	    boolean biscCheck = false;
	    //myObj = new Scanner(System.in);  
        turnCounter++;
        if (turnCounter % 2 == 0) {
        	playerTurn = 2;
        }
        else {
        	playerTurn = 1;
        }
	    String start = ("Biscuits Left - Barrel 1: " + biscBarrel1 + "\n" +
	    "Biscuits Left - Barrel 2: " + biscBarrel2 + "\n" + "Player Turn: " + playerTurn + "\n" +
	    "Choose a barrel: barrel1 (one), barrel2 (two), or both (both), or skip turn (skip)? ");
	    System.out.print(start);
	    String barrelChoice = myObj.next();
	    while (barrelCheck == false) {
		      if (!barrelChoice.equalsIgnoreCase("one") && !barrelChoice.equalsIgnoreCase("two") && !barrelChoice.equalsIgnoreCase("both") && !barrelChoice.equalsIgnoreCase("skip")) {
		    	   System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), or both (both), or skip turn (skip)? ");
				   barrelChoice = myObj.next();
		      }else {
		    	barrelCheck = true;
		    	}	    		
	    }
        if (barrelChoice.equalsIgnoreCase("skip")){
	    	if ((playerTurn == 1 && skipCount1>0)||(playerTurn == 2 && skipCount2 > 0)) {
	    		System.out.println("sorry youve used your skip");
	    	}else if (playerTurn == 1) {
	    		skipCount1=1;
	    	}else if (playerTurn == 2) {
	    	   skipCount2=1;
        }else {
			    System.out.print("How many biscuits are you taking? ");		
				while (biscCheck == false) {
				    while (!myObj.hasNextInt()) {
				    	System.out.print("Please input an integer: ");
				    	myObj.next();
				    }		
				    biscCheck = true;
				    numOfBisc = myObj.nextInt();	
				}
            }
		if (numOfBisc > biscBarrel1 && numOfBisc >biscBarrel2 && numOfBisc < 1) {
		    	System.out.println("Sorry, that's not a legal number of biscuits for that/those barrel(s)");
				barrelChoice = myObj.nextLine(); 	
		}
	    }
	    if (barrelChoice.equalsIgnoreCase("one")){ 
	    	biscBarrel1 = biscBarrel1-numOfBisc;
	    }else if (barrelChoice.equalsIgnoreCase("two")) {
	    	biscBarrel2 = biscBarrel2-numOfBisc;
	    }else if (barrelChoice.equalsIgnoreCase("both")){
	    	biscBarrel1 = biscBarrel1-numOfBisc;
	    	biscBarrel2 = biscBarrel2-numOfBisc;
	    }else{
	    	if (playerTurn == 1){
	    		skipCount1 = 1;
	        }else {
	        	skipCount2 = 1;
	        }
	    }
  }
   

    System.out.print("Biscuits Left - Barrel 1: 0" + "\n" + "Biscuits Left - Barrel 2: 0" + "\n" + "Winner is player " + playerTurn);
	    
}

	}

