package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Client2 implements ActionListener  {
	private static char [][] spot = new char [6][7];
	GridTest game = new GridTest();
	public static void main(String[] args){
	
		new Client2();	
	
	}
	
public Client2() {
	
	
}
	
public static  void init() {
// hier datensendung ausf�hren mit actionlister, der auf die buttons von GridTest h�rt.	
try {


		Socket mysocket = new Socket("localhost",9999);
		ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());
		myoutput.writeObject(GridTest.gamefield);
		System.out.println("Data was sent:");
		myoutput.flush();
		mysocket.close();
	
		

	} catch (UnknownHostException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		System.out.println(e1.getMessage());
		//fall wenn client net connected -> dann server aufrufen.
		
	}// meine IP und eine freie Port
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
/*try {
		
		
		
		ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());
		myoutput.writeObject(GridTest.gamefield);
		System.out.println("Data was sent:");
		myoutput.flush();
	
		
	} catch (UnknownHostException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		System.out.println(e1.getMessage());
		//fall wenn client net connected -> dann server aufrufen.
		
	}// meine IP und eine freie Port
	*/
}
}
	

		
