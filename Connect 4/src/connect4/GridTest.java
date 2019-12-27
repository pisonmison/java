package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.awt.event.ActionListener;
public class GridTest extends JFrame implements ActionListener {

	int xPos, yPos; // hier später koordinaten übergeben

	int counter0 = 5;
	int counter1 = 5;
	int counter2 = 5;
	int counter3 = 5;
	int counter4 = 5;
	int counter5 = 5;
	int counter6 = 5;
	
	private JFrame mainframe;
	private JPanel buttonPanel, mainPanel,emptyPanel;
	
	
	private ImageIcon emptyBox, whiteBox;
	private JPanel[][] gridArrayPanel = new JPanel[6][7];
	private JPanel gridPanel;
	JLabel emptyLabel;
	
	private char[][] spielfeld;
	static JButton arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow0;
	
	GridArray gamefield = new GridArray();
	Player player = new Player();
	
	//test for player color
	int playercolor = 0;
	
	public GridTest() {
		createGameGrid();
		fillGrid();
	//	insertColor(); //just for testing and understanding

		
		
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
	//bevor du pushsr/commit erstmal ausf�hren! dann nimmt er �nderungen wahr.verstehe
	//hier erste testfunktion zum einsetzen roter/gelber farbe
	
	public void insertColor() {
	 
		
	
	 
	  gridPanel.removeAll();
  	 	
		  
	  if(playercolor == 0 && yPos >= 0)
		  {//0 for red
		  gamefield.setArray('0', yPos, xPos);
		  
		  
		  
		  
		  
		 
	  
  	  
	   }
	   updateGrid();
	  	 gamefield.printArray();
	  
	}    
		       
		        
		        
		    	
		      
		    	
		
		/////////////////action events for button input
	
	 public void actionPerformed(ActionEvent e) {
	       if(e.getSource() == arrow0) {
	    	   xPos = 0;
	    	   yPos = counter0;
	    	   insertColor();
	    	   counter0--;
	    	  
	       }
	       else if(e.getSource() == arrow1) {
	    	   
	    	   
	    	   xPos = 1;
	    	   yPos = counter1;
	    	   insertColor();
	    	   counter1--;
	    	   
	       }
	       else if(e.getSource() == arrow2) {
	    	   
	    	   xPos = 2;
	    	   yPos = counter2;
	    	   insertColor();
	    	   counter2--;
	    	   
	    	   
	       }
	       else if(e.getSource() == arrow3) {
	    	   

	    	   xPos = 3;
	    	   yPos = counter3;
	    	   insertColor();
	    	   counter3--;
	    	   
	       }
	       else if(e.getSource() == arrow4) {
	    	   
	    	   xPos = 4;
	    	   yPos = counter4;
	    	   insertColor();
	    	   counter4--;
	    	   
	    	   
	       }
	       else if(e.getSource() == arrow5) {
	    	   
	    	
	    	   xPos = 5;
	    	   yPos = counter5;
	    	   insertColor();
	    	   counter5--;
	    	   
	       }
	       else if(e.getSource() == arrow6) {
	    	   
	    	   xPos = 6;
	    	   yPos = counter6;
	    	   insertColor();
	    	   counter6--;
	    	   
	    	   
	       }
	 }
	  
		
		
		
	 
	 
	 
	 
	 
	 
	 
	 
	 

	

	
	
/////// hier funktion zum updaten des spielfeldes, es wird jedesmal erneut gemalt
public void updateGrid() {
	
	
	for(int j = 0; j < 6; j++) {
		for (int k = 0; k < 7; k++) {
  
	    	char box = gamefield.getArray(j, k);
	    	
	    	
	    	
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