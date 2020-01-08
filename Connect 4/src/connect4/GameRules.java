package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

///spot soll ein char drin haben, 


public class GameRules{
	
	public static boolean check = false;
	char [][] spot = new char [6][7];

	
public void gridSpot(){
	

	for (int column=0; column<6; column++) {
		for (int row=0; row<7; row++){
			char element = GridTest.gamefield.getArray(column, row);
			spot[column][row]= element;
    	}
     }
}

public GameRules() {
	gridSpot();
	//printGridSpot();
	
}

public void printGridSpot() {
	// nur zum testen, weil der hier gridSpot array printen soll
	for(int i = 0; i < spot.length; i++) {
		for (int j = 0; j < spot[i].length; j++) {
			System.out.print(spot[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
}
public void winCheck() {
	//GridTest.gamefield.printArray();
	checkYellow();
	checkRed();
	checkDraw();
}


public void checkYellow() {
	gridSpot();
	if(check == true) {
		 System.out.print("Vier in einer Reihe: WIN WIN WIN WIN");
	}
	
	
		//Horizonal fuer gelb
        for (int column= 0; column<7; column++){
        	for (int row=0; row<3; row++) {
        	
        	if (	spot[column][row] == 'X' 
        			&& spot[column+1][row] == 'X'
        			&& spot[column+2][row] == 'X'
        			&& spot[column+3][row] == 'X') {
        					check=true;
        			  }
        			 }
        		  }
          //vertical
  for  (int column=0; column <7; column++) {
	  for (int row=0; row<3; row++) {
		  if( spot [column][row] == 'x'
			    && spot[column][row + 1] == 'X'
        		&& spot[column][row + 2] == 'X'
        		&& spot[column][row + 3] == 'X') {
			  		check=true;
		  }
	  }
	  
  }  
  //diagonal up
  for  (int column=0; column <7; column++) {
	  for (int row=0; row<3; row++) {
		  if( spot [column][row] == 'x'
			    && spot[column+1][row + 1] == 'X'
        		&& spot[column+2][row + 2] == 'X'
        		&& spot[column+3][row + 3] == 'X') {
			  		check=true;
		  }
	  }
	  
  }
  //diagonal down
  for  (int column=0; column <7; column++) {
	  for (int row=0; row<3; row++) {
		  if( spot [column][row] == 'x'
			    && spot[column+1][row - 1] == 'X'
        		&& spot[column+2][row - 2] == 'X'
        		&& spot[column+3][row - 3] == 'X') {
			  		check=true;
		  }
	  }
  }
}
  public void checkRed() {
		gridSpot();
		if(check == true) {
			 System.out.print("Vier in einer Reihe: WIN WIN WIN WIN");
			 }
		
		
			//Horizonal fuer gelb
	        for (int column= 0; column < 7; column++){
	        	for (int row=0; row<3; row++) {
	        	
	        	if (	spot[column][row] == 'O' 
	        			&& spot[column+1][row] == 'O'
	        			&& spot[column+2][row] == 'O'
	        			&& spot[column+3][row] == 'O') {
	        					check=true;
	        			  }
	        			 }
	        		  }
	          //vertical
	  for  (int column=0; column <7; column++) {
		  for (int row=0; row<3; row++) {
			  if( spot [column][row] == 'O'
				    && spot[column][row + 1] == 'O'
	        		&& spot[column][row + 2] == 'O'
	        		&& spot[column][row + 3] == 'O') {
				  		check=true;
			  }
		  }
		  
	  }  
	  //diagonal up
	  for  (int column=0; column <7; column++) {
		  for (int row=0; row<3; row++) {
			  if( spot [column][row] == 'O'
				    && spot[column+1][row + 1] == 'O'
	        		&& spot[column+2][row + 2] == 'O'
	        		&& spot[column+3][row + 3] == 'O') {
				  		check=true;
			  }
		  }
		  
	  }
	  //diagonal down
	  for  (int column=0; column <7; column++) {
		  for (int row=0; row<3; row++) {
			  if( spot [column][row] == 'O'
				    && spot[column+1][row - 1] == 'O'
	        		&& spot[column+2][row - 2] == 'O'
	        		&& spot[column+3][row - 3] == 'O') {
				  		check=true;
			  }
		  }
		  
	  }
	  
		  
	  }
  public void checkDraw() {
	  gridSpot();
	  if(check == true) {
		  System.out.println("DRAWWWW");
	  }
	  for (int column=0;column >=7;column++) {
		  for (int row=0;row >=7; row++) {
			  if(spot[column][row]!= 'X' && spot [column][row] != 'O') {
				  check=true;
			  }
				  
		  }
	  }
  }

}//CLASS GAMERULES
   
//Ab hier checken ob vier Stück vorhanden sind
/*public boolean winCheck() {
	//boolean check=false;
	if (check == true) {
		System.out.print("Vier in einer Reihe: WIN WIN WIN WIN");
	}
/*
//horizontal
for (int column= 0; column < 6; column++){
	for (int row=0; row<4; row++) {
	
	if (spot[column][row]!=0 && spot[column][row] == spot[column+1][row] && spot[column][row]==spot[column+2][row] && spot [column][row]==spot[column+3][row]) {
			check=true;
	    }
	  }
    }
//vertical
for (int column=0; column<3; column++){
	for (int row = 0; row<7; row++) {
	if (spot[column][row]!=0 && spot[column][row] == spot[column][row+1] && spot[column][row]==spot[column][row+2] && spot [column][row]==spot[column][row+3]) {
			check=true;
	   }
	 }
   }
//diagonal up
for (int column=0; column <3; column++) {
	for(int row=0; row<4; row++) {
		if(spot[column][row] !=0 && spot[column][row] == spot[column+1][row+1] && spot[column][row] == spot[column+2][row+2] && spot[column][row] == spot[column+3][row+3]) {
			check=true;
		}
	}
}

//diagonal down
for (int column=0; column <6; column++) {
	for(int row=0; row<4; row++) {
		if(spot[column][row] !=0 && spot[column][row] == spot[column+1][row-1] && spot[column][row] == spot[column+2][row-2] && spot[column][row] == spot[column+3][row-3]) {
			check=true;
		}
	}
}

return check;
}*///winCheckSchleife
//}}GameRulesSchleife












/*public class GameRules {
	
	
	boolean winCheck =false;
	
	int row = 0;
	int column = 0;
	int counter = 0;
	int otherCounter = 0; 
	int playerId1 = 2;
	int [][] spot1 = new int [row][column];
	
	int cHRed = 0;
	
	
	
	public void checkRed() {
	for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {

	      char spot = GridTest.gamefield.getArray(j, k);
	      if(spot == 'X') {
	    	  cHRed++;
	      }
	    }
	  }
	if(cHRed == 4) {
		System.out.print("Vier in einer Reihe: WIN WIN WIN WIN");
	}
}
	
	      
	      
	      
	      public boolean isFour(int[][] spot, int rowY, int columnX, int playerId) {
		
		
		
		GridArray gamefield = new GridArray();
		//Horizontal prüfen
		
		char colorSpot = gamefield.getArray(row, column);
		
		
		
		
		
		checkHorizontal:
		while (true) {
			
			if (column + (counter+1) <= 7) {
				if (spot [row] [column + counter] == playerId && winCheck == false) {
					
					counter++;
					continue checkHorizontal;
				}
			}
				
		winCheck = true;
		if (column - (otherCounter + 1) > 0)
	    {
		if (spot [row] [(column - 2) - otherCounter] == playerId)
		{
		    otherCounter++;
		    continue checkHorizontal;
		}
	  }
	    if (counter == 3 || counter + otherCounter == 3 || otherCounter == 3)
	    {
		return true;
	    }
	    winCheck = false;
	    counter = 0;
	    otherCounter = 0;
	    break;
	}
	//Vertical abcheken ob es vier stück gibt
		checkVertical:
	while (true)
	{
	    if (row + counter <= 3)
	    {
		if (spot [row + 1 + counter] [column - 1] == playerId && winCheck == false)
		{
		    counter++;
		    continue checkVertical;
		}
	 }
	    winCheck = true;
	    if (row - otherCounter > 0)
	    {
		if (spot [row - 1 - otherCounter] [column - 1] == playerId)
		{
		    otherCounter++;
		    continue checkVertical;
		}
	 }
	    if (counter == 3 || counter + otherCounter == 3 || otherCounter == 3)
	    {
		return true;
	    }
	    winCheck = false;
	    counter = 0;
	    otherCounter = 0;
	    break;
	}
	//Ab hier Diagonal
	checkRightDiagonal:
	while (true)
	{
	    if (row + counter < 4 && column + (counter + 1) <= 7)
	    {
		if (spot [row + 1 + counter] [column + counter] == playerId && winCheck == false)
		{
		    counter++;
	//	    continue rightDiagonalCheck;
		}
   }
	    winCheck = true;
	   
	    if (row - otherCounter > 0 && column - (otherCounter + 1) > 0)
	    {
		if (spot [row - 1 - otherCounter] [(column - 2) - otherCounter] == playerId)
		{
		    otherCounter++;
		    continue checkRightDiagonal;
		}
   }
	    if (counter == 3 || counter + otherCounter == 3 || otherCounter == 3)
	    {
		return true;
	    }
	    winCheck = false;
	    counter = 0;
	    otherCounter = 0;
	    break;
	}
	checkLeftDiagonal:
	while (true)
	{
	    if (row + counter < 4 && column - (counter + 1) > 0)
	    {
		if (spot [row + 1 + counter] [(column - 2) - counter] == playerId && winCheck == false)
		{
		    counter++;
		    continue checkLeftDiagonal;
		}
	    }
	    winCheck = true;
	    if (row - otherCounter > 0 && column + (otherCounter + 1) <=7)
	    {
		if (spot [row - 1 - otherCounter] [column + otherCounter] == playerId)
		{
		    otherCounter++;
		    continue checkLeftDiagonal;
		}
	    }
	    if (counter == 3 || counter + otherCounter == 3 || otherCounter == 3)
	    {
		return true;
	    }
	    winCheck = false;
	    counter = 0;
	    otherCounter = 0;
	    break;
	}
	return false;
			}
		
		
	} */

//<<<<<<< HEAD

//Muss PlayerId einsetzen um zu gucken wer immer dran ist, aber auch nochmal nachgucken
/*
 * while (true) {
 *    if(playerId == 1) {
 *    playerId= 2;
 *    }
 *    else{
 *    playerId = 1;
 *    }
 *    */

//Farbe bin ich mir net sicher ob es so klappt muss nochmal nachgucken
/*
 * if(playerId ==1)
 * playerId.setColor (color.red);
 * }
 * else
 * {
 * playerId.setColor (color.yellow);
 * }
 * */
/*=======
}


>>>>>>> branch 'master' of https://github.com/pisonmison/java.git
*/