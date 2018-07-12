package StringManipulation;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AddStringNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String numberString = "";
		int myNumbers[] = {1,5,0,0,0};
		int myNewArray[] = new int[myNumbers.length];
		int myNewArray001[] = new int[myNumbers.length];
		String myNumber = Arrays.toString(myNumbers);
		System.out.println("The numbers as a string ==> " + myNumber);
		for (int i = 0; i < myNumbers.length; i++){
			numberString = numberString + Integer.toString(myNumbers[i]);
		}
		System.out.println("The array of numbers as a string ==> " + numberString);
		
		int stringToNumber = Integer.parseInt(numberString);
		System.out.println("Now, the string is a number (integer) ==> " + stringToNumber);
		
		int newNumber = stringToNumber + 1;
		System.out.println("Adding 1 to the number (integer) ==> " + newNumber);
		
		String newNumberString = Integer.toString(newNumber);
		System.out.println("The new number as a string ==> " + newNumberString);
		
		char[] newArray = newNumberString.toCharArray();
		System.out.println("The size of the array ==> " + newArray.length);
		for(int j = 0; j < newArray.length; j++){
			myNewArray[j] = newArray[j] - '0';
		}
		
		System.out.println("Back to an array of numbers ==> ");
		for (int k = 0; k < myNewArray.length; k++){
			System.out.println("index#: " + k + "  Number: " + myNewArray[k]); 
		}
		
		System.out.println("\n");
		System.out.println("================================================");
		System.out.println("\n");
		
		int total = 0;
		int exponent = myNumbers.length - 1;
		System.out.println("Let's try something new...");
		for (int k = 0; k < myNumbers.length; k++){
			total =  total + (myNumbers[k] * ( (int) Math.pow(10, exponent)));
			exponent--;
		}
		System.out.println("The number..." + total);
		
		int newNumber001 = total + 1;
		System.out.println("Adding 1 to the number (integer) ==> " + newNumber001);
		
		char[] newArray001 = newNumberString.toCharArray();
		System.out.println("The size of the array ==> " + newArray001.length);
		for(int j = 0; j < newArray001.length; j++){
			myNewArray001[j] = newArray001[j] - '0';
		}
		
		System.out.println("Back to an array of numbers ==> ");
		for (int k = 0; k < myNewArray001.length; k++){
			System.out.println("index#: " + k + "  Number: " + myNewArray001[k]); 
		}
	}

}
