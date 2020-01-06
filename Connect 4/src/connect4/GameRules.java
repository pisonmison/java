package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameRules{
	
	int [][] spot = new int [7][6];
	int row;
	int column;
	
public void gridSpot(){
	

	for (int row=0; row<6; row++) {
	for (int column=0; column<7; column++){
		spot[column][row]=0;
    	}
     }
}
//Ab hier checken ob vier Stück vorhanden sind
public boolean winCheck() {
	boolean check=false;

//horizontal
for (int row = 0; row < 6; row++){
	for (int column=0; column<4; column++) {
	if (spot[column][row]!=0 && spot[column][row] == spot[column+1][row] && spot[column][row]==spot[column+2][row] && spot [column][row]==spot[column+3][row]) {
			check=true;
	    }
	  }
    }
//vertical
for (int row=0; row<3; row++){
	for (int column = 0; column<7; column++) {
	if (spot[column][row]!=0 && spot[column][row] == spot[column][row+1] && spot[column][row]==spot[column][row+2] && spot [column][row]==spot[column][row+3]) {
			check=true;
	   }
	 }
   }
//diagonal up
for (int row=0; row <3; row++) {
	for(int column=0; column<4; column++) {
		if(spot[column][row] !=0 && spot[column][row] == spot[column+1][row+1] && spot[column][row] == spot[column+2][row+2] && spot[column][row] == spot[column+3][row+3]) {
			check=true;
		}
	}
}

//diagonal down
for (int row=0; row <6; row++) {
	for(int column=0; column<4; column++) {
		if(spot[column][row] !=0 && spot[column][row] == spot[column+1][row-1] && spot[column][row] == spot[column+2][row-2] && spot[column][row] == spot[column+3][row-3]) {
			check=true;
		}
	}
}

return check;
}//winCheckSchleife
}//GameRulesSchleife












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