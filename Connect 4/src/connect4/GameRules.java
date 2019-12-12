package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GameRules {
	
	public static boolean isFour([][] values) {
		
		int numberOfRows = values.length;
		int numberOfColumns = values.length;
		
		//Check row
		for (int i= 0; i < numberOfRows; i++) {
			if (isConsecutiveFour(value[i]))
				return true;
		}
		
		//Check Colums
		for (int j= 0; j < numberOfColumns; j++) {
			char[] column = new char[numberOfRows];
			
			
		}
		
		//Check lowerPart
		for (int i=0; i< numberOfRows -3; i++) { 
			int diagonalElements = Math.min(numberOfRows -i, numberOfColumns);
		}
		
	}

}


