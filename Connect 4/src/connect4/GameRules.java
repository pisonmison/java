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

	for (int row=0; row<6; row++) {
		for (int column=0; column<7; column++){
			char element = GridTest.gamefield.getArray(row, column);
			spot[row][column]= element;
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


//check for a wining row for yellow color
public static void checkYellow() {
	gridSpot(); //update gridSpot array. 
	
	
		//horizontal
        for (int row= 0; row<6; row++){
        	for (int column=0; column<4; column++) {
        	
        	if (	spot[row][column] == 'X' 
        			&& spot[row][column+1] == 'X'
        			&& spot[row][column+2] == 'X'
        			&& spot[row][column+3] == 'X') {
        					check=true;
        			  }
        			 }
        		  }
          //vertical
  for  (int row=0; row <3; row++) {
	  for (int column=0; column<7; column++) {
		  if( spot [row][column] == 'X'
			    && spot[row+1][column] == 'X'
        		&& spot[row+2][column] == 'X'
        		&& spot[row+3][column] == 'X') {
			  		check=true;
		  }
	  }
	  
  }  
  //diagonal up
  for  (int row=0; row <3; row++) {
	  for (int column=0; column<4; column++) {
		  if( spot [row][column] == 'X'
			    && spot[row+1][column + 1] == 'X'
        		&& spot[row+2][column + 2] == 'X'
        		&& spot[row+3][column + 3] == 'X') {
			  		check=true;
			  	}
		  
	  }
  }

  //diagonal down
  
  for  (int row=0; row <6; row++) {
	  for (int column=0; column<4; column++) {
		  if( spot [row][column] == 'X') {
			  if(column> 2
		  
			    && spot[row-1][column +1] == 'X'
        		&& spot[row-2][column +2] == 'X'
        		&& spot[row-3][column +3] == 'X') {
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
	        for (int row= 0; row < 6; row++){
	        	for (int column=0; column<4; column++) {
	        	
	        	if (	spot[row][column] == '0' 
	        			&& spot[row][column+1] == '0'
	        			&& spot[row][column+2] == '0'
	        			&& spot[row][column+3] == '0') {
	        					check=true;
	        			        }
	        			   }
	        		  }
	          //vertical
	  for  (int row=0; row <3; row++) {
		  for (int column=0; column<7; column++) {
			  if( spot [row][column] == '0'
				    && spot[row+1][column] == '0'
	        		&& spot[row+2][column] == '0'
	        		&& spot[row+3][column] == '0') {
				  		check=true;
			  }
		  }
		  
	  }  
	  //diagonal left up
	 for  (int row=0; row <3; row++) {
		  for (int column=0; column<4; column++) {
			  if( spot [row][column] == '0'
				    && spot[row+1][column + 1] == '0'
	        		&& spot[row+2][column + 2] == '0'
	        		&& spot[row+3][column + 3] == '0') {
				  		check=true;
			  }
		  }
		  
	  }
	 
	  //diagonal right up
	 for  (int row=0; row <6; row++) {
		  for (int column=0; column<4; column++) {
			  if( spot [row][column] == '0') {
				  if(column > 2
			  
				    && spot[row -1][column +1] == '0'
	        		&& spot[row -2][column +2] == '0'
	        		&& spot[row -3][column +3] == '0') {
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
 