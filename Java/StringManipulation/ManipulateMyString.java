/******************************************************************************************
 * LegoBatmanFan						1 June 2017
 * 
 * ManipulateMyString.java
 * Nothing too special...just some simple string manipulation.
 * 1. Convert the words to tokens and print the words in reverse.
 * 2. Print the characters in the sentence in reverse using buffer.reverse().
 * 3. Convert the sentence to a character array and print the character array in reverse.
 * 4. Print the string using recursion and no local variables
 * 5. Print the reverse string using recursion and no local variables
 * 
 * Use with ManipulateStringRecursive.java
 *-----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 *-----------------------------------------------------------------------------
 *  1 June 2017		LegoBatmanFan		Created
 * 11 June 2017		LegoBatmanFan		Added recursion
 * 27 April 2019	LegoBatmanFan		Created methods for each step
 ******************************************************************************************
 */
package com.legobatmanfan.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class ManipulateMyString {

	public static List<String> createTokens(String mySentence) {
		List<String> listOfWords = new ArrayList<String>();

		// Split the sentence into tokens and then print the number of tokens
		String[] tokens = mySentence.split(" ");
		System.out.println("The number of tokens ==> " + tokens.length);
		System.out.println("");
		System.out.println("=============================");

		System.out.println("");

		// Copy the tokens into a list
		for (String token : tokens) {
			listOfWords.add(token);
		}
		return listOfWords;
	}

	// Print the words of the sentence in reverse (use the recently created
	// list)
	public static void printWordsInReverseUsingList(List<String> myListOfWords) {
		System.out.println("1. Printing the words in reverse...");
		for (String word : myListOfWords) {
			System.out.print(word + " ");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("=============================");

	}

	public static void printWordsInReverseWithStringBuilder(StringBuilder myBuilder) {
		// Print the characters in reverse using builder.reverse()
		System.out.println("");
		System.out.println("2. The characters in reverse (using builder.reverse)...");
		System.out.println(myBuilder.reverse());
		System.out.println("");
		System.out.println("=============================");
	}
	
	public static char[] convertToCharacterArray(String mySentence){
		char[] mySentenceArray = mySentence.toCharArray();
		return mySentenceArray;
	}
	
	public static void printToCharacterArrayAndPrintInReverse(char[] mySentenceArray){
		System.out.println("");
		System.out.println("3. Convert the string to a character array and print the character array in reverse...");
		
		for (int j = mySentenceArray.length - 1; j >= 0; j--)
			System.out.print(mySentenceArray[j]);
		System.out.println("");
		System.out.println("");
		System.out.println("=============================");
	}
	
	public static void printStringRecursively(char[] mySentenceArray){
		System.out.println("");
		System.out.println("4. Print the string recursively (using the character array from a previous step)");
		ManipulateStringRecursive.printStringRecursive(mySentenceArray, mySentenceArray.length, 0);
		System.out.println("");
		System.out.println("");
		System.out.println("=============================");
	}
	
	public static void printReverseStringRecursively(char[] mySentenceArray){
		System.out.println("");
		System.out.println(
				"5. Print the reverse of the string recursively (using the character array from a previous step)");
		ManipulateStringRecursive.printReverseStringRecursive(mySentenceArray, (mySentenceArray.length - 1));
	}

}
