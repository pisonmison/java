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
   private JPanel[][] gridArray = new JPanel[6][7];
   private JPanel gridPanel, mainPanel, buttonPanel;
   private JLabel emptyLabel, redLabel, blackLabel;
   private JPanel emptyPanel, redPanel, blackPanel;
   private ImageIcon emptyBox, redBox, blackBox;
   
  

  public  void createGrid() {
    mainPanel = new JPanel();
    gridPanel = new JPanel();
    buttonPanel = new JPanel();

    mainPanel.setLayout(new BorderLayout());
    gridPanel.setLayout(new GridLayout(6, 7));
    buttonPanel.setLayout(new GridLayout(1, 7));
    mainPanel.setBackground(new Color(23, 13, 44));

    emptyBox = new ImageIcon("emptyBox.jpg"); 
    emptyLabel = new JLabel(emptyBox); 
    emptyPanel = new JPanel();
    emptyPanel.add(emptyLabel);

    mainPanel.add(gridPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.NORTH);
    gridPanel.add(emptyPanel);

    buttonPanel.add(firstArrow);
    buttonPanel.add(secondArrow);
    buttonPanel.add(thirdArrow);
    buttonPanel.add(fourthArrow);
    buttonPanel.add(fifthArrow);
    buttonPanel.add(sixthArrow);
    buttonPanel.add(seventhArrow);
    
    
    
    

    mainWindow = new JFrame("Connect Four");
    mainWindow.setContentPane(mainPanel);
    mainWindow.setSize(846, 730);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
    mainWindow.setResizable(false);

  }

  private JPanel greateOnePanel(){
	    JPanel panel = new JPanel();
	    ImageIcon icon = new ImageIcon("emptybox.jpg");
	    JLabel label = new JLabel(icon);
	    panel.add(label);

	    return panel;
	}
  
  
  public  void fillGrid () {
	   
	  
	  for(int j = 0; j < 6; j++) {
	      for (int k = 0; k < 7; k++) {
	        gridPanel.add(greateOnePanel());

	      }
	    }
	}
  
  
  




public static void main(String[] args) {
    Grid tst = new Grid();//create a new instance of your class
    
    


}

}