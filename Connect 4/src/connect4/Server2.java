


//////////////////////


package connect4;



import java.net.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server2 {
	
	
	String ip = Player.getPlayerIP();

	static GridTest serverGrid = new GridTest();
	/*public static void main(String[] args) throws ClassNotFoundException, IOException {
				
		new Server2();
		
	}	*/
	
	static Socket client_socket = null;

public Server2() {
	
	initServer();
}

public void initServer() {
	
	
	
	try {
		ServerSocket server = new ServerSocket(83838);

		
		System.out.println("server laeuft");

		while (true) {

			try {
				client_socket = server.accept();
				serverGrid.serverConnected = true;
				
				while (true) {
					ObjectInputStream myinput = new ObjectInputStream(client_socket.getInputStream());
					Object mymessage = myinput.readObject();
					GridTest.gamefield = (GridArray) mymessage;
					System.out.println(mymessage);
					serverGrid.updateGrid();
					serverGrid.checkGrid();
					
					//enable players turn on serverside
					serverGrid.gamelogic.yourTurn = true;
					serverGrid.gamelogic.enemyTurn = false;
					
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

	
	serverGrid.gamelogic.yourTurn = false;
	serverGrid.gamelogic.enemyTurn = true;
	try {
		
		
		
		ObjectOutputStream myoutput = new ObjectOutputStream(client_socket.getOutputStream());

		myoutput.writeObject(GridTest.gamefield);
		myoutput.flush();
	} catch (Exception e) {
		System.out.println("Cannot send to CLient");
		e.printStackTrace();
	}

}


}
	
	
