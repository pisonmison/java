package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Display implements ActionListener {
	
	// Create a simple GUI window
	//declare the different stuff which we add to the window like buttons, textlabels etc. for better overseeing
	private JFrame mainframe, secondframe;
	private JLabel textlabel1, textlabel2;
	private JButton b1, b2;
	private JPanel p1, p2, p3;
	
	private JTextField userInput;
	
	private String username = "";
	
	

	
	  public void createWindow() {
	      //Create new frame aka window
	      mainframe = new JFrame("Connect 4");
	      mainframe.setSize(500,400);
	      mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      //create a label
	      textlabel1 = new JLabel("Press Button to start Game",SwingConstants.CENTER);
	      textlabel1.setPreferredSize(new Dimension(200, 50));
	      textlabel2 = new JLabel(" CONNECT FOUR", SwingConstants.HORIZONTAL);
	      textlabel2.setPreferredSize(new Dimension(100,50));
	      
	     
	      //create a panel, pannel gathers all components like buttons, labels together, so you can display them where you want, 
	      // button + label in bottom corner? -> add them to a pannel p1 and make f.add(p1.Borderlayout.bottomcorner(south))
	      
	      p1 = new JPanel();
	      
	      p2 = new JPanel();
	     
	      p3 = new JPanel();
	      
	      
	      //create a new button
	      b1 = new JButton("Start Game");
	      b1.setPreferredSize(new Dimension(150,50));
	      
	      
	      //add actionlietsener to button b1
	      b1.addActionListener(this);
	      
	  
	      //add buttons and pannel into the frame
	      p1.add(b1, BorderLayout.CENTER);
	      p2.add(textlabel1, BorderLayout.CENTER);
	      p3.add(textlabel2, BorderLayout.CENTER);
	      mainframe.add(p1,BorderLayout.SOUTH);
	      mainframe.add(p2,BorderLayout.CENTER);
	      mainframe.add(p3, BorderLayout.NORTH);
	      
	     
	      
	     
	      //Display the window.
	      mainframe.setLocationRelativeTo(null); // zeige fenster in der mitte des bildschirms an, ohne das command wirds immer links oben geöffnet
	   
	      mainframe.setVisible(true);
	   }
	   // if Object Display is made, it automatically calls the createWindow method.
	  public Display() {
		  createWindow();
	  }
	   
	   
	  //action method which calls when button to which the ActionListened is bound to, is pressed
	  public void actionPerformed(ActionEvent e) {
	       if(e.getSource() == b1) {
	    	   
	    	   createNameWindow();
	       }
	       
	       if(e.getSource() == b2) {
	    	   //save input string into username string and close window again(make it invisible)
	    	   submitAction();
	    	   secondframe.setVisible(false);
	    	  
	    	   System.out.println(username); //just for testing
	    	   
	       }
	    }
	  
	  
	  
	  
	  //method to create a small window, where the player can put in their nickname aka his player name
	  public void createNameWindow() {
		  
		  secondframe = new JFrame("Connect 4");
		  secondframe.setSize(300,200);
		  secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      userInput = new JTextField(10);
	      b2 = new JButton("Done!");
	      b2.addActionListener(this);
	      
	      textlabel1 = new JLabel("Please enter your Nickname");
	      
	      
	      p1 = new JPanel();
	      p1.add(userInput, BorderLayout.CENTER);
	      
	      p2 = new JPanel();
	      p2.add(b2, BorderLayout.CENTER);
	      
	      
	      p3 = new JPanel();
	      p3.add(textlabel1, BorderLayout.CENTER);
	      
	     
	      secondframe.add(p3, BorderLayout.NORTH);
	      secondframe.add(p1, BorderLayout.CENTER);
	      secondframe.add(p2, BorderLayout.SOUTH);
	      
	      secondframe.setLocationRelativeTo(null);
	      secondframe.setVisible(true);
	      
		  
		  
		  
		  
	  }
	  
	  //save input string to string variable "username" -> next step: save to string in class Player
	  private void submitAction() {
		  
		  username = userInput.getText();
		  
	  }
	  
	  
	  
	  
	  //main methode 
	  
	  /*public static void main(String[] args) {
	      Display test = new Display();
	   }
	
	  */
	  
	  
	  
	  
	  
	  
	 

}
