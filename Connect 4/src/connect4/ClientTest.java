package connect4;

import javax.swing.*;

import java.net.*;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientTest {

	static protected ObjectOutputStream myoutput;
	
	
	 public static void main(String[] args) {
	     
	  ClientTest client = new ClientTest();
	      
	      //test
	   }



public ClientTest() {
	System.out.println("Client is connected");
    Window window1=new Window();
		
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
class Window extends JFrame{
	
	public Window(){
		
		setBounds(600,300,280,350);
				
		WindowClient winClient=new WindowClient();
		
		add(winClient);
		
		setVisible(true);
		}	
	
}

class WindowClient extends JPanel{
	
	public WindowClient(){
	
		JLabel texto=new JLabel("CLIENT");
		
		add(texto);
	
		
	
				
	
		mybutton=new JButton("Send");
		
		SendText textfield= new SendText();
		
		mybutton.addActionListener(textfield);
		
		add(mybutton);	
		
	}
	
private class SendText implements ActionListener{
	
	/*
	 * GridArray field = new GridArray
	 * field.getArray();
	 * 
	 *  wenns static is
	 *  GridArray.getArray();
	*/
	
		
		public void actionPerformed(ActionEvent e) {
			//System.out.println(campo1.getText());
			try {
				Socket mysocket=new Socket("192.168.56.1",9999);
				System.out.println("Data was sent..");
				ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());	
				
				myoutput.writeObject(GridTest.gamefield);
				
				myoutput.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}// meine IP und eine freie Port
		}
	}
	
	
		//asd

private JTextField field1;
	
private JButton mybutton;
	
}}