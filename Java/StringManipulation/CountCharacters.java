
/******************************************************************************************
 * LegoBatmanFan						19 Dec 2017
 * 
 * CountCharacters.java.
 * Nothing too special...determining the number of occurrences of a character in a string.
 * 
 * Given a line of text, find the total number of occurrences of each letter of the alphabet 
 * (along with some other characters) in the text.
 * 
 * Rules:
 * 1. Upper and lower case letters should be counted together.
 * 2. Use the String method indexOf.
 * 3. Print the totals for each letter.
 *-----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 *-----------------------------------------------------------------------------
 *  19 Dec 2017		LegoBatmanFan		Created
 *  1 Aug 2018		LegoBatmanFan		Added code to count characters using for loops and a 
 *  										set
 ******************************************************************************************
 */

package StringManipulation;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCharacters {

	public static void main(String[] args) {

		String alphabet = "abcdefghijklmnopqrstuvwxyz.,!?";
		String myString = "When gone am I, the last of the Jedi will you be. The Force runs strong in your family. Pass on what you have learned.";

		int count = 0;
		int checkCharacter = 0;

		System.out.println("Letter	Occurance");
		for (int i = 0; i < alphabet.length(); i++) {
			// Using indexOf, find the first occurrence. If the letter is not in
			// the string, checkCharacter = -1
			checkCharacter = myString.toLowerCase().indexOf(alphabet.charAt(i));

			// if pos = -1 (the character is not in the string), skip this loop
			// otherwise, find the next occurrence and increment the counter.
			while (checkCharacter != -1) {
				checkCharacter = myString.toLowerCase().indexOf(alphabet.charAt(i), checkCharacter + 1);
				count++;
			}

			// print out the character in the alphabet string and the # of
			// occurrences of the character in myString
			System.out.println(alphabet.charAt(i) + " ====> " + count);
			count = 0;
		}

		System.out.println("\n");
		System.out.println("-------------------------------------------------");
		System.out.println("\n");
		System.out.println("Two for loops");
		count = 0;
		for (int j = 0; j < alphabet.length(); j++) {
			for (int k = 0; k < myString.length(); k++) {
				if (alphabet.charAt(j) == myString.charAt(k)) {
					count++;
				}
			}
			System.out.println(alphabet.charAt(j) + " ====> " + count);
			count = 0;
		}

		System.out.println("\n");
		System.out.println("-------------------------------------------------");
		System.out.println("\n");
		System.out.println("Find distinct characters...using sets");
		
		char[] myCharArray = myString.toLowerCase().toCharArray();
		Set<Character> mySet = new HashSet<Character>();
		for(char value : myCharArray){
			if(value != ' '){ 
			 mySet.add(value);
			}
		}
		
		for(char myChar : mySet){
			for (int y = 0; y < myString.length(); y++) {
				if (myChar == myString.charAt(y)) {
					count++;
				}
			}
			System.out.println(myChar + " ====> " + count);
			count = 0;
		}
	}
}
