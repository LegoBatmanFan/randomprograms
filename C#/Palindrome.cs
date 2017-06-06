using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 ************************************************************************************************************
 * Lego Batman Fan                  24 May 2017
 * Palindrome (use with the file PalindromeChecks.cs)
 * This little program determines if two strings are palindromes. A few rules:
 * 1. If one or both of the strings are blank, flagString = false. 
 * 2. It the strings are not the same length, flagString = false.
 * 3. The characters in the string are sorted in alphabetical order. If the strings do not contain the same
 *      characters, flagString = false.
 * 4. If the reverse of first string is not the same as second string (which has not been altered), 
 *      flagString = false.
 * 
 * An instance of PalindromeChecks (the object palindromeTest) is created. The two strings are passed into four methods:
 *      CheckForEmptyString
 *      CheckStringLength
 *      CheckStringCharacters
 *      CheckReverseString
 * 
 * Each method returns a flag. the flags are then passed into the method CheckFlags.
 * If any of the flags are false, print a message staing the strings are not palindromes.
 * Else, print a message stating the strings are palindromes.
 ************************************************************************************************************
 */

namespace ConsoleApplication1
{
	class Palindrome
	{
		static void Main(string[] args)
		{
			PalindromeChecks palindromeTest = new PalindromeChecks();
			Boolean emptyStringFlag, stringLengthFlag, stringCharacterFlag, reverseStringFlag;

			Console.WriteLine("Hello Lego Batman");
			Console.WriteLine("Now give me two strings and I will determine if they are palindromes..");
			Console.Write("String #1: ");
			string string001 = Console.ReadLine();
			Console.Write("String #2: ");
			string string002 = Console.ReadLine();
			Console.WriteLine("You entered: ");
			Console.WriteLine(string001);
			Console.WriteLine("AND");
			Console.WriteLine(string002);
			Console.WriteLine("");

			Console.WriteLine("============================================");
			//Check the for empty strings
			emptyStringFlag = palindromeTest.CheckForEmptyString(string001, string002);
			Console.WriteLine("");
			Console.WriteLine("============================================");
			//Compare the length of both strings
			stringLengthFlag = palindromeTest.CompareStringLengths(string001, string002);
			Console.WriteLine("");
			Console.WriteLine("============================================");
			//Sort and compare the characters in each string 
			stringCharacterFlag = palindromeTest.SortAndCompareStringCharacters(string001, string002);
			Console.WriteLine("");
			Console.WriteLine("============================================");
			//Reverse the first string and compare it to the second string
			reverseStringFlag = palindromeTest.CompareReverseString(string001, string002);
			Console.WriteLine("");
			Console.WriteLine("============================================");
			//Check all of the flags and print the appropriate message
			palindromeTest.CheckFlags(emptyStringFlag, stringLengthFlag, stringCharacterFlag, reverseStringFlag);
			Console.WriteLine("");
			Console.WriteLine("============================================");
			Console.Read();
		}
	}
}

