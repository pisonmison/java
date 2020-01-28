package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Client2  {
	
	//get strings from user input in the connect window
	 String gottenIp  = Player.getPlayerIP();
	 String gottenPort = Player.getPlayerPort();
	 int port = 9999;//Integer.parseInt(gottenPort);
	 
	
		static Socket server = new Socket();
	

	 static GridTest clientGrid = new GridTest();
	//call the game GUI instance in the client

	 
	//
public Client2() {
	init();
	System.out.println("Client is started");
	clientGrid.disableButtons();
	GridTest.clientConnected = true;
	this.receive();
}



public static  void sendToServer() throws ClassNotFoundException {
// send data to server in this method
// we call this method by clicking buttons on game grid
	
	try {
		// send data to server
		
		clientGrid.gamelogic.yourTurn = false;
		clientGrid.gamelogic.enemyTurn = true;
		clientGrid.disableButtons();
		clientGrid.fillInfoPanel();
		
		ObjectOutputStream myoutput = new ObjectOutputStream(server.getOutputStream());
		myoutput.writeObject(GridTest.gamefield);
		System.out.println("Data was sent:");
		

		myoutput.flush();

	} catch (UnknownHostException e1) {
		e1.printStackTrace();
	} catch (IOException e1) {
		System.out.println(e1.getMessage());
	}

	
}

void init() {
	clientGrid.disableButtons();
	while(true) {
	try {
		server = new Socket(gottenIp, port);
		clientGrid.fillInfoPanel();
		server.close();
		break;
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Warte auf Verbindung...");
		
	}
}
}
//wait for incoming data from server
// if data is sent, client updates istself and checks the grid.
public void receive() {

	try {
		server = new Socket(gottenIp, port);
		clientGrid.gamelogic.yourTurn = true;
		while (true) {
			
			try {
				ObjectInputStream myinput = new ObjectInputStream(server.getInputStream());
				Object mymessage = myinput.readObject();
				
				GridTest.gamefield = (GridArray) mymessage;
				System.out.println(mymessage);
				clientGrid.updateGrid();
				clientGrid.checkGrid();
				
				//if no win happened, enable the client to make his turn
				//in order for the endscreens to work properly the booleans are set after checking for wins
				
				
				
				clientGrid.enableButtons();
						
			}
			catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
}

}

		
