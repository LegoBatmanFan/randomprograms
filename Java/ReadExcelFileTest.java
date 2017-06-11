import java.io.IOException;

/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * ReadExcelFileTest
 * Gets the data from an excel file (instantiate ReadExcelFile and call the method 
 * readMyExcelData). readMyExcelData returns a 2D array. The contents of the 
 * array are printed.
 * 
 * Use with ReadExcelFile.java
 ************************************************************************************/

public class ReadExcelFileTest {

	public static void main(String[] args) throws IOException {
		//Create the ReadExcelFile object.
		ReadExcelFile readExcelFile = new ReadExcelFile();					
		
		//Get the spreadsheet data.
		String[][] allMyData = readExcelFile.readMyExcelData();
		
		int n = 0;	//for the columns
		
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
		
		for(int m = 0; m < allMyData.length; m++){
			System.out.println("-------------------------------------------------------------------");
			String pokedexNum = allMyData[m][n];							//Get the pokedex.
			n++;															//Increment the counter - for move to next column.
			System.out.println("pokemon #" + (m+1));						//This is the line # in the spreadsheet.
			System.out.println(n + ". Pokedex Number: " + pokedexNum);		//Print the pokedex #.
		
			
			String pokemonName = allMyData[m][n];							//Get the name.		
			n++;															//Increment the counter.
			System.out.println(n + ". Pokemon: " + pokemonName);			//Print the name.
			
			
			int numberSeen = Integer.parseInt(allMyData[m][n]);				//Get the number of pokemon seen.
			n++;															//Increment the counter.
			System.out.println(n + ". Number seen: " + numberSeen);			//Print the value.
			
			int numberCaught = Integer.parseInt(allMyData[m][n]);			//Get the number of pokemon caught.
			n++;															//Increment the counter - for move to next column.
			System.out.println(n + ". Number caught: " + numberCaught);		//Print the value.
			
			String weight = allMyData[m][n];								//Get the weight.
			n++;															//Increment the counter.
			System.out.println(n + ". Weight: " + weight);					//Print the value.
			
			String height = allMyData[m][n];								//Get the height.
			n++;															//Increment the counter.
			System.out.println(n + ". Height: " + height);					//Print the value.
			
			String type001 = allMyData[m][n];								//Get the type.
			n++;															//Increment the counter.
			System.out.println(n + ". Type 1: " + type001);					//Print the value.
			
			String type002 = allMyData[m][n];								//Get the type.
			n++;															//Increment the counter.
			System.out.println(n + ". Type 2: " + type002);					//Print the value.
			
			String type003 = allMyData[m][n];								//Get the type.
			n++;															//Increment the counter.
			System.out.println(n + ". Type 3: " + type003);					//Print the value.
			System.out.println("");
			System.out.println("");
			n = 0;	//Set n to 0, so that you start on the first column in the next row.
		}
		//}
	}

	
}

