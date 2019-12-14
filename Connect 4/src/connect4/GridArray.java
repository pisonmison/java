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
	for(int i = 0; i < gameGridArray.length; i++) {
		for (int j = 0; j < gameGridArray[i].length; j++) {
			System.out.print(gameGridArray[i][j] + " ");
		}
		System.out.println("");
		
		
	}
	
}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new GridArray();
	}
}