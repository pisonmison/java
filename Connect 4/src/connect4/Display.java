package connect4;


import java.awt.*;

import javax.swing.*;



public class Display extends JFrame{
	
	// Create a simple GUI window
	//declare the different stuff which we add to the window like buttons, textlabels etc. for better overseeing
	private JFrame mainframe, secondframe, endframe,lastframe;
	private JLabel textlabel1, textlabel2, ipText, portText, nameText;
	private JButton b1, connectButton;
	private JPanel p1, p2, p3;
	private boolean connectToServer = false;
	private boolean connectToClient = false;
	private JTextField ipInput, portInput, nameInput;
	
	
	
	Player player = new Player();
	
	
	  // if Object Display is made, it automatically calls the createWindow method.
	public Display() {
		createWindow();
	  }
	
	public void createEndingWindow(){
		endframe = new JFrame();
		endframe.setSize(500,400);
		endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();

		JLabel label = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("/emptyBox.png")).getImage();
	    label.setIcon(new ImageIcon(img));
	    p1.add(label);
		
		endframe.add(p1);
		endframe.setVisible(true);
		
		
		
		
		
	}

	
	/*
	 * use option pane to create a window
	 * GUI bugged when launching from  a already running mainframe window
	 * launching it from optionPane window works tho
	 * option pane has 3 buttons which are defined in option string(YES,NO,CLOSE)
	 * also dialog stuff is added like title, etc. 
	 * 
	 */
	  public void createWindow() {
		  
		  String[] options = {"Start Game", "Start Client", "Close"};
		  int option_select = JOptionPane.showOptionDialog(mainframe, "Start or connect to a Game", "Connect 4", 
				  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		  switch(option_select) {
		  	case JOptionPane.YES_OPTION:
		  		connectToServer = true;
		  		createConnectWindow();
		  		break;
		  	case JOptionPane.NO_OPTION:
		  		connectToClient = true;
		  		createConnectWindow();
		  		
		  		break;
		  	default:
		  		System.exit(0);
		  }
		  
	      
	   }
	 
	  
	   
	   
	  //action method which calls when button to which the ActionListened is bound to, is pressed
	  
	 
	  
	  
	  
	  public void createConnectWindow() {
		  
		  secondframe = new JFrame("Connect to Server");
		 
		  secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  //creating input fields for ip,port,name
		  ipInput = new JTextField(10);
		  portInput = new JTextField(6);
		  
		  
		  //creating headlines over the input fields, so user know which field is for which input
		  ipText = new JLabel("IP-Adress");
		  portText = new JLabel("Port Number");
		  
		  
		  
	      
		  
		  
		  //left pannel with textfields for ip/port/username
		  p1 = new JPanel();
		  p1.setLayout(new GridLayout(2, 2));
		  p1.add(ipText);
		  p1.add(portText);
		 
		  p1.add(ipInput);
		  p1.add(portInput);
		  
		  String ip;
		  String port;
	
		  int result = JOptionPane.showConfirmDialog(null, p1, 
	               "Connect to Game", JOptionPane.OK_CANCEL_OPTION);
	      
		  /*show message and optionPane while user has no input 
		   * if input is empty, show message and then optionPane again
		   * if clicked on cancel, cancel while loop and exit
		  */
		  int g = -1;
		  
	      while(g < 0) {
		  if (result == JOptionPane.OK_OPTION) {
	         
		  ip = ipInput.getText();
	      port = portInput.getText();
	    	  
	    	  		if( (ip == null || ip.isEmpty())  &&
	    			(port == null || port.isEmpty()  )){
	    	  
				    	 JOptionPane.showMessageDialog(null, "Invalid Input, Please enter again!");
				    	 
				    	 result = JOptionPane.showConfirmDialog(null, p1, 
					               "Connect to Game", JOptionPane.OK_CANCEL_OPTION);
	    	  			}
	    	  		else {
	    		  	
	    	  		
	    	  		//set playerport/ip in order for client/server to access it.	
	    	  		player.setPlayerIP(ip);
	    	  		player.setPlayerPort(port);
	    	  		
	    	  		//print input in console and create the players chosen instance as host/joiner
	    	  		g++;
	    		  	System.out.println("Ip-Adress: " + ip);
			        System.out.println("Port: " + port);
	    		  		if(connectToServer == true) {
	    		  			Server2 server = new Server2();
	    		  		}
	    		  		else if(connectToClient == true){
	    		  			Client2 client = new Client2();
	    		  		}
	    		  		else {
	    		  			
	    		  		}
	    		  			
	    	  }
	    	  }
	      
		  
	      
		  
	      if(result == JOptionPane.CANCEL_OPTION) {
	    	  System.out.println("Connection cancelled");
	    	  System.exit(0);
	      }
	  }}
		  
		  
		/*  
		  secondframe.add(p1, BorderLayout.WEST);
		  secondframe.add(connectButton, BorderLayout.EAST);
		  secondframe.setLocationRelativeTo(null);
		  secondframe.pack();
		  secondframe.setVisible(true);
		  */
	  
	
	  //save input string to string variable "username" -> next step: save to string in class Player
	  private void submitAction() {
		  
		  //f�r spieler1
		  player.setPlayername(nameInput.getText());
		  player.setPlayerIP(ipInput.getText());
		  player.setPlayerPort(portInput.getText());
	      player.printplayerInfo();
	
	      
	      //f�r spieler2
	      
	  }
	  
	  public void produceEndScreen() {
		  
		  JFrame lastframe= new JFrame();
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
