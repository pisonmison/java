package connect4;

import java.awt.*;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.*;


import java.awt.event.ActionListener;
public class GridTest extends JFrame implements ActionListener {

	int xPos, yPos; // hier spÃ¤ter koordinaten Ã¼bergeben

	
	
	//counter per tcp übersenden jedesmal
	int counter0 = 5;
	int counter1 = 5;
	int counter2 = 5;
	int counter3 = 5;
	int counter4 = 5;
	int counter5 = 5;
	int counter6 = 5;
	
	public JFrame mainframe;
	private JPanel buttonPanel, mainPanel,emptyPanel;
	
	
	private ImageIcon emptyBox;
	private JPanel[][] gridArrayPanel = new JPanel[6][7];
	private JPanel gridPanel;
	JLabel emptyLabel;
	
	
	public JButton arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow0;
	
	static GridArray gamefield = new GridArray();
	Player player = new Player();
	GameRules gamelogic = new GameRules();
	
	//test for player color
	int playercolor = 0;
	

	public GridTest() {
		createGameGrid();
		fillGrid();
	
		

		
		
	}
	
	
	
	
	
	public  void createGameGrid() {
		
	    //creating window and mainpanel
		
		mainframe = new JFrame("Connect 4");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
		JPanel mainPanel = new JPanel();
	    
	    gridPanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    
	    
	    //mache das layout der einzelnen bereiche
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
		
		
		emptyBox = new ImageIcon("emptyBox.png"); 
	    emptyLabel = new JLabel(emptyBox); 
	    emptyPanel = new JPanel();
		
		
		
		
		
		
		
	   
		
		
		
		
		mainPanel.add(gridPanel, BorderLayout.CENTER);
	    mainPanel.add(buttonPanel, BorderLayout.NORTH);
	 
	    
		//insert the main panel into the frame
	    mainframe.add(mainPanel);
		mainframe.setSize(700,600);
	    
		mainframe.setLocationRelativeTo(null);
		mainframe.setVisible(true);
		mainframe.setResizable(true);
		
		
		
		
		
	}
	

	

	
	////rgb blauer hingergrund: R: 30 ,G: 144, B: 255

	
	public void fillGrid() {
	    
		
		for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {
	    		  
	    	  		
	    	  		JLabel label = new JLabel("");
		 	    	Image img = new ImageIcon(this.getClass().getResource("/emptyBox.png")).getImage();
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
	 
			gridPanel.removeAll();
					
			
			
			
		   if(GameRules.playerSwitch == true && yPos >= 0 ){//true for red
			   gamefield.setArray('0', yPos, xPos);
		  }
		   else if(GameRules.playerSwitch == false && yPos >= 0) {//false for yellow
			   gamefield.setArray('X', yPos, xPos);
		   }
		   
		   
		   GameRules.playerSwitch = !GameRules.playerSwitch;
		   
		   
		   updateGrid();
		   GridTest.gamefield.printArray();
	  
	}    

		 

	
	
	

	
	/////////////////timer funktion/////////////////
	/* prüft ob gewonnen oder net 0.5sec nach farbsetzung
	 * falls win/draw/ -> schliese gamegrid und öffne neue fenster, zeige jeweils spieler win/lose/draw an*/
	 
	public void checkGrid() {		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                GameRules.winCheck();
		                if(GameRules.check == true) {
		                	
		                
		                mainframe.dispose();
		                
		                //erstelle win/lose/draw
		                }
		            }
		        }, 
		        10 // 10 milliseconds -> prevents timer bug of when buttons are clicked several times in under the defined number.
		);
		
	}
			

		
		/////////////////action events for button input
	
	 public void actionPerformed(ActionEvent e) {
	       

		 
		 if(e.getSource() == arrow0) {
	    	   xPos = 0;
	    	   yPos = counter0;
	    	   insertColor();
	    	   counter0--;
	    	   
	    	   checkGrid();
	    	   
	    	   
	       }
	       else if(e.getSource() == arrow1) {
	    	   
	    	   
	    	   xPos = 1;
	    	   yPos = counter1;
	    	   insertColor();
	    	   counter1--;
	    	   checkGrid();
	    	   
	       }
	       else if(e.getSource() == arrow2) {
	    	   
	    	   xPos = 2;
	    	   yPos = counter2;
	    	   insertColor();
	    	   counter2--;
	    	   checkGrid();
	    	   
	    	   
	       }
	       else if(e.getSource() == arrow3) {
	    	   

	    	   xPos = 3;
	    	   yPos = counter3;
	    	   insertColor();
	    	   counter3--;
	    	   checkGrid();
	    	
	    	
	       }
	       else if(e.getSource() == arrow4) {
	    	   
	    	   xPos = 4;
	    	   yPos = counter4;
	    	   insertColor();
	    	   counter4--;
	    	   checkGrid();
	    	
	    	   
	    	   
	       }
	       else if(e.getSource() == arrow5) {
	    	   
	    	
	    	   xPos = 5;
	    	   yPos = counter5;
	    	   insertColor();
	    	   counter5--;
	    	   checkGrid();
	    	  
	    	   
	       }
	       else if(e.getSource() == arrow6) {
	    	   
	    	   xPos = 6;
	    	   yPos = counter6;
	    	   insertColor();
	    	   counter6--;
	    	   checkGrid();
	    	  
	    	   
	    	   
	       }
	 }
	  
		
		
		
	 
	 
	 
	 
	 
	 
	 
	 
	 

	

	
	
/////// hier funktion zum updaten des spielfeldes, es wird jedesmal erneut gemalt
public void updateGrid() {
	
	
	for(int j = 0; j < 6; j++) {
		for (int k = 0; k < 7; k++) {
  
	    	char box = gamefield.getArray(j, k);
	    	
	    	//insert red boxes where 0 is in gamefield array	
	    	
	    	if(box == '0') { /// hier spielerfarbe + kooardinaten abfragen
	  		  
	    		//insert the created image labels into the grid array until full
	    		JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/redBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	gridArrayPanel[j][k] = new JPanel();
		    	gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
		       
		        
	    		}
	    	//insert yellow boxes where X is in gamefield array	
	    	else if(box == 'X') {
	    		JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/yellowBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	gridArrayPanel[j][k] = new JPanel();
		    	gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
	    		
	    		
	    	}
    
	    	//insert emtpy boxes where - is in gamefield array	
	  	  else {
	  		  //spieler 2
	  		  
	  		  
	  		  
	  		  
		    	//create a label and add an image from the "img folder" into them. 
		    	JLabel label = new JLabel("");
		    	Image img = new ImageIcon(this.getClass().getResource("/emptyBox.png")).getImage();
		    	label.setIcon(new ImageIcon(img));
		    	
		    	
		    	
		    	//insert the created image labels into the grid array until full
		    	gridArrayPanel[j][k] = new JPanel();
		       
		        gridArrayPanel[j][k].setBackground((new Color(30, 144, 255)));
		        gridArrayPanel[j][k].add(label);
		        gridPanel.add(gridArrayPanel[j][k]);
	  	  } 
    	
    } 
    

}

	

	
	gridPanel.revalidate();
	gridPanel.repaint();
    
}




public static void main(String[] args) {
    GridTest test = new GridTest();
    
 }

}