/************************************************************************************************
 * LegoBatmanFan														12 July 2018
 * 
 * 
 * AddStringNumbers.java
 * 
 * How it works: Take an array of numbers:
 * 1. Convert the array to a string
 * 2. Convert the string to an integer
 * 3. Add 1
 * 4. Convert to a string
 * 5. Convert to a number array
 * --------------------------------------------------------------------------------------
 * Modification History
 * Date              Author					Description
 * 12 July 2018      LegoBatmanFan			Date created
 * 2 Aug 2018		 LegoBatmanFan			Minor corrections
 * 28 April 2019	 LegoBatmanFan			Updated packages and added methods
 ************************************************************************************************/

package com.legobatmanfan.stringmanipulation;

public class AddStringNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int myNumbers[] = {1,5,0,0,0};
		String numberString = "";
		int stringToInteger;
		int newNumber;
		String integerToString = "";
		int numberFromExponents;
		
		numberString = printNumbersAsString(myNumbers);
		stringToInteger = changeStringToInteger(numberString);
		newNumber = addOneToNewNumber(stringToInteger);
		integerToString = convertIntegerToString(newNumber);
		convertStringToCharArray(integerToString, myNumbers);
		
		printDivider();
		
		numberString = "";
		stringToInteger = 0;
		newNumber = 0;
		integerToString = "";
		
		numberFromExponents = getNumberAsUsingExponentFunction(myNumbers);
		newNumber = addOneToNewNumber(numberFromExponents);
		integerToString = convertIntegerToString(newNumber);
		convertStringToCharArray(integerToString, myNumbers);
	}

	public static String printNumbersAsString(int[] myArrayOfNumbers){
		String myNumberString = "";
		for (int i = 0; i < myArrayOfNumbers.length; i++){
			myNumberString = myNumberString + Integer.toString(myArrayOfNumbers[i]);
		}
		System.out.println("The array of numbers as a string ==> " + myNumberString);
		return myNumberString;
	}
	
	public static int changeStringToInteger(String myNumberString){
		int stringToNumber = Integer.parseInt(myNumberString);
		System.out.println("Now, the string is a number (integer) ==> " + stringToNumber);
		
		return stringToNumber;
	}
	
	public static int addOneToNewNumber(int myNumber){
		int newNumber = myNumber + 1;
		System.out.println("Adding 1 to the number (integer) ==> " + newNumber);
		
		return newNumber;
	}
	
	public static String convertIntegerToString(int myInteger){
		String newNumberString = Integer.toString(myInteger);
		System.out.println("The new number as a string ==> " + newNumberString);
		
		return newNumberString;
	}
	
	public static void convertStringToCharArray(String myNewNumberString, int[] myOriginalArrayOfNumbers){
		int myNewArray[] = new int[myOriginalArrayOfNumbers.length];
		char[] newArray = myNewNumberString.toCharArray();
		System.out.println("The size of the array ==> " + newArray.length);
		for(int j = 0; j < newArray.length; j++){
			myNewArray[j] = newArray[j] - '0';
		}
		
		System.out.println("Back to an array of numbers ==> ");
		for (int k = 0; k < myNewArray.length; k++){
			System.out.println("index#: " + k + "  Number: " + myNewArray[k]); 
		}
	}
	
	public static void printDivider(){
		System.out.println("\n");
		System.out.println("================================================");
		System.out.println("\n");
	}
	
	public static int getNumberAsUsingExponentFunction(int[] myArrayOfNumbers){
		int total = 0;
		int exponent = myArrayOfNumbers.length - 1;
		System.out.println("Let's try something new...get the numbers using exponents");
		for (int k = 0; k < myArrayOfNumbers.length; k++){
			total =  total + (myArrayOfNumbers[k] * ( (int) Math.pow(10, exponent)));
			System.out.println(myArrayOfNumbers[k] + " X 10 ^ " + exponent + " = " + (myArrayOfNumbers[k] * ( (int) Math.pow(10, exponent))));
			exponent--;
		}
		System.out.println("The number..." + total);
		
		return total;
	}
}
