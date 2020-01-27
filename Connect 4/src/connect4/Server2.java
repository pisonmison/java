


//////////////////////


package connect4;



import java.net.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server2 {
	
	
	

	static GridTest serverGrid = new GridTest();
	
	static Socket client_socket = null;

public Server2() {
	
	System.out.println("Port ist: 9999");
	
	initServer();
}

public void initServer() {
	serverGrid.disableButtons();
	
	
	try {
		ServerSocket server = new ServerSocket(9999);
		
		
		System.out.println("server laeuft");
		System.out.println("Warte auf Client....");

		while (true) {
			
			try {
				/*f connection is made, enable buttons and let server player make the first move
				also update infoPanel to notify that he can make a move now
				*/
				client_socket = server.accept();
				System.out.println("Client verbunden! Du beginnst!");
				serverGrid.enableButtons();
				serverGrid.serverConnected = true;
				serverGrid.gamelogic.yourTurn = true;
				serverGrid.fillInfoPanel();
				while (true) {
					ObjectInputStream myinput = new ObjectInputStream(client_socket.getInputStream());
					Object mymessage = myinput.readObject();
					GridTest.gamefield = (GridArray) mymessage;
					System.out.println(mymessage);
					
					serverGrid.checkGrid();
					
					//enable players turn on serverside
					serverGrid.gamelogic.yourTurn = true;
					serverGrid.gamelogic.enemyTurn = false;
					
					serverGrid.updateGrid();
					serverGrid.enableButtons();
					
				}
			}

			catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}



public static void send2client() {

	
	
	try {
		
		
		
		ObjectOutputStream myoutput = new ObjectOutputStream(client_socket.getOutputStream());

		myoutput.writeObject(serverGrid.gamefield);
		
		serverGrid.gamelogic.yourTurn = false;
		serverGrid.gamelogic.enemyTurn = true;
		serverGrid.disableButtons();
		serverGrid.fillInfoPanel();
		
		myoutput.flush();
	} catch (Exception e) {
		System.out.println("Cannot send to CLient");
		e.printStackTrace();
	}

}


}
	
	
