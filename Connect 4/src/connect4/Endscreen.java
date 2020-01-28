package connect4;
import java.awt.*;

import javax.swing.*;

public class Endscreen {
	
	public Endscreen() {
		produceScreen();
	}
	
	
	//produce different endscreens based on actual game state
	public void produceScreen() {
	JFrame lastframe = new JFrame();
	  lastframe.setSize(640,360);
	  lastframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 JPanel p1=new JPanel();
	 
	 
	 if(GameRules.draw) {
		 	
		 	//for loading the images the same code sample as in "GridTest" is used
		 	JLabel label = new JLabel("");
		    Image img = new ImageIcon(this.getClass().getResource("/drawResized.png")).getImage();
		    label.setIcon(new ImageIcon(img));
		    p1.add(label);
		   
		   

	 }
	 else {
	 
	 
	  if (GameRules.yourTurn==true && GameRules.enemyTurn==false) {
		  
		  JLabel label = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("/win.png")).getImage();
	    label.setIcon(new ImageIcon(img));
	    p1.add(label);
	  }
	    
	   else if (GameRules.yourTurn==false && GameRules.enemyTurn==true) {
	    	
	   JLabel label = new JLabel("");
		 Image img = new ImageIcon(this.getClass().getResource("/lost.png")).getImage();
		 label.setIcon(new ImageIcon(img));
		 p1.add(label);

	   }
		   }
	    
	  
	  	lastframe.add(p1);
	  	lastframe.setLocationRelativeTo(null);
	  	lastframe.pack();
		lastframe.setVisible(true);
	    
	}
}

