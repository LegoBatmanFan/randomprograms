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
 * 27 April 2019	LegoBatmanFan		Created
 ******************************************************************************************
 */
package com.legobatmanfan.stringmanipulation;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithStrings {
	//My sentence
	private static String sentence = "You may take Captain Solo to Jabba the Hutt after I have Skywalker";

	public static void main(String[] args) {
		
		//Initialize StringBuilder with my sentence
		StringBuilder myStringBuilder = new StringBuilder(sentence);
	
		List<String> listOfWords = new ArrayList<String>();
		
		//Print the sentence and the buffer
		System.out.printf("Here's my string ==> %s\n", sentence);
		System.out.printf("Here's the buffer ==> %s\n", myStringBuilder.toString());
		
		listOfWords = ManipulateMyString.createTokens(sentence);
		ManipulateMyString.printWordsInReverseUsingList(listOfWords);
		ManipulateMyString.printWordsInReverseWithStringBuilder(myStringBuilder);
		ManipulateMyString.printToCharacterArrayAndPrintInReverse(ManipulateMyString.convertToCharacterArray(sentence));
		ManipulateMyString.printStringRecursively(ManipulateMyString.convertToCharacterArray(sentence));
		ManipulateMyString.printReverseStringRecursively(ManipulateMyString.convertToCharacterArray(sentence));
	}

}
