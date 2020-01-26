package connect4;
import java.awt.*;

import javax.swing.*;

public class Endscreen {
	
	public Endscreen() {
		produceScreen();
	}
	
	
	
	public void produceScreen() {
	JFrame lastframe = new JFrame();
	  lastframe.setSize(500,400);
	  lastframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 JPanel p1=new JPanel();
	  
	  if (GameRules.yourTurn==true && GameRules.enemyTurn==false) {
		  
	  JLabel label = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("/YOU_WIN.png")).getImage();
	    label.setIcon(new ImageIcon(img));
	    p1.add(label);
	  }
	    
	   else if (GameRules.yourTurn==false && GameRules.enemyTurn==true) {
	    	
	   JLabel label = new JLabel("");
		 Image img = new ImageIcon(this.getClass().getResource("/YOU_LOST.png")).getImage();
		 label.setIcon(new ImageIcon(img));
		 p1.add(label);

	   }
	   else {
		   JLabel label = new JLabel("");
		    Image img = new ImageIcon(this.getClass().getResource("/YOU_DRAW.png")).getImage();
		    label.setIcon(new ImageIcon(img));
		    p1.add(label);
		   
		   
		   }
	    lastframe.add(p1);
		lastframe.setVisible(true);
	    
	}
}

