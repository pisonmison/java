package connect4;
import java.io.Serializable;
import java.util.Arrays;
import java.util.StringJoiner;
public  class GridArray implements Serializable {
	
	
	
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
	
	
//getter und setter
	
	
public void setArray(char box, int y, int x) {
		this.gameGridArray[y][x] = box;
		
	}
	
public char getArray(int y, int x){
	return gameGridArray[y][x];
}

	
//override toString for testing purposes, for printing the object when sent through socket in console or textarea etc.
	
@Override

public String toString(){
StringJoiner sj = new StringJoiner(System.lineSeparator());
for (char[] row : gameGridArray) {
    sj.add(Arrays.toString(row));
}
String s = sj.toString();
	return s;
	
}
	
	///////////////////////////////////
	public void printArray() {
	
	System.out.println("");
	
//print the array in console 
	for(int i = 0; i < gameGridArray.length; i++) { 
		for (int j = 0; j < gameGridArray[i].length; j++) {
			System.out.print(gameGridArray[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
	System.out.println("_____________"); // for better visual display in consoleAfter
}
	
	
	
	
	
	public static void main(String[] args) {
		
		GridArray test = new  GridArray();
	
		
	}
}