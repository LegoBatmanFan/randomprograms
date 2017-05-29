using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 ************************************************************************************************************
 * Lego Batman Fan                  24 May 2017
 * PalindromeChecks (use with the file Palindrome.cs).
 * This little program determines if two strings are palindromes. A few rules:
 * 1. If one or both of the strings are blank, flagString = false. 
 * 2. It the strings are not the same length, flagString = false.
 * 3. The characters in the string are sorted in alphabetical order. If the strings do not contain the same
 *      characters, flagString = false.
 * 4. If the reverse of first string is not the same as second string (which has not been altered), 
 *      flagString = false.
 * 
 * This class contains four methods:
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
	class PalindromeChecks
	{
		//If one or both strings are empty, print a message and then return false. 
		//Else, print a message saying that the strings are not empty and return true
		public Boolean CheckForEmptyString(string emptyStringMaybe001, string emptyStringMaybe002)
		{
			if (emptyStringMaybe001 == "" | emptyStringMaybe002 == "")
			{
				Console.WriteLine("one or both strings are blank");
				return false;
			}
			else
			{
				Console.WriteLine("no empty strings");
				return true;
			}
		}

		//Check the length of both strings. If the strings are not the same length, print a message 
		//stating the strings are different lengths and return false.
		//Else, print a message saying the strings are the same length and return true.
		public Boolean CompareStringLengths(string howLongIsThisString001, string howLongIsThisString002)
		{
			Console.WriteLine("length of the 1st string: " + howLongIsThisString001.Length);
			Console.WriteLine("length of the 2nd string: " + howLongIsThisString002.Length);
			Console.WriteLine("");
			if (howLongIsThisString001.Length == howLongIsThisString002.Length)
			{
				Console.WriteLine("both strings are the same length");
				return true;
			}
			else
			{
				Console.WriteLine("the strings are different lengths");
				return false;
			}
		}

		//Sort both strings alphabetically. If the strings contain the same characters (they are the same),
		//print a message stating so and return true. 
		//Else, print a message stating the strings are different and return false.
		public Boolean SortAndCompareStringCharacters(string checkCharsInThisString001, string checkCharsInThisString002)
		{
			char[] newCharArray001 = checkCharsInThisString001.ToArray();
			char[] newCharArray002 = checkCharsInThisString002.ToArray();

			Array.Sort(newCharArray001);
			Array.Sort(newCharArray002);

			string sortedString001 = new string(newCharArray001);
			string sortedString002 = new string(newCharArray002);

			Console.WriteLine("first string: " + checkCharsInThisString001);
			Console.WriteLine("first string sorted: " + sortedString001);
			Console.WriteLine("");
			Console.WriteLine("second string: " + checkCharsInThisString002);
			Console.WriteLine("second string sorted: " + sortedString002);
			Console.WriteLine("");

			if (sortedString001 == sortedString002)
			{
				Console.WriteLine("strings contain the same characters");
				return true;
			}
			else
			{
				Console.WriteLine("strings do not contain the same characters");
				return false;
			}
		}

		//Reverse the first string. If the reverse of the first string is the same as the second string 
		//(unaltered), print a message stating the strings are the same and return true.
		//Else, print a message stating the strings are different and return false.
		public Boolean CompareReverseString(string originalString001, string originalString002)
		{
			var reverseStringBuilder = new StringBuilder();
			for (int i = originalString001.Length - 1; i >= 0; i--)
			{
				reverseStringBuilder.Append(originalString001[i]);
			}

			string reverseString = reverseStringBuilder.ToString();
			Console.WriteLine("the first string: " + originalString001);
			Console.WriteLine("the second string: " + originalString002);
			Console.WriteLine("the reverse of the first string: " + reverseString);
			Console.WriteLine("");

			if (reverseString == originalString002)
			{
				Console.WriteLine("the reverse and forward strings are the same");
				return true;
			}
			else
			{
				Console.WriteLine("the reverse and forward strings are different");
				return false;
			}
		}

		//Check all of the flags. If any of the flags are false, print a message staing the strings are not palindromes.
		//Else, print a message stating the strings are palindromes.
		public void CheckFlags(Boolean emptyStringTest, Boolean stringLengthTest, Boolean stringCharacterTest, Boolean reverseStringTest)
		{
			if (!emptyStringTest | !stringLengthTest | !stringCharacterTest | !reverseStringTest)
			{
				Console.WriteLine("the strings are not palindromes");
			}
			else
			{
				Console.WriteLine("the strings are palindromes");
			}
		}
	}
}


