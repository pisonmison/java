package connect4;

import java.awt.*;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.TimerTask;

import javax.swing.*;


import java.awt.event.ActionListener;
public final  class GridTest extends JFrame implements ActionListener {

	
	
	
	//decalare needed components
	int xPos; 

	private JFrame mainframe;
	private JPanel buttonPanel, mainPanel,emptyPanel;
	
	
	private ImageIcon emptyBox;
	private JPanel[][] gridArrayPanel = new JPanel[6][7];
	private JPanel gridPanel;
	JLabel emptyLabel;
	 Timer timer;
	
	private JButton arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow0;
	static boolean clientConnected = false;
	boolean serverConnected = false;
	protected static GridArray gamefield = new GridArray();
	
	GameRules gamelogic = new GameRules();
	
	


	

	//create a grid and fill it with empty white boxes when contructor is called
	public GridTest() {
		createGameGrid();
		fillGrid();

		

		
		
	}
	

	
	/*
	 * Create the mainframe for our GUI
	 * add the panels for button and the grid
	 * add components to it and make it visible
	 */
	public  void createGameGrid() {
		
	    
		
		mainframe = new JFrame("Connect 4");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
		JPanel mainPanel = new JPanel();
	    
	    gridPanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    
	    
	    //layout of the panels
	    mainPanel.setLayout(new BorderLayout());
	    gridPanel.setLayout(new GridLayout(4, 5));
	    buttonPanel.setLayout(new GridLayout(1, 5));
	  
		
		
		
		
		
		//defining top panel with 7 buttons;
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 7));
		
		arrow0 = new JButton("0");
		arrow1 = new JButton("1");
		arrow2 = new JButton("2");
		arrow3 = new JButton("3");
		arrow4 = new JButton("4");
		arrow5 = new JButton("5");
		arrow6 = new JButton("6");
		
		//adding actionlisteners to button;
		arrow0.addActionListener((ActionListener) this);
		arrow1.addActionListener((ActionListener) this);
		arrow2.addActionListener((ActionListener) this);
		arrow3.addActionListener((ActionListener) this);
		arrow4.addActionListener((ActionListener) this);
		arrow5.addActionListener((ActionListener) this);
		arrow6.addActionListener((ActionListener) this);
		
		//add buttons to buttonpanel
		buttonPanel.add(arrow0);
		buttonPanel.add(arrow1);
		buttonPanel.add(arrow2);
		buttonPanel.add(arrow3);
		buttonPanel.add(arrow4);
		buttonPanel.add(arrow5);
		buttonPanel.add(arrow6);
		
		
		
		
		//create Grind Panel
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(6,7));
		
	
	
		
		//add panels to mainpanel 
		mainPanel.add(gridPanel, BorderLayout.CENTER);
	    mainPanel.add(buttonPanel, BorderLayout.NORTH);
	 
	    
		//insert the main panel into the frame
	    mainframe.add(mainPanel);
		mainframe.setSize(700,600);
	    
		mainframe.setLocationRelativeTo(null);
		mainframe.setVisible(true);
		mainframe.setResizable(true);
		
		
		
		
		
	}
	

	

	
	//rgb blue background: R: 30 ,G: 144, B: 255

	//fill the grid with empty white box images to represent an empty game field
	public void fillGrid() {
	    
		
		for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {
	    		  
	    	  		//get png image from folder, save it into and image, save image into label, add label to the GridArrayPanel(42 labels)
	    	  		JLabel label = new JLabel("");
		 	    	Image img = new ImageIcon(this.getClass().getResource("/img/emptyBox.png")).getImage();
		 	    	label.setIcon(new ImageIcon(img));
		 	    	
		 	    	
	    	 
	    	 
	    		  
		 	    	//insert the created image labels into the grid array until full
		 	    	gridArrayPanel[j][k] = new JPanel();
		 	       
		 	        gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		 	        
		 	        gridArrayPanel[j][k].add(label);
		 	        gridPanel.add(gridArrayPanel[j][k]);
	    	  
	    	
		 	        gridPanel.revalidate();
	}
		}
	}

	
	
	
	public void insertColor() {
	 
			
			/*insert the corresponding symbol for color (X, 0) into our gamefield array	
			 * if its the players turn. 
			 * Irritate through array and check how many red/yellow symbols exist
			 * if red > yellow -> next insert is yellow
			 * if yellow > red -> next insert is red
			 * this way we dont need to send color data through sockets.
			 */
			
			
			
		   if(gamelogic.yourTurn == true) {
				int as=0, bs=0;
				for(int i=0;i<gamefield.gameGridArray.length;i++) {
					for(int j=0;j<gamefield.gameGridArray[0].length;j++) {
						if(gamefield.gameGridArray[i][j]=='0') {
							as++;
						}
						else if(gamefield.gameGridArray[i][j]=='X') {
							bs++;
						}
					}
				}
				if(as>bs) {
					gamefield.setArray('X', xPos);
				}
				else {
					gamefield.setArray('0', xPos);
				}
		   }
		   
		 
		   
		   updateGrid();
		  //update grid after inserting color, so the insert appears in the gui
	  
	}    

		 

	
	
	

	
	
	/* 
	 * check via gamerules methods if a win has happened
	 * make it 10ms after inserting colors into array, so the methods are 
	 * applied. Timer is needed to check on actual game state after the insert has already happened
	 * without timer it will call check and insert at the same time.
	*/
	 
	public void checkGrid() {		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                GameRules.winCheck();
		                GameRules.roundsPlayed++;
		                if(GameRules.check == true) {
		                	
		                
		                mainframe.dispose();
						
		                //endscreen
		                
		                //System.exit(0);
		                
		                
		                }
		            }
		        }, 
		        10 /*10 milliseconds -> prevents timer bug of when buttons are clicked
		         several times in under the defined number.*/
		);
		
	}
			

		
