/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * TriangleTypeTest
 * 1. Get user input and display the entered data
 * 2. Check for bad data. If the data check passes, classify the triangle
 * 		If the data check fails, print a failure message. There are different
 * 		message for empty strings and entering zeros. Error handling for characters 
 * 		was not implemented.
 * 
 * Use with TriangleType.java
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 19 Dec 2017		LegBatmanFan		Minor modifications
 ************************************************************************************/

package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TriangleTypeTest {

	public static void main(String[] args) {
		TriangleType myTriangleTest = new TriangleType();				//create the TriangleType object	
		List<Double> myTriangleData = new ArrayList<Double>();			//the list for the side data
		Scanner userInput = new Scanner(System.in);						//for user input
		String answer1 = "";
		String answer2 = "";
		String answer3 = "";
		
		//Get the user input
		System.out.println("Enter length of 1st side ==> ");
		answer1 = userInput.nextLine();
		System.out.println("Enter length of 2nd side ==> ");
		answer2 = userInput.nextLine();
		System.out.println("Enter length of 3nd side ==> ");
		answer3 = userInput.nextLine();
		System.out.println("");
		
		//Show the user the entered data
		System.out.println("you entered: " + answer1 + ", " + answer2 
				+ ", and " + answer3 + "...");
		
		userInput.close();
		
		//Check the data
		String checkDataMessage = myTriangleTest.firstCheckForBadData(answer1, answer2, answer3);
		
		if(checkDataMessage == "data checks passed"){		
			System.out.println(checkDataMessage);
			
			//If the data check passes, classify the triangle and print out the message
			myTriangleData = myTriangleTest.convertStringToNumber(answer1, answer2, answer3);
			String classification  = myTriangleTest.classifyTriangle(myTriangleData);
			System.out.println("Triangle type: " + classification);
		}
		else{
			//If the data check failed, print out the failure message
			System.out.println(checkDataMessage);
		}
	}

}
