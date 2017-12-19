
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
 ******************************************************************************************
 */

package StringManipulation;

public class CountCharacters {

	public static void main(String[] args) {
		

		String alphabet = "abcdefghijklmnopqrstuvwxyz.,!?";
		String myString = "When gone am I, the last of the Jedi will you be. The Force runs strong in your family. Pass on what you have learned.";

		int count = 0;
		int pos = 0;

		System.out.println("Letter	Occurance");
		for (int i = 0; i < alphabet.length(); i++) {
			//Using indexOf, find the first . If the letter is not in the string, pos = -1
			pos = myString.toLowerCase().indexOf(alphabet.charAt(i));
			
			//if pos = -1 (the character is not in the string), skip this loop
			//otherwise, find the next occurrence and increment the counter.
			while (pos != -1) {
				pos = myString.toLowerCase().indexOf(alphabet.charAt(i), pos + 1);
				count++;
			}
			
			//print out the character in the alphabet string and the # of occurrences of the character in myString
			System.out.println(alphabet.charAt(i) + "	" + count);
			count = 0;
		}
	}

}