/*action events for button clicks, which call all the needed methods
	
	*xPos represents the x position of the buttons to insert into right column
	*on click we also send data by calling corresponding methods from client/server
	*/
	
	 public void actionPerformed(ActionEvent e) {
	       

		 
		 if(e.getSource() == arrow0) {
	    	   xPos = 0;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       }
	       else if(e.getSource() == arrow1) {
	    	   
	    	   
	    	   xPos = 1;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       }
	       else if(e.getSource() == arrow2) {
	    	   
	    	   xPos = 2;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   
	       }
	       else if(e.getSource() == arrow3) {
	    	   

	    	   xPos = 3;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	       }
	       else if(e.getSource() == arrow4) {
	    	   
	    	   xPos = 4;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   
	       }
	       else if(e.getSource() == arrow5) {
	    	   
	    	
	    	   xPos = 5;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 
				}
	    	   
	       
	       else if(e.getSource() == arrow6) {
	    	   
	    	   xPos = 6;
	    	   insertColor();
	    	   checkGrid();
	    	   try {
				callDataMethods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  
	    	  
	    	   
	    	   
	       }
	 }
	  
		
/*
 * check if actual gui is a clientGUI or a serverGUI
 * and based on result, it calls the corresponding methods for sending the array objects
 */
public void callDataMethods() throws ClassNotFoundException {
	
if(clientConnected == true) {
	System.out.println("Clientmethod was called");
	Client2.sendToServer();

}
 else if(serverConnected == true) {
	System.out.println("Servermethod was called");
	Server2.send2client();
}

 else {
	 System.out.println("No Connection atm...");
 }
}
	 
	 
	
	 
	 
	 
	 
	 
	 

	

	
	
/*
 * updates the grid by repainting it and filling it again with image labels
 * it checks the whole GridArray in the background for its symbols and  adds the
 * corresponding images into our panel array. 0 for red, X for yellow, - for empty
 */
public void updateGrid() {
	gridPanel.removeAll();
	
	for(int j = 0; j < 6; j++) {
		for (int k = 0; k < 7; k++) {
  
	    	char box = gamefield.getArray(j, k);
	    	
	    	//insert red boxes where 0 is in gamefield array	
	    	
	    	if(box == '0') { /// hier spielerfarbe + kooardinaten abfragen
	  		  
	    		//insert the created image labels into the grid array until full
	    		JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/img/redBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	gridArrayPanel[j][k] = new JPanel();
		    	gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
		       
		        
	    		}
	    	//insert yellow boxes where X is in gamefield array	
	    	else if(box == 'X') {
	    		JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/img/yellowBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	gridArrayPanel[j][k] = new JPanel();
		    	gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
	    		
	    		
	    	}
    
	    	
	  	  else {
	  		  
	  		  	//insert empty boxes where colors arent set
	  		  
	  		  
	  		  
		    	//create a label and add an image from the "img folder" into them. 
		    	JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/img/emptyBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	
		    	//insert the created image labels into the grid array until full
		    	gridArrayPanel[j][k] = new JPanel();
		       
		        gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
	  	  } 
    	
    } 
    

}

	

	/*repaint and revalidate everytime 
	 * when components are changed, deleted and added to the panel
	 */
	gridPanel.revalidate();
	gridPanel.repaint();
    
}








}