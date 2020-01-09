package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
///spot soll ein char drin haben, 


public class  GameRules{
	
	public static boolean check = false;
	public static boolean draw = false;
	
	public static char [][] spot = new char [6][7];
	public static boolean playerSwitch = false; /*
	false = gelb // true = rot ->  if playerSwitch false= make buttons for other player not clickable
	*/

	public static int roundsPlayed = 0;
//zum testen
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
}
	
	
	
public static void gridSpot(){
	

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

public void changeCheck() { //zum testen
	if (check == true) {
		check = false;
	}
		
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




public static  void  winCheck() {
	
	checkYellow();
	checkRed();
	checkDraw();
	WinOrNot();
	
	
}

/* WICHTIG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Hier wurden columns und rows ausversehen vertauscht. in dem codecontext ist row = spalte und column = reihe..)
 */
public static void checkYellow() {
	gridSpot(); //aktualise gridSpot 
	
	
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
  
  for  (int column=0; column <3; column++) {
	  for (int row=0; row<7; row++) {
		  if( spot [column][row] == 'X') {
			  if(row > 3
		  
			    && spot[column+1][row - 1] == 'X'
        		&& spot[column+2][row - 2] == 'X'
        		&& spot[column+3][row - 3] == 'X') {
			  	check=true;
		  
			  }
	  }
	  }
}
  
}

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
	  //diagonal up
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
	  //diagonal down
	  for  (int column=0; column <3; column++) {
		  for (int row=0; row<7; row++) {
			  if( spot [column][row] == '0') {
				  if(row > 3
			  
				    && spot[column+1][row - 1] == '0'
	        		&& spot[column+2][row - 2] == '0'
	        		&& spot[column+3][row - 3] == '0') {
				  	check=true;
			  
				  }
		  }
		  }
	}
	  
		  
	  }


public static void checkDraw() {
	if(roundsPlayed >= 41) {
		System.out.print("DRAWWWW");
	}
	
}


}
 /* public static void checkDraw() {
	  gridSpot();
	  if(check == true) {
		  System.out.println("DRAWWWW");
	  }
	  for (int column=0;column >=7;column++) {
		  for (int row=0;row >=7; row++) {
			  if(spot[column][row]!= '-') {
				  check=true;
			  }
				  
		  }
	  }
  }

}
//CLASS GAMERULES

/*
public static void main(String[] args) {
   GameRules logic = new GameRules();
	logic.timerCheckGrid();
    
 }

}
   */









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