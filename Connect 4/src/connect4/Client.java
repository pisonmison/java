package connect4;

import javax.swing.*;

import java.net.*;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {

	 public static void main(String[] args) {
	      Display test = new Display();
	      Player player = new Player();
	      GridArray gamefield = new GridArray();
	      Client cliente= new Client();
	      Server servidor= new Server();
	      MarcoCliente mimarco=new MarcoCliente();
			
			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      
	   }

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("CLIENTE");
		
		add(texto);
	//test
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				Socket misocket=new Socket("192.168.0.193",9999);
				
				DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());	
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}// meine IP und eine freie Port
		}
	}
	
	
		
		
	private JTextField campo1;
	
	private JButton miboton;
	
}