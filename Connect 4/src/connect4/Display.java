package connect4;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Display implements ActionListener {
	
	// Create a simple GUI window
	//declare the different stuff which we add to the window like buttons, textlabels etc. for better overseeing
	private JFrame mainframe, secondframe;
	private JLabel textlabel1, textlabel2, ipText, portText, nameText;
	private JButton b1, b2, connectButton;
	private JPanel p1, p2, p3;
	
	private JTextField ipInput, portInput, nameInput;
	
	//private String username = "asdasd";
	
	Player player1 = new Player();
	
	

	
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
	      mainframe.setLocationRelativeTo(null); // zeige fenster in der mitte des bildschirms an, ohne das command wirds immer links oben ge�ffnet
	   
	      mainframe.setVisible(true);
	   }
	   // if Object Display is made, it automatically calls the createWindow method.
	  public Display() {
		  createWindow();
	  }
	   
	   
	  //action method which calls when button to which the ActionListened is bound to, is pressed
	  public void actionPerformed(ActionEvent e) {
	       if(e.getSource() == b1) {
	    	   
	    	   createConnectWindow();
	       }
	       
	       if(e.getSource() == connectButton) {
	    	   //save input string into username string and close window again(make it invisible)
	    	   submitAction();
	    	   secondframe.setVisible(false);
	    	   mainframe.setVisible(false);
	    	   //createGrid();
	    	  // Grid();
	    	   
	    	  
	    	//   System.out.println(p); //just for testing
	    	   
	    	  
	       }
	    }
	  
	  
	  
	 
	      
	    
		  
		  
		////creating a window where user can input his name and ip/port to which he want to connect 

	  
	  public void createConnectWindow() {
		  
		  secondframe = new JFrame("Connect to Server");
		 
		  secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  //creating input fields for ip,port,name
		  ipInput = new JTextField(10);
		  portInput = new JTextField(6);
		  nameInput = new JTextField(10);
		  
		  //creating headlines over the input fields, so user know which field is for which input
		  ipText = new JLabel("IP-Adress");
		  portText = new JLabel("Port Number");
		  nameText = new JLabel("Username");
		  
		  
	      
		  connectButton = new JButton("Connect!");
		  connectButton.addActionListener(this);
		  
		  //left pannel with textfields for ip/port/username
		  p1 = new JPanel();
		  p1.setLayout(new GridLayout(2, 3));
		  p1.add(ipText);
		  p1.add(portText);
		  p1.add(nameText);
		  p1.add(ipInput);
		  p1.add(portInput);
		  p1.add(nameInput);
		  
		  
		  
		  
		  
		  secondframe.add(p1, BorderLayout.WEST);
		  secondframe.add(connectButton, BorderLayout.EAST);
		  secondframe.pack();
		  secondframe.setVisible(true);
		  
	  }
	
	  //save input string to string variable "username" -> next step: save to string in class Player
	  private void submitAction() {
		  
		  //f�r spieler1
		  player1.setPlayername(nameInput.getText());
		  player1.setPlayerIP(ipInput.getText());
		  player1.setPlayerPort(portInput.getText());
	      player1.printplayerInfo();
	
	      
	      //f�r spieler2
	      
	  }
	  
	  
	  
	  
	  //main methode 
	  
	  /*public static void main(String[] args) {
	      Display test = new Display();
	   }
	
	  
	  */
	  
	  
	  
	  
	  
	 

}
