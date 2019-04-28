/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * TriangleType
 * Performs a few checks
 * firstCheckForBadData: check for empty strings or the number zero.
 * convertStringToNumber: convert the string to a double
 * classifyTriangle: determine the triangle type
 * 
 * Use with TriangleTypeTest.java
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 19 Dec 2017		LegoBatmanFan		Minor modifications
 * 28 April 2019	LegoBatmanFan		Updated packages and methods. Added method
 * 											to check for numeric strings
 ************************************************************************************/

package com.legobatmanfan.misc;

import java.util.ArrayList;
import java.util.List;



public class TriangleType {
	
	//check for empty strings or the number zero. return a different message for each condition: empty
	//string, one side has a length of zero, no bad data entered (no empthy strings or sides with a length
	//of zero.
	public static String firstCheckForBadData(String sideOneLength, String sideTwoLength, String sideThreeLength){
		String dataCheckMessage = "";
		List<Double> triangleSides = new ArrayList<Double>();
		
		//check for empty strings
		if (sideOneLength.isEmpty() | sideTwoLength.isEmpty() | sideThreeLength.isEmpty()){
			dataCheckMessage = "empty string/bad data entered";
		} else if(!checkIfStringIsNumber(sideOneLength) | !checkIfStringIsNumber(sideTwoLength) | !checkIfStringIsNumber(sideThreeLength)){
			dataCheckMessage = "one or more entered strings is not numeric";
		}
		else{
			//if there are no empty strings, convert the strings to doubles. make sure the length is not zero.
			triangleSides = convertStringToNumber(sideOneLength, sideTwoLength, sideThreeLength);
			if (triangleSides.get(0) <= 00.00 | triangleSides.get(1) <= 00.00 | triangleSides.get(2) <= 00.00){
				dataCheckMessage = "bad data: one or more of the values is less than or equal to zero";
			}
			else{
				dataCheckMessage = "data checks passed";
			}
		}
		return dataCheckMessage;
	}
	
	
	//convert the strings to doubles, add them to a list and return the list
	public static List<Double> convertStringToNumber(String length1, String length2, String length3){
		List<Double> sides = new ArrayList<Double>();
		
		Double side1 = Double.parseDouble(length1);
		Double side2 = Double.parseDouble(length2);
		Double side3 = Double.parseDouble(length3);
		
		sides.add(side1);
		sides.add(side2);
		sides.add(side3);
		return sides;
	}
	
	
	//if the data check passes, classify the triangle and return the type
	//equilateral: all sides equal
	//isosceles: two sides equal
	//scalene: all sides have different lengths
	public static String classifyTriangle(List<Double> triangleSide){
		String triangleClassification = "";
		
		Double sideOneLength = triangleSide.get(0);
		Double sideTwoLength = triangleSide.get(1);
		Double sideThreeLength = triangleSide.get(2); 
		
		if((sideOneLength.equals(sideTwoLength)) && (sideTwoLength.equals(sideThreeLength)) && (sideThreeLength.equals(sideOneLength))){
			triangleClassification = "equilateral";
		}
		else if((sideOneLength.equals(sideTwoLength)) || (sideTwoLength.equals(sideThreeLength)) || (sideThreeLength.equals(sideOneLength))){
			triangleClassification = "isosceles";
		}
		else {
			triangleClassification = "scalene";
		}
		return triangleClassification;
	}
	
	public static Boolean checkIfStringIsNumber(String myString){
		boolean isNumeric = myString.chars().allMatch( Character::isDigit );
		
		return isNumeric;
	}
}
