package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GridTest extends JFrame {

	
	
	JFrame mainWindow;
	JPanel buttonPanel, mainPanel, gridPanel, emptyPanel, panel1;
	ImageIcon emptyBox;
	
	JLabel emptyLabel;
	
	JButton arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow7;
	
	public void createGameGrid() {
		
	    //creating window and mainpanel
		
		mainWindow = new JFrame("Connect 4");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		mainPanel.add(buttonPanel, BorderLayout.NORTH);
		mainPanel.add(gridPanel, BorderLayout.SOUTH);
		mainWindow.add(mainPanel);
		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		
		
		
		
	}
	
	
	
	/*private JPanel greateOnePanel(){
		
		private String ShowPNG(String arg){
		      if (arg == null ) {
		        arg = "C:/Eclipse/workspace/ShowPNG/bin/a.png";
		      }
		}
		      
		      
	    JPanel panel = new JPanel();
	    ImageIcon icon = new ImageIcon();
	    JLabel label = new JLabel(icon);
	    panel.add(label);

	    return panel;
	}
	
	
	
	
	public  void fillGrid() {
		   
		  
		  for(int j = 0; j < 6; j++) {
		      for (int k = 0; k < 7; k++) {
		        gridPanel.add(greateOnePanel());

		      }
		    }
		}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


public GridTest() {
	createGameGrid();
	
}


public static void main(String[] args) {
    GridTest test = new GridTest();
 }

}