package connect4;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Grid extends JFrame {

   private  JFrame mainWindow;
   private JButton firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow,sixthArrow, seventhArrow; 
   //= new JButton("Drop");
   //private JPanel[][] gridArray = new JPanel[6][7];
   private JPanel gridPanel, mainPanel, buttonPanel;
   private JLabel emptyLabel, redLabel, blackLabel;
   private JPanel emptyPanel, redPanel, blackPanel;
   private ImageIcon emptyBox, redBox, blackBox;
   
  

  public void createGrid() {
    
	/*create 2 different panels for the grid and the buttons
	the main panel is for  containing the 2 panels mentioned above*/
	mainPanel = new JPanel();
    gridPanel = new JPanel();
    buttonPanel = new JPanel();

   
    //set layout of panels
    mainPanel.setLayout(new BorderLayout());
    gridPanel.setLayout(new GridLayout(6, 7));
    buttonPanel.setLayout(new GridLayout(1, 7));
    mainPanel.setBackground(new Color(23, 13, 44));

    //add empty box picture into imageicon, add the icon in the label
   
    emptyBox = new ImageIcon("emptyBox.png"); 
    emptyLabel = new JLabel(emptyBox); 
    emptyPanel = new JPanel();
    emptyPanel.add(emptyLabel);

    //add panels into the main panel
    mainPanel.add(gridPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.NORTH);
    gridPanel.add(emptyPanel);

   //add the 7 buttons to the button panel above the grid
    buttonPanel.add(firstArrow);
    buttonPanel.add(secondArrow);
    buttonPanel.add(thirdArrow);
    buttonPanel.add(fourthArrow);
    buttonPanel.add(fifthArrow);
    buttonPanel.add(sixthArrow);
    buttonPanel.add(seventhArrow);
    
    
    
   
    //creating the main frame
    mainWindow = new JFrame("Connect Four");
    mainWindow.setContentPane(mainPanel);
    mainWindow.setSize(846, 730);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
   // mainWindow.setResizable(false);

  }
 

  /*
  //create a new panel and add a picture and a label to it
  private JPanel greateOnePanel(){
	    JPanel panel = new JPanel();
	    ImageIcon icon = new ImageIcon("emptybox.jpg");
	    JLabel label = new JLabel(icon);
	    panel.add(label);

	    return panel;
	}
  
  
  /* insert the created panel above and cycle through a loop, filling the grid with empty boxes
  until the grid is filled out*/
 /* public  void fillGrid () {
	   
	  
	  for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {
	        gridPanel.add(greateOnePanel());

	      }
	    }
	}
  
  
  

*/


public static void main(String[] args) {
    Grid tst = new Grid();
   
    
    


}

}