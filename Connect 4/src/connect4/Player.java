package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Player {
	
	
	
	private String playername;

	
	
	public String getPlayername() {
		
		return this.playername;
	}
	
	public void setPlayername(String username) {
		
		this.playername = username;
		
		
		
	}
	
	public void printplayername() {
		
		System.out.println("Spielername: " + playername);
	}
	
}
