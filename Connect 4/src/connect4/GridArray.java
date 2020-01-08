package connect4;

public  class GridArray {
	
	
	
	 char[][] gameGridArray =  {
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},  //spielfeld
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'}};
	public  GridArray() {
		printArray();
	}
	
	
	///////////////////////////////////
	//getter und setter
	
	
public void setArray(char box, int y, int x) {
		this.gameGridArray[y][x] = box;
		
	}
	
public char getArray(int y, int x){
	return gameGridArray[y][x];
}

	
	
	
	
	
	///////////////////////////////////
	public void printArray() {
	
	System.out.println("");
	
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
	
	public void insertInto(int yPos, int xPos) {
		
		
		
		
		
		gameGridArray[yPos][xPos] = '0'; // testfunktion um etwas einzuf�gen
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		GridArray test = new  GridArray();
	
		
	}
}