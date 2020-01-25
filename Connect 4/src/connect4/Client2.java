package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Client2  {
	
	
	String ip = Player.getPlayerIP();
	 String port = Player.getPlayerPort();
	 String username = Player.getPlayerIP();
	
	
	static protected boolean connectedClient = false;
	 static GridTest clientGrid = new GridTest();
	
/*	 
	public static void main(String[] args) throws ClassNotFoundException{
	
		new Client2();	
	
	}*/
	
public Client2() {
	System.out.println("Client is started");
	GridTest.clientConnected = true;
}



public static  void sendToServer() throws ClassNotFoundException {
// hier datensendung ausführen mit actionlister, der auf die buttons von GridTest hört.	
	Socket mysocket = null;
	
	
	try {
	//send data to server	
	mysocket = new Socket("localhost",9999);
	
	ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());
	myoutput.writeObject(clientGrid.gamefield);
	System.out.println("Data was sent:");
	
	myoutput.flush();
	
	//get data from server and save it into our gamefield array
	ObjectInputStream myinput=new ObjectInputStream(mysocket.getInputStream());
	Object mymessage = myinput.readObject();
	clientGrid.gamefield = (GridArray)mymessage;
		
	mysocket.close();


	} catch (UnknownHostException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		System.out.println(e1.getMessage());
		
		
	}
	
}


public static void sendData()throws ClassNotFoundException {
	
try {
		
		
	Socket mysocket = new Socket("localhost",9999);
	ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());
	myoutput.writeObject(clientGrid.gamefield);
	System.out.println("Data was sent:");
	myoutput.flush();
	
		
	} catch (UnknownHostException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
	System.out.println(e1.getMessage());
	}
}



}

		
