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
 * 28 April 2019	LegoBatmanFan		Updated packages and added methods
 ******************************************************************************************
 */

package com.legobatmanfan.stringmanipulation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import com.legobatmanfan.commonactions.*;

public class GenerateSentences {
	private static String FILE_DIRECTORY = System.getProperty("file.separator") + "Users"
			+ System.getProperty("file.separator") + "lenahorsley" + System.getProperty("file.separator") + "Documents"
			+ System.getProperty("file.separator") + "Lena" + System.getProperty("file.separator") + "SpreadsheetData"
			+ System.getProperty("file.separator");

	public static void main(String[] args) throws IOException {

		String mySentenceFile = FILE_DIRECTORY + "generateSentences.xlsx";

		Map<String, String[]> myFragments = new HashMap<String, String[]>();
		String[] fragmentOrder = { "article", "noun", "verb", "preposition", "article", "noun" };

		myFragments = CreateFragment.getFragmentsFromExcel(mySentenceFile);
		for (int i = 0; i < 20; i++) {
			CreateFragment.createSentenceUsingFragments(fragmentOrder, myFragments, i);
		}
	}

	static class CreateFragment {
		public static Map<String, String[]> getFragmentsFromExcel(String myDataFile) throws IOException {
			String[][] mySentenceData = ReadExcelFile.readMyExcelData(myDataFile);
			Map<String, String[]> myCollectionOfFragments = new HashMap<String, String[]>();
			int rowMax = mySentenceData.length;
			int colMax = mySentenceData[0].length;
			Stack<String> mySentenceStack = new Stack<String>();

			String noun[] = new String[5];
			String verb[] = new String[5];
			String article[] = new String[5];
			String preposition[] = new String[5];

			int index = 0;
			for (int i = 1; i < rowMax; i++) {
				for (int j = 0; j < colMax; j++) {
					mySentenceStack.push(mySentenceData[i][j]);
				}

				// Pop the words off the stack
				preposition[index] = mySentenceStack.pop();
				verb[index] = mySentenceStack.pop();
				noun[index] = mySentenceStack.pop();
				article[index] = mySentenceStack.pop();
				index++;
			}

			myCollectionOfFragments.put("preposition", preposition);
			myCollectionOfFragments.put("verb", verb);
			myCollectionOfFragments.put("noun", noun);
			myCollectionOfFragments.put("article", article);

			return myCollectionOfFragments;
		}

		public static String generateFragment(String myArray[]) {
			Random randomNum = new Random();
			int index = 0;

			// Generate the random number.
			index = randomNum.nextInt(myArray.length);

			// Using the random number, return the word at the index.
			return (myArray[index]);
		}

		public static void createSentenceUsingFragments(String[] fragmentList, Map<String, String[]> fragmentArrays,
				int sentenceNumber) {
			String sentence = "";
			for (int i = 0; i < fragmentList.length; i++) {
				String[] fragmentType = fragmentArrays.get(fragmentList[i]);
				if (i == 0) {
					String myFirstFragment = generateFragment(fragmentType);
					sentence = myFirstFragment.substring(0, 1).toUpperCase() + myFirstFragment.substring(1) + " ";
				}

				sentence = sentence + generateFragment(fragmentType);
				if(i == fragmentList.length - 1){
					sentence += ".";
				} else {
					sentence += " ";
				}
			}
			System.out.println((sentenceNumber+1) + ": " + sentence);
		}
	}
}
