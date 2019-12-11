package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GridTest extends JFrame {

	
	
	private JFrame mainframe;
	private JPanel buttonPanel, mainPanel,emptyPanel;
	
	
	private ImageIcon emptyBox, whiteBox;
	private JPanel[][] gridArray = new JPanel[6][7];
	private JPanel gridPanel;
	JLabel emptyLabel;
	
	
	static JButton arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow7;
	
	public GridTest() {
		createGameGrid();
		fillGrid();
		
		
	}
	
	
	
	
	
	
	
	
	
	public  void createGameGrid() {
		
	    //creating window and mainpanel
		
		mainframe = new JFrame("Connect 4");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//mainPanel = new JPanel();
		//mainPanel.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
	    
	    gridPanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    
	    
	    //mache das layout der einzelnen bereiche
	    mainPanel.setLayout(new BorderLayout());
	    gridPanel.setLayout(new GridLayout(6, 7));
	    buttonPanel.setLayout(new GridLayout(1, 7));
	  
		
		
		
		
		
		//defining top panel with 7 buttons;
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 7));
		
		arrow1 = new JButton("V");
		arrow2 = new JButton("V");
		arrow3 = new JButton("V");
		arrow4 = new JButton("V");
		arrow5 = new JButton("V");
		arrow6 = new JButton("V");
		arrow7 = new JButton("V");
		
		buttonPanel.add(arrow1);
		buttonPanel.add(arrow2);
		buttonPanel.add(arrow3);
		buttonPanel.add(arrow4);
		buttonPanel.add(arrow5);
		buttonPanel.add(arrow6);
		buttonPanel.add(arrow7);
		
		
		
		//create Grind Panel
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(6,7));
		
		
		emptyBox = new ImageIcon("emptyBox.png"); 
	    emptyLabel = new JLabel(emptyBox); 
	    emptyPanel = new JPanel();
		
		
		
		
		
		
		
	   
		
		
		
		
		mainPanel.add(gridPanel);
	    mainPanel.add(buttonPanel, BorderLayout.NORTH);
	    
		//insert the main panel into the frame
	    mainframe.add(mainPanel);
		mainframe.setSize(600,600);
		mainframe.setLocationRelativeTo(null);
		mainframe.setVisible(true);
		mainframe.setResizable(true);
		
		
		
		
	}
	
	
	
	
	
	
	

	
	public void fillGrid() {
	    
		
		for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {
	        
	    	 JLabel label = new JLabel("test");
	    	 

	    	gridArray[j][k] = new JPanel();
	       
	        gridArray[j][k].setBackground(Color.RED);
	        gridArray[j][k].add(label,BorderLayout.CENTER);
	        gridPanel.add(gridArray[j][k]);
	        

	      }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	





public static void main(String[] args) {
    GridTest test = new GridTest();
    
 }

}