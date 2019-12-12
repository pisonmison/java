package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameRules {
	
	public static boolean isFour(int[][] spot, int row, int column, int playerId) {
		
		boolean winCheck =false;
		
		static int r = 6;
		static int c = 7;
		int counter = 0;
		int otherCounter = 0; 
		int playerId = 2;
		int [][] spot = new int [r][c];
		
		//Horizontal prüfen
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
		    continue rightDiagonalCheck;
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
		
		
	}


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
