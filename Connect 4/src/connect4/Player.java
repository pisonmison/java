package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Player {
	
	
	
	private String playername;
	private String playerIP;
	private String playerPort;

	
	//getting username input from user and assigning it to player
	
	public String getPlayername() {
		
		return this.playername;
		
	}
	
	public void setPlayername(String username) {
		
		this.playername = username;
		
		
		
	}
	
	//getting ip adress from user input and assigning it to the player

	public void setPlayerIP(String ipadress) {
		
		this.playerIP = ipadress;
	
	}
	
	public String getPlayerIP() {
		
		return this.playerIP;
		
		}

	
	//getting port number from user input
	
public void setPlayerPort(String portnumber) {
		
		this.playerPort = portnumber;
	
	}
	
	public String getPlayerPort() {
		
		return this.playerPort;
	}



	
	
	
	//just for testing
		public void printplayerInfo() {
			
			System.out.println("Spielername: " + playername);
			System.out.println("IP Adress of Player 1: " + playerIP);		
			System.out.println("Port Number of Player 1: " + playerPort);
		
		}
		





//füg mal hier dein zeug ein wir commiten zsm dann ist auf dem anderen lapi alles komme gerade net da ran wenn ich morgen alles reinfüge kannst du ja schnell commiten


//guck whatsapp








}