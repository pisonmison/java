package connect4;

import java.awt.event.*;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseEvent {

	public static void main(String[] args) {
	
	MarcoRaton mimarco = new MarcoRaton();
	
	mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}

class MarcoRaton extends JFrame{
	
	public MarcoRaton() {
		
		setVisible(true);
		
		setBounds(700,300,600,450);
		
		EventMouse MouseEvent = new EventMouse();
		
		addMouseListener(MouseEvent);
				
	}
}

class EventMouse implements MouseListener {

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		System.out.println("Clicked");
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		System.out.println("pressed");
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}