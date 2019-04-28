/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * ReadExcelFileTest
 * Gets the data from an excel file (instantiate OLD_ReadExcelFile and call the method 
 * readMyExcelData). readMyExcelData returns a 2D array. The contents of the 
 * array are printed.
 * 
 * Use with OLD_ReadExcelFile.java
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 6 Dec 2017		LegoBatmanFan		Use a stack to get the data from a spreadsheet
 * 19 Dec 2017		LegoBatmanFan		The method readMyExcelData takes the file name as a parameter
 * 28 April 2019	LegoBatmanFan		Updated packages and added methods
 ************************************************************************************/

package com.legobatmanfan.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.legobatmanfan.commonactions.*;

public class ReadExcelFileTest {
	private static String FILE_DIRECTORY = System.getProperty("file.separator") + "Users"
			+ System.getProperty("file.separator") + "lenahorsley" + System.getProperty("file.separator") + "Documents"
			+ System.getProperty("file.separator") + "Lena" + System.getProperty("file.separator") + "SpreadsheetData"
			+ System.getProperty("file.separator");

	public static void main(String[] args) throws IOException {

		String excelFileName = FILE_DIRECTORY + "RandomPokemon.xlsx";
		String[][] allMyData = ReadExcelFile.readMyExcelData(excelFileName);
		int rowMax = allMyData.length;
		int colMax = allMyData[0].length;
		List<LinkedHashMap<String, String>> pokemonMap = new ArrayList<LinkedHashMap<String, String>>();

		pokemonMap = getPokeMonData(allMyData, rowMax, colMax);
		printList(pokemonMap);
	}

	public static List<LinkedHashMap<String, String>> getPokeMonData(String[][] myPokemonData, int rowMax, int colMax) {
		List<LinkedHashMap<String, String>> myMapList = new ArrayList<LinkedHashMap<String, String>>();

		for (int i = 1; i < rowMax; i++) {
			LinkedHashMap<String, String> myPokemon = new LinkedHashMap<String, String>();
			for (int j = 0; j < colMax; j++) {
				myPokemon.put(myPokemonData[0][j], myPokemonData[i][j]);
			}
			myMapList.add(myPokemon);
		}

		return myMapList;
	}

	public static void printList(List<LinkedHashMap<String, String>> myPokemonList) {
		for (int i = 0; i < myPokemonList.size(); i++) {
			for (Map.Entry<String, String> entry : myPokemonList.get(i).entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
			System.out.println("");
			System.out.println("___________________________");
		}
	}
}
