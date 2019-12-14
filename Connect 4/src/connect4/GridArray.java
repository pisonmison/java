package connect4;

public class GridArray {
	
	
	public GridArray() {
		createArray();
	}
	
	
	
	public void createArray() {
	char[][] gameGridArray =  {
	{'-','-', '-', '-', '-', '-', '-'},
	{'-','-', '-', '-', '-', '-', '-'},
	{'-','-', '-', '-', '-', '-', '-'},  //spielfeld
	{'-','-', '-', '-', '-', '-', '-'},
	{'-','-', '-', '-', '-', '-', '-'},
	{'-','-', '-', '-', '-', '-', '-'}};
	
	
	//array mit - füllen und jweils "0" oder "X" für farbe einsetzen und dann kann man rechnen
	// i ist y-achse von oben nach unten(umgekehrt also)
	//j ist x -achse von links nach rechts
	//schaut euch google bilder von 2D array(array von arrays) an um zu verstehen!!!
	for(int i = 0; i < gameGridArray.length; i++) {
		for (int j = 0; j < gameGridArray[i].length; j++) {
			System.out.print(gameGridArray[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
	System.out.println("_____________"); // zum visuellen trennen von spielfeldern in der konsole
}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new GridArray();
	}
}