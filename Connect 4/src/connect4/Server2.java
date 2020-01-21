


//////////////////////


package connect4;

import javax.swing.*;

import java.net.*;
import java.awt.Component;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server2 {
	
	static protected ObjectOutputStream myoutput;
	GridTest grid;
	static Socket s;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
				
		new Server2();
		
	}	
	
	
public Server2() throws ClassNotFoundException, IOException {
	init();
}

public void init(){
	try {
	GridTest grid = new GridTest();
	ServerSocket server=new ServerSocket(9999);//port öfnnen listen und Verbindungen akzeptieren
	
	while(true) {
	Socket mysocket= server.accept();
	
	
	ObjectInputStream myinput=new ObjectInputStream(mysocket.getInputStream());
	Object mymessage = myinput.readObject();
	GridTest.gamefield = (GridArray)mymessage; //-<< save object into gamefield
	System.out.println(mymessage);
	System.out.println("Data recieved...");
	grid.updateGrid();
	mysocket.close();
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
	
	
