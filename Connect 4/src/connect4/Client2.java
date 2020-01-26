package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Client2  {
	
	//get strings from user input in the connect window
	 String ip = Player.getPlayerIP();
	 String port = Player.getPlayerPort();
	 
	
		static Socket server = null;
	

	 static GridTest clientGrid = new GridTest();
	//call the game GUI instance in the client

	 
	//
public Client2() {
	System.out.println("Client is started");
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


//wait for incoming data from server
// if data is sent, client updates istself and checks the grid.
public void receive() {

	try {
		server = new Socket("localhost", 8086);
		
		while (true) {

			try {
				ObjectInputStream myinput = new ObjectInputStream(server.getInputStream());
				Object mymessage = myinput.readObject();
				
				GridTest.gamefield = (GridArray) mymessage;
				clientGrid.updateGrid();
				clientGrid.checkGrid();
				
				//if no win happened, enable the client to make his turn
				//in order for the endscreens to work properly the booleans are set after checking for wins
				
				clientGrid.gamelogic.yourTurn = true;
				clientGrid.gamelogic.enemyTurn = false;
				
						
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

		
