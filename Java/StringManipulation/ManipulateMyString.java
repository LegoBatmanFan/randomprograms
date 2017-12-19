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
 ******************************************************************************************
 */
package StringManipulation;
import java.util.ArrayList;
import java.util.List;



public class ManipulateMyString {

	public static void main(String[] args) {
		
		//My sentence
		String sentence = "You may take Captain Solo to Jabba the Hutt after I have Skywalker";
				
		//Initialize StringBuilder with my sentence
		StringBuilder buffer = new StringBuilder(sentence);
	
		ManipulateStringRecursive recursiveStrings = new ManipulateStringRecursive();
		
		List<String> listOfWords = new ArrayList<String>();
		
		//Print the sentence and the buffer
		System.out.printf("Here's my string ==> %s\n", sentence);
		System.out.printf("Here's the buffer ==> %s\n", buffer.toString());
		
		//Split the sentence into tokens and then print the number of tokens
		String[] tokens = sentence.split(" ");
		System.out.println("The number of tokens ==> " + tokens.length);
		System.out.println("");
		System.out.println("=============================");
	
		System.out.println("");
		
		//Copy the tokens into a list
		for(String token : tokens){
			listOfWords.add(token);
		}
		
		//Print the words of the sentence in reverse (use the recently created list)
		System.out.println("1. Printing the words in reverse...");
		for(int i = listOfWords.size() - 1; i >=0; i--){
			System.out.print(listOfWords.get(i) + " ");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("=============================");
		
		//Print the characters in reverse using buffer.reverse()
		System.out.println("");
		System.out.println("2. The characters in reverse (using buffer.reverse)...");
		System.out.println(buffer.reverse());
		System.out.println("");
		System.out.println("=============================");
		
		//Convert the sentence to a character array and print the character array in reverse
		System.out.println("");
		System.out.println("3. Convert the string to a character array and print the character array in reverse...");
		char[] sentenceArray = sentence.toCharArray();
		for(int j = sentenceArray.length - 1; j >=0; j--)
			System.out.print(sentenceArray[j]);
		System.out.println("");
		System.out.println("=============================");
		
		//Using the character array from above, print the string and it's reverse string recursively
		System.out.println("");
		System.out.println("4. Print the string recursively (using the character array from a previous step)");
		recursiveStrings.printStringRecursive(sentenceArray, sentenceArray.length, 0);
		System.out.println("");
		System.out.println("");
		System.out.println("=============================");
		System.out.println("");
		System.out.println("5. Print the reverse of the string recursively (using the character array from a previous step)");
		recursiveStrings.printReverseStringRecursive(sentenceArray, (sentenceArray.length-1));
	}

}
