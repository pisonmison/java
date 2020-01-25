


//////////////////////


package connect4;



import java.net.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server2 {
	
	
	

	GridTest serverGrid = new GridTest();
	/*public static void main(String[] args) throws ClassNotFoundException, IOException {
				
		new Server2();
		
	}	*/
	
	
public Server2() {
	
	initServer();
}

public void initServer() {
	
	
	
	try {
		ServerSocket server=new ServerSocket(9999);
		
		System.out.println("Server gestartet \n");
		serverGrid.serverConnected = true;		
		runit(server);
		
        
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@SuppressWarnings("static-access")
public void runit(ServerSocket server) throws IOException{
	
	//server gets data from client1, saves it into his array, then sends server array to client2 + client1
	
	while(true) {
	
	Socket mysocket= server.accept();
	try {
	ObjectInputStream myinput=new ObjectInputStream(mysocket.getInputStream());
	Object mymessage = myinput.readObject();
	serverGrid.gamefield = (GridArray)mymessage; //-<< save object into gamefield
	//System.out.println(mymessage);
	//
	serverGrid.updateGrid();
	
	ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());
	myoutput.writeObject(mymessage); //send gotten massage from client 1 to client 2 somehow
	System.out.println("Data was sent:");
	myoutput.flush();
	
	}
	
 catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}



}
	
	
