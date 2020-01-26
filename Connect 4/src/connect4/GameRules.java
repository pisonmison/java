package connect4;


public class  GameRules{
	
	
	//declare needed variables
	protected static boolean check = false;
	protected static boolean draw = false;
	
	private static char [][] spot = new char [6][7];
	protected static   boolean yourTurn = false; 
	protected static   boolean enemyTurn = false;
	
	static int roundsPlayed = 0;





	//console output for testing
	public static void WinOrNot() {
	System.out.println("");
	System.out.printf("Round:" + roundsPlayed);
	System.out.println("");
	System.out.print("Win? :");
	if(check == true) {
		System.out.print("YES");
	}
	
	else {
		System.out.print("NO");
	}
	System.out.println("");
}
	
	
	
public static void gridSpot(){
	
	//use gridSpot array as storage, copy gotten array elements into it.

	for (int column=0; column<6; column++) {
		for (int row=0; row<7; row++){
			char element = GridTest.gamefield.getArray(column, row);
			spot[column][row]= element;
    	}
     }
}

//create the logic, copy array at the beginning
public GameRules() {
	gridSpot();
	
	
}





//print the gridspot array on console for testing purposes
public void printGridSpot() {
	// console output of array 
	for(int i = 0; i < spot.length; i++) {
		for (int j = 0; j < spot[i].length; j++) {
			System.out.print(spot[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
}



/*winCheck method calls all the checking win methods
 * below, just for cleaner use, also prints console output
 * 
 */

public static  void  winCheck() {
	
	checkYellow();
	checkRed();
	checkDraw();
	WinOrNot();
	
	
}

/* IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * in the following context of code columns = rows and rows = columns. Basically the opposite, the code works as intended tho.
 */


//check for a wining row for yellow color
public static void checkYellow() {
	gridSpot(); //update gridSpot array. 
	
	
		//Horizonal fuer gelb
        for (int column= 0; column<6; column++){
        	for (int row=0; row<4; row++) {
        	
        	if (	spot[column][row] == 'X' 
        			&& spot[column][row+1] == 'X'
        			&& spot[column][row+2] == 'X'
        			&& spot[column][row+3] == 'X') {
        					check=true;
        			  }
        			 }
        		  }
          //vertical
  for  (int column=0; column <3; column++) {
	  for (int row=0; row<7; row++) {
		  if( spot [column][row] == 'X'
			    && spot[column+1][row] == 'X'
        		&& spot[column+2][row] == 'X'
        		&& spot[column+3][row] == 'X') {
			  		check=true;
		  }
	  }
	  
  }  
  //diagonal up
  for  (int column=0; column <3; column++) {
	  for (int row=0; row<4; row++) {
		  if( spot [column][row] == 'X'
			    && spot[column+1][row + 1] == 'X'
        		&& spot[column+2][row + 2] == 'X'
        		&& spot[column+3][row + 3] == 'X') {
			  		check=true;
			  	}
		  
	  }
  }

  //diagonal down
  
  for  (int column=0; column <6; column++) {
	  for (int row=0; row<4; row++) {
		  if( spot [column][row] == 'X') {
			  if(column> 2
		  
			    && spot[column-1][row +1] == 'X'
        		&& spot[column-2][row +2] == 'X'
        		&& spot[column-3][row +3] == 'X') {
			  	check=true;
		  
			  }
	      }
	  }
}
  
}


//check for a winning row as red color
  public static void checkRed() {
		gridSpot();
		
		
			//Horizonal fuer rot
	        for (int column= 0; column < 6; column++){
	        	for (int row=0; row<4; row++) {
	        	
	        	if (	spot[column][row] == '0' 
	        			&& spot[column][row+1] == '0'
	        			&& spot[column][row+2] == '0'
	        			&& spot[column][row+3] == '0') {
	        					check=true;
	        			        }
	        			   }
	        		  }
	          //vertical
	  for  (int column=0; column <3; column++) {
		  for (int row=0; row<7; row++) {
			  if( spot [column][row] == '0'
				    && spot[column+1][row] == '0'
	        		&& spot[column+2][row] == '0'
	        		&& spot[column+3][row] == '0') {
				  		check=true;
			  }
		  }
		  
	  }  
	  //diagonal left up
	 for  (int column=0; column <3; column++) {
		  for (int row=0; row<4; row++) {
			  if( spot [column][row] == '0'
				    && spot[column+1][row + 1] == '0'
	        		&& spot[column+2][row + 2] == '0'
	        		&& spot[column+3][row + 3] == '0') {
				  		check=true;
			  }
		  }
		  
	  }
	 
	  //diagonal right up
	 for  (int column=0; column <6; column++) {
		  for (int row=0; row<4; row++) {
			  if( spot [column][row] == '0') {
				  if(column > 2
			  
				    && spot[column -1][row +1] == '0'
	        		&& spot[column -2][row +2] == '0'
	        		&& spot[column -3][row +3] == '0') {
				  	check=true;
			  
				  }
		     }
		}
	}
	  
	  
	  }


  
  
  /*check rounds played
  if players made more than 42 moves(starting from 0) 
  the game ends in a draw because all spaces are filled
  */
public static void checkDraw() {
	
	
	for(int i = 0; i < spot.length; i++) {
		for (int j = 0; j < spot[i].length; j++) {			
			if(spot[i][j] == '-') {
				return;
			}
			
		}
		
	}
	check=true;
	draw=true;
	
}


}
 