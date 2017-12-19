/******************************************************************************************
 * LegoBatmanFan						19 Dec 2017
 * 
 * GenerateSentences.java.
 * Nothing too special...generate some sentences.
 * 
 * Use random-number generation to create sentences.
 *
 * 
 * Rules:
 * 1. Use four arrays of strings: article, noun, verb, preposition.
 * 2. Create a sentence by randomly selecting a word in each array.
 * 3. The sentence structure: article-noun-verb-preposition-article-noun
 * 4. Concatenate the words into a sentence where the words are separated by spaces.
 * 5. The sentence should start with a capital letter and end with a period.
 * 6. Print 20 sentences.
 * 
 * The arrays
 * article: the, a, one, some, any
 * noun: boy, girl, dog, town, car
 * verb: drove, jumped, ran, walked, skipped
 * preposition: to, from, over, under, on
 *-----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 *-----------------------------------------------------------------------------
 *  19 Dec 2017		LegoBatmanFan		Created
 ******************************************************************************************
 */

package StringManipulation;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import CommonActions.ReadExcelFile;

public class GenerateSentences {

	public static void main(String[] args) throws IOException {

		ReadExcelFile myExcelFile = new ReadExcelFile();
		String mySentenceFile = "//Users//lenahorsley//Documents//Lena//SpreadsheetData//generateSentences.xlsx";
		
		//read the data into a two-dimensional array and get the dimensions
		String[][] mySentenceData = myExcelFile.readMyExcelData(mySentenceFile);
		int rowMax = mySentenceData.length;
		int colMax = mySentenceData[0].length;
		
		//a stack
		Stack<String> mySentenceStack = new Stack<String>();
		
		//the sentence
		String sentence = "";
		
		//strings for the fragments
		String firstWord, myNoun001, myNoun002, myArticle001, myArticle002, myVerb, myPreposition;
		
		//the arrays
		String noun[] = new String[5];
		String verb[] = new String[5];
		String article[] = new String[5];
		String preposition[] = new String[5];
		
		for(int i = 0; i < rowMax; i++){
			//Go through each row and push the word onto the stack.
			for(int j = 0; j < colMax; j++){
				mySentenceStack.push(mySentenceData[i][j]);
			}
			
			//Pop the words off the stack and store the words in strings.
			preposition[i] =  mySentenceStack.pop();
			verb[i] = mySentenceStack.pop();
			noun[i] = mySentenceStack.pop();
			article[i] = mySentenceStack.pop();
		}
		
		//Create the sentence.
		System.out.println(" ");
		System.out.println("===============================================");
		System.out.println(" ");
		for (int k = 0; k < 20; k++){
			//Using the article array...
			//create the first fragment and capitalize it. Concatenate sentence and myArticle001.
			myArticle001 = generateFragment(article);
			firstWord = myArticle001.substring(0, 1).toUpperCase() + myArticle001.substring(1);
			sentence = sentence + firstWord + " ";
			
			//Generate the 2nd fragment using the noun array. Concatenate sentence and myNoun001.
			myNoun001 = generateFragment(noun);
			sentence = sentence + myNoun001 + " ";
			
			//Generate the 3rd fragment using the verb array. Concatenate sentence and myVerb. 
			myVerb = generateFragment(verb);
			sentence = sentence + myVerb + " ";
			
			//Generate the 4th fragment using the preposition array. Concatenate sentence and myPreposition.
			myPreposition = generateFragment(preposition);
			sentence = sentence + myPreposition + " ";
			
			//Generate the 5th fragment using the preposition article. Concatenate sentence and myArticle002.
			myArticle002 = generateFragment(article);
			sentence = sentence + myArticle002 + " ";
			
			//Generate the final fragment using the noun array. Concatenate sentence and myNoun002.
			myNoun002 = generateFragment(noun);
			sentence = sentence + myNoun002 + ".";
			
			//Print the sentence
			System.out.println("sentence #"+ (k + 1) + ": " + sentence);
			sentence = "";
		}
		
	}
	
	//Create the sentence fragment using a random number.
	public static String generateFragment(String myArray[]){
		Random randomNum = new Random();
		int index = 0;
		
		//Generate the random number.
		index = randomNum.nextInt(myArray.length);
		
		//Using the random number, return the word at the index.
		return(myArray[index]);
	}

}
