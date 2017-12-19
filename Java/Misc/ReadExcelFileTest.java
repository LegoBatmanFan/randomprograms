/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * ReadExcelFileTest
 * Gets the data from an excel file (instantiate ReadExcelFile and call the method 
 * readMyExcelData). readMyExcelData returns a 2D array. The contents of the 
 * array are printed.
 * 
 * Use with ReadExcelFile.java
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 6 Dec 2017		LegoBatmanFan		Use a stack to get the data from a spreadsheet
 * 19 Dec 2017		LegoBatmanFan		The method readMyExcelData takes the file name as a parameter
 ************************************************************************************/

package Misc;

import java.io.IOException;
import java.util.Stack;

import CommonActions.ReadExcelFile;



public class ReadExcelFileTest {

	public static void main(String[] args) throws IOException {
		//Create the ReadExcelFile object.
		ReadExcelFile readExcelFile = new ReadExcelFile();					
		
		String excelFileName = "//Users//lenahorsley//Documents//Lena//SpreadsheetData//RandomPokemon.xlsx";
		//Get the spreadsheet data.
		String pokemonName, weight, height, type001, type002, type003;
		
		Stack<String> stack = new Stack<String>();
		int pokedexNum, numberSeen, numberCaught;
		String[][] allMyData = readExcelFile.readMyExcelData(excelFileName);
		int rowMax = allMyData.length;
		int colMax = allMyData[0].length;
		
		
		
		/******************************************
		 * Print out the data for the spread sheet in the following format (for each pokemon):
		 * pokemon #20
		 * 1. Pokedex Number: 218 
		 * 2. Pokemon: Slugma
		 * 3. Number seen: 52
		 * 4. Number caught: 43
		 * 5. Weight: 35.0 kg
		 * 6. Height: 0.7 m
		 * 7. Type 1: FIRE
		 * 8. Type 2: NULL
		 * 9. Type 3: LAVA
		 ******************************************/
		
		for(int i = 0; i < rowMax; i++){
			for(int j = 0; j < colMax; j++){
				//Put the values on a stack
				stack.push(allMyData[i][j]);
			}
			System.out.println("-------------------------------------------------------------------");
			
			//Pop each value off the stack and save it to a variable
			type003 = stack.pop();
			type002 = stack.pop();
			type001 = stack.pop();
			height = stack.pop();
			weight = stack.pop();
			numberCaught = Integer.parseInt(stack.pop());
			numberSeen = Integer.parseInt(stack.pop());	
			pokemonName = stack.pop();	
			pokedexNum = Integer.parseInt(stack.pop());	
			
			//Print out the values
			System.out.println("pokemon #" + (i+1));						
			System.out.println("	Pokedex Number: " + pokedexNum);																											
			System.out.println("	Pokemon: " + pokemonName);			
			System.out.println("	Number seen: " + numberSeen);																						
			System.out.println("	Number caught: " + numberCaught);							
			System.out.println("	Weight: " + weight);																
			System.out.println("	Height: " + height);				
			System.out.println("	Type 1: " + type001);															
			System.out.println("	Type 2: " + type002);								
			System.out.println("	Type 3: " + type003);					
			System.out.println("");
			System.out.println("");
			
		}
	}

	
}

